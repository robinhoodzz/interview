package com.ssy.jvm.classloader;

/**
 * Created by robin on 19/1/24.
 */
public class MyTest16 extends ClassLoader {


    private String classLoaderName;
    private final String fileExtesions = ".class";

    public MyTest16(String classLoaderName) {
        super(); // 将系统加载器, 当做该加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }


}
