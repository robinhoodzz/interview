package com.ssy.jvm.classloader;

/**
 * 常量在编译阶段 会存入到 调用这个常量 的方法 所在的类的 常量池中
 * 本质上, 调用类并没有接引用到 定义常量的类, 因此并不会被触发
 * 定义常量的类的初始化
 *
 * 注意: 这里指的是将常量存放到了MyTest2的常量池中, 之后MyTest2与MyParent2就没有任何关系了
 * 甚至, 我们MyParent2的class文件删除
 *
 *
 * 助记符:
 * ldc表示将int, float或者是String类型 的常量值从常量池中推送至栈顶
 * bipush表示将单字节(-128 - 127) 的常量推送至栈顶
 * sipush表示将短整型(-32767 - 32768) 的常量值推送至栈顶
 * iconst_1表示将int类型数字1 推送至栈顶 (iconst_1 - iconst_5)
 *
 * Created by robin on 19/1/15.
 */
public class MyTest2 {

    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}

class MyParent2 {

    public static final String str = "hello world"; // 助记符 ldc
    public static final short s = 7; // 助记符 bipush
    public static final int i = 128; // 助记符 sipush
    public static final int m = 1; // 助记符 iconst_1

    static {
        System.out.println("Myparent2 static block");
    }
}
