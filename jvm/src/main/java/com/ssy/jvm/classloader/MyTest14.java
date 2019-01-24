package com.ssy.jvm.classloader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by robin on 19/1/24.
 */
public class MyTest14 {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        System.out.println(loader);

        String resourceName = "com/ssy/jvm/classloader/MyTest14.class";

        Enumeration<URL> resources = loader.getResources(resourceName);

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            String path = url.toURI().getPath();
            System.out.println(path);
        }

        System.out.println("------");


        Class<?> clazz1 = MyTest14.class;
        System.out.println(clazz1.getClassLoader());

        Class<?> clazz2 = String.class;
        System.out.println(clazz2.getClassLoader());




    }

}
