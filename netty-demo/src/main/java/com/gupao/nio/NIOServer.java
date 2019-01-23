package com.gupao.nio;

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
 * Created by robin on 19/1/23.
 */
public class NIOServer {

    private int port = 8000;
    private InetSocketAddress address = null;
    private Selector selector;

    public NIOServer(int port) {
        try {
            this.port = port;
            address = new InetSocketAddress(this.port);
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(address);
            // 服务端管道设置成非阻塞模式
            server.configureBlocking(false);
            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器启动 " + this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            // 轮询
            while (true) {
                int wait = this.selector.select(); // 等于accept()阻塞的
                if (wait == 0) continue;
                Set<SelectionKey> keys = this.selector.selectedKeys();
                Iterator<SelectionKey> i = keys.iterator();
                while (i.hasNext()) {
                    SelectionKey key = i.next();
                    // 针对每一个客户端进行相应的操作
                    this.process(key);
                    i.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(SelectionKey key) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        if (key.isAcceptable()) { // 如果是连接状态, 把客户端的对象得到
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false); // 设置非阻塞

            // 客户端一旦连接上来, 往select注册key, 接下来可以读了
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel client = (SocketChannel) key.channel();
            int len = client.read(buffer);
            if (len > 0) {
                buffer.flip();
                String content = new String(buffer.array(), 0, len);
                System.out.println(content);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        } else if (key.isWritable()) {
            SocketChannel client = (SocketChannel) key.channel();
            client.write(buffer.wrap("Hello World!".getBytes()));
//            client.close();
            client.register(selector, SelectionKey.OP_READ);
//            buffer.rewind();
        }
    }

    public static void main(String[] args) {
        NIOServer server = new NIOServer(8000);
        server.listen();
    }

}
