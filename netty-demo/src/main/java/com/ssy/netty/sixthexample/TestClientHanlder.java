package com.ssy.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * Created by Administrator on 2019/2/13.
 */
public class TestClientHanlder extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int random = new Random().nextInt(3);

        MyDataInfo.MyMessage myMessage = null;

        if (0 == random) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(
                            MyDataInfo.Person.newBuilder()
                                    .setName("张三")
                                    .setAge(18)
                                    .setAddress("纽约")
                                    .build()
                    ).build();
        } else if (1 == random) {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(
                            MyDataInfo.Dog.newBuilder()
                                    .setName("米姆")
                                    .setAge(3)
                                    .build()
                    ).build();
        } else {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                    .setCat(
                            MyDataInfo.Cat.newBuilder()
                                    .setName("熊熊熊")
                                    .setCity("里昂")
                                    .build()
                    ).build();
        }


        ctx.channel().writeAndFlush(myMessage);
    }

}
