package com.ssy.netty.firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * Created by robin on 19/1/10.
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 作用: 读取客户端请求, 向客户端返回响应
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        System.out.println(msg.getClass());

        if (msg instanceof HttpRequest) {

            HttpRequest request = (HttpRequest) msg;
            System.out.println("请求方法名: " + request.method().name());

            if ("/favicon.ico".equals(request.uri())) {
                System.out.println("请求了favicon.ico退出");
                return;
            }


            ByteBuf content = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plains");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);
            ctx.close();
        }

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread() + "channelActive");
        super.channelActive(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread() + "channelRegistered");
        super.channelRegistered(ctx);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread() + "handlerAdded");
        super.handlerAdded(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread() + "channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread() + "channelUnregistered");
        super.channelUnregistered(ctx);
    }
}
