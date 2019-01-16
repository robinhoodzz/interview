package com.ssy.jvm.classloader;

/**
 * Created by robin on 19/1/16.
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

        System.out.println("------------------");
        System.out.println(instance.counter1);
        System.out.println(instance.counter2);
    }

}

class Singleton {

    public static int counter1 = 1;
    private static Singleton singleton = new Singleton();

    private Singleton(){
        counter1++;
        counter2++;

        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 5;

    public static Singleton getInstance() {
        return singleton;
    }
}
