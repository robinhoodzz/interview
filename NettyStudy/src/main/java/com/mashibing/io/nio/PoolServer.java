package com.mashibing.io.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by robin on 2020/1/20.
 */
public class PoolServer {
    /*
    单线程 + 线程池的模型
     */

    ExecutorService pool = Executors.newFixedThreadPool(50);

    private Selector selector;

    public static void main(String[] args) throws IOException {
        PoolServer server = new PoolServer();
        server.initServer(8000);
        server.listen();
    }


    private void initServer(int port) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(port));

        this.selector = Selector.open();

        ssc.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功");
    }


    private void listen() throws IOException {
        for (; ; ) {
            selector.select();

            Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();

                it.remove();

                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel channel = ssc.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    key.interestOps(key.interestOps() & (-SelectionKey.OP_READ));

                    pool.execute(new ThreadHandlerChanel(key));
                }
            }
        }

    }

    private class ThreadHandlerChanel implements Runnable {
        private SelectionKey key;

        public ThreadHandlerChanel(SelectionKey key) {
            this.key = key;
        }


        @Override
        public void run() {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(512);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                int size = 0;
                while ((size = channel.read(buffer)) > 0) {
                    buffer.flip();
                    baos.write(buffer.array(), 0, size);
                    buffer.clear();
                }
                baos.close();

                byte[] content = baos.toByteArray();
                ByteBuffer writeBuffer = ByteBuffer.allocate(content.length);
                writeBuffer.put(content);
                writeBuffer.flip();
                channel.write(writeBuffer);

                if (size == 1) {
                    channel.close();
                } else {
                    key.interestOps(key.interestOps() | SelectionKey.OP_READ);
                    key.selector().wakeup();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
