package com.ssy.jvm.classloader;

/**
 * Created by robin on 19/1/23.
 */
public class MyTest12 {


    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader loader = ClassLoader.getSystemClassLoader(); // 加载ClassPath的类, 系统/应用加载器
        Class<?> clazz = loader.loadClass("com.ssy.jvm.classloader.CL");
        System.out.println(clazz);

        System.out.println("---------");

        clazz = Class.forName("com.ssy.jvm.classloader.CL");


        System.out.println(clazz);

    }

}


class CL {
    static {
        System.out.println("class CL");

    }
}