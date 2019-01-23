package com.ssy.jvm.classloader;

/**
 * Created by robin on 19/1/23.
 */
public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest {
    public static final int x = 3;

    static {
        System.out.println("FinalTest static block");
    }
}
