package com.atguigu.$03_clazzinit;

/**
 *
 * 顺序如下：
 *
 * 先初始化父类 (5)(1)
 * 再初始化子类 (10)(6)
 *
 * 父类初始化<clinit>;
 * 1. j = method();
 * 2. 父类的静态代码块
 *
 * 子类的初始化<clinit>
 * 1. j = method();
 * 2. 子类的静态代码块
 *
 * 子类的实例化方法
 * 1. super() （最前）相当于初始化父类的实例   (9)[因为重写] (3) (2)
 * 2. i = test() #方法重写的情况， 父类执行的是子类的代码所以父类的 test()->4 的方法  (9)
 * 3. 子类的非静态代码块 (8)
 * 4. 子类的无参构造（最后）(7)
 *
 *
 *
 * Created by robin on 18/11/8.
 */
public class Son extends Father {

    private int i = test();
    private static int j = method();


    static {System.out.println("(6)");}

    Son() {System.out.println("(7)");}

    {System.out.println("(8)");}

    public int test() {
        System.out.println("(9)");
        return 1;
    }

    public static int method() {
        System.out.println("(10)");
        return 0;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();

    }

}
