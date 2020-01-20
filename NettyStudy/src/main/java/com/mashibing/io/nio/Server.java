package com.mashibing.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by robin on 2020/1/19.
 */
public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open(); // 这个通道是双向的可读可写
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
        ssc.configureBlocking(false); // 设定非阻塞模型

        System.out.println("server is started, listening on :" + ssc.getLocalAddress());
        Selector s = Selector.open();
        ssc.register(s, SelectionKey.OP_ACCEPT); // 注册对那件事感兴趣, 注册事件

        for (; ; ) {
            s.select(); // 这个方法是阻塞的, 直到客户端连接上来 accept事件, 才会开始继续处理, 此时可能有多个事件同时发生
            Set<SelectionKey> keys = s.selectedKeys(); // 每一个插座对应一个key, 系统会收录在一个set集合中
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove(); // 获取完key后需要remove, 否则下次循环还会获取同样的事件key
                handle(key);
            }
        }


    }

    private static void handle(SelectionKey key) {
        if (key.isAcceptable()) { // 表示有客户端想连接进来
            try {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);


                sc.register(key.selector(), SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }

        } else if (key.isReadable()) {
            SocketChannel sc = null;

            try {
                sc = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(512);
                buffer.clear();
                int len = sc.read(buffer);

                if (len != -1) {
                    System.out.println(new String(buffer.array(), 0, len));
                }

                 ByteBuffer bufferToWrite = ByteBuffer.wrap("Hello Client!".getBytes());
                sc.write(bufferToWrite);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (sc != null) {
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }

    }
}
