package com.atguigu.$03_clazzinit;

/**
 * Created by robin on 18/11/8.
 */
public class Son extends Father {

    private int i = test();
    private static int j = method();


    static {
        System.out.println("(6)");
    }

    Son() {
        System.out.println("(7)");
    }

    {
        System.out.println("(8)");
    }

    private char test() {
        System.out.println("(9)");
        return 1;
    }


    private static int method() {
        System.out.println("(10)");
        return 0;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        Son s2 = new Son();

    }

}
