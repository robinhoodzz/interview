package com.ssy.jvm.classloader;

/**
 * 对于静态字段来说, 只有直接定义了该字段的类才会被初始化
 * 当一个类初始化的时候, 要求其父类全部都已经初始化完毕了
 *
 * XX:+TraceClassLoading 用于追踪类的加载信息并打印出来
 *
 * 所有JVM参数以-XX开头
 * -XX:+<option> 开启option选项
 * -XX:-<option> 关闭option选项
 * -XX:<option>=<value> 将option选项的值设置为value
 *
 *
 * Created by robin on 19/1/15.
 */

public class MyTest1 {

    public static void main(String[] args) {
//        System.out.println(MyChild.str);
        System.out.println(MyChild.str2);
    }

}

class MyParent1 {

    public static String str = "hello world";

    static {
        System.out.println("parent static block");
    }

}

class MyChild extends MyParent1 {

    public static String str2 = "welcome";


    static {
        System.out.println("child static block");
    }
}