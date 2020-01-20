package com.mashibing.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * Created by robin on 2020/1/20.
 */
public class HelloNetty {

    public static void main(String[] args) {
        new NettyServer(8888).serverStart();
    }

}

class NettyServer {
    int port = 0;

    public NettyServer(int port) {
        this.port = port;

    }

    public void serverStart() {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(); // 相当于NIO 里的selector, 只负责连接
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(); // 只负责IO处理

        ServerBootstrap b = new ServerBootstrap(); // 解鞋带, 配置

        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new handler());
                    }
                });

        try {
            ChannelFuture future = b.bind(port).sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}

class handler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server: channel read");
        ByteBuf buf = (ByteBuf) msg;

        System.out.println(buf.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(msg);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

