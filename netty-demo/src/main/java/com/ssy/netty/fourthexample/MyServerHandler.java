package com.ssy.netty.fourthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created by robin on 19/1/18.
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            String eventTypeStr = null;

            switch (event.state()) {
                case READER_IDLE:
                    eventTypeStr = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventTypeStr = "写空闲";
                    break;
                case ALL_IDLE:
                    eventTypeStr = "读写空闲";
                    break;
                default:
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件: " + eventTypeStr);
            ctx.channel().close();
        }
    }
}
