package com.ssy.jdk8.$01;

/**
 * 函数式接口 抽象方法
 * Created by robin on 19/1/11.
 */

@FunctionalInterface
interface MyInterface {

    void test();

    String toString();
}


public class Test2 {


    public void myTest(MyInterface myInterface) {
        System.out.println("1");
        myInterface.test();
        System.out.println("2");
    }


    public static void main(String[] args) {
        Test2 test = new Test2();


        test.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("我的测试");
            }
        });

        System.out.println("------------------");


        test.myTest(() -> System.out.println("我的测试"));


        HerInterface myInterface = () -> System.out.println("我的测试");
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);



    }
}
