package com.ssy.netty.thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by Administrator on 2019/1/15.
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {


    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 接收客户端消息 并转发给其他客户端
     *
     * @param ctx 上下文
     * @param msg 消息
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        channelGroup.forEach(ch -> {
            if (ch != channel) {
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息: " + msg + "\n");
            } else {
                ch.writeAndFlush("[自己] " + msg + "\n");
            }
        });
    }

    /**
     * 客户端订阅
     * <p>
     * 需求: 当[新客户端]上线时, 通知其他[客户端], 这个[新客户端]上线了, 但不通知[新客户端]他自己
     * 自己想法:
     * 1. 定义一个全局List, 用于存储channel, 但此时先不存
     * 2. 遍历list, 调用writeAndFlush方法
     * 3. 把新的channel加入到List里面去
     * <p>
     * 正确做法:
     * 1. 声明一个channelGroup, 其本质是 channel 的 List
     * 2. 调用channelGroup的writeAndFlush方法, 其本质是遍历已经存储的channel, 并调用每个channel的writeAndFlush方法
     * 3. 将channel放入到channelGroup中
     *
     * @param ctx 上下文
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        /** 获取到channel对象 */
        Channel channel = ctx.channel();

        /** 广播: 告诉其他客户端有人上线 */

        ChannelGroupFuture channelFutures = channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + " 上线\n");

        /** 广播后, 把新加入的 channel放入group中, 因为先加入的话, 自己也会收到[自己上线]的广播 */
        channelGroup.add(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[服务器消息] " + ctx.channel().remoteAddress() + " 已上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[服务器消息] " + ctx.channel().remoteAddress() + " 已下线");
    }

    /**
     * 下线
     *
     * @param ctx 上下文
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        /** 获取到channel对象 */
        Channel channel = ctx.channel();

        /** 广播: 告诉其他客户端有人下线 */

        channelGroup.writeAndFlush("[服务器] - " + channel.remoteAddress() + " 下线\n");

        /** 因为GlobalEventExecutor会自动断掉连接, 也就是netty替我们做了, 我们无需再调用下面代码 */
//        channelGroup.remove(channel);
    }

}
