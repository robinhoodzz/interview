package com.atguigu.$03_clazzinit;

/**
 * Created by robin on 18/11/8.
 */
public class Father {

    private int i = test();
    private static int j = method();


    static {
        System.out.println("(1)");
    }

    Father() {
        System.out.println("(2)");
    }

    {
        System.out.println("(3)");
    }

    private char test() {
        System.out.println("(4)");
        return 1;
    }


    private static int method() {
        System.out.println("(5)");
        return 0;
    }


}
