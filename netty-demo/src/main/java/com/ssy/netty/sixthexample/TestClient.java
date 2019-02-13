package com.ssy.netty.sixthexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by robin on 19/2/13.
 */
public class TestClient {

    public static void main(String[] args) {
        try {

            EventLoopGroup worker = new NioEventLoopGroup();


            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker).channel(NioServerSocketChannel.class).handler(new MyClientInitializer());


            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for(;;){
                channel.writeAndFlush(br.readLine() + "\r\n");
            }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }
}
