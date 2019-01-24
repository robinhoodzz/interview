package com.ssy.jvm.classloader;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by robin on 19/1/23.
 */
public class MyTest13 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);

        while (null != loader) {
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
