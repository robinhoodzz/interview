package com.my;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2019/2/4.
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {

        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();




        new Thread(()->{
           try {
               ServerSocketChannel listenerChannel = ServerSocketChannel.open();
               listenerChannel.socket().bind(new InetSocketAddress(8000));
               listenerChannel.configureBlocking(false);
               listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

               while (true) {
                   if(serverSelector.select(1) > 0){
                       Set<SelectionKey> set = serverSelector.selectedKeys();
                       Iterator<SelectionKey> keyIterator = set.iterator();

                       while (keyIterator.hasNext()) {
                           SelectionKey key = keyIterator.next();

                           if (key.isAcceptable()) {
                               try {
                                   // (1) 每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                   SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                                   clientChannel.register(clientSelector, SelectionKey.OP_READ);
                               }finally {
                                   keyIterator.remove();
                               }
                           }
                       }
                   }
               }


           }catch (Exception e){

           }
        }).start();


        new Thread(()->{
            try {
                while (true){
                    // (2) 批量轮询是否有哪些连接有数据可读，这里的1指的是阻塞的时间为1ms
                    if (clientSelector.select(1) > 0) {
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while (keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();

                            if (key.isReadable()) {
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                } finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
