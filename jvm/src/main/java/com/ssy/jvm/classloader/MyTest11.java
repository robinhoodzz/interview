package com.ssy.jvm.classloader;

/**
 * Created by robin on 19/1/23.
 */
public class MyTest11 {

    static {
        System.out.println("MyTest11 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child3.a);
        Parent33.doSomething();
    }
}

class Parent33 {
    static int a = 3;

    static {
        System.out.println("Parent33 static block");
    }
    static void doSomething() {
        System.out.println("Parent33 static doSomething");
    }

    public Parent33() {
        System.out.println("Parent33 construct block");
    }
}

class Child3 extends Parent33 {

    static int b = 4;

    static {
        System.out.println("Child3 static block");

    }
}