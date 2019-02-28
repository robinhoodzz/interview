package com.ssy.netty.sixthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;


/**
 * Created by robin on 19/2/13.
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new ProtobufDecoder(MyDataInfo.MyMessage.getDefaultInstance())); // 解码器
        pipeline.addLast(new ProtobufEncoder()); // 编码器
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());

        pipeline.addLast(new TestServerHanlder());
    }

}
