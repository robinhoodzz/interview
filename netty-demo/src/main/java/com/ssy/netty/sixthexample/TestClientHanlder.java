package com.ssy.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Administrator on 2019/2/13.
 */
public class TestClientHanlder extends SimpleChannelInboundHandler<MyDataInfo.Person> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                .setName("张三")
                .setAge(18)
                .setAddress("纽约")
                .build();

        ctx.channel().writeAndFlush(person);
    }

}
