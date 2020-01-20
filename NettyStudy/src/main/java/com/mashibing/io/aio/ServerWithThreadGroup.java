package com.mashibing.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by robin on 2020/1/20.
 */
public class ServerWithThreadGroup {

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withCachedThreadPool(pool, 1);

        AsynchronousServerSocketChannel socketChannel = AsynchronousServerSocketChannel
                .open(group)
                .bind(new InetSocketAddress(8888));



        socketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                socketChannel.accept(null, this);

                try {
                    System.out.println(client.getRemoteAddress());
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("Hello Client!".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        for (;;) {
            Thread.sleep(1000);
        }

    }
}
