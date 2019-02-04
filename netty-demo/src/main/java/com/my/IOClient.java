package com.my;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Administrator on 2019/2/4.
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            Socket socket = null;
            try {
                socket = new Socket("127.0.0.1", 8000);

                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": Hello World").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
