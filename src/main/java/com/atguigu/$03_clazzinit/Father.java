package com.atguigu.$03_clazzinit;

/**
 * 看子类注释
 * Created by robin on 18/11/8.
 */
public class Father {

    private int i = test();
    private static int j = method();

    static {System.out.println("(1)");}

    Father() {System.out.println("(2)");}

    { System.out.println("(3)");}

    public int test() {
        System.out.println("(4)");
        return 1;
    }


    public static int method() {
        System.out.println("(5)");
        return 1;
    }


    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();

    }

}
