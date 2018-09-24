package com.alibaba.$05_class_instanceful;

/**
 * 类的实例化顺序
 * Created by Administrator on 2018/9/23.
 */
public class ClazzInstanceTest {

    /**
     *
     *
     *
     * 遵循先静态先父后子原则：

     父类中static代码块，子类中的static
     顺序执行父类的普通代码块
     父类构造器
     子类普通代码块
     子类构造器，按顺序执行
     子类方法的执行
     *
     *
     *
     *
     */


    public static void main(String[] args) {
        Parent son = new Son();

        Super ins = new Sub();
        /**
         * new Sub();
         　　a.首先会初始化父类的非静态代码块,也就是 private String baseName = "super";
         然后会执行父类的构造函数也就是 public Super() { callName() };
         但是这时候有个问题, 在子类中有相同的方法 callName();
         因为实例化的是 子类, 那实际上调用的也是子类的 callName();方法, 输出的应该是子类的baseName;
         但是那这时候还没有到子类非静态代码块的执行时间, 因此子类的baseName还没有初始化, 这时候他还没有值, 所以打印的结果就是null.
         */
    }
}


class Parent {

    static int a = 1;
    int b = 2;

    static {
        System.out.println("父类静态块1");
        System.out.println("父类静态块1---pa--"+ a );
//        System.out.println("父类静态块1---pb--"+ b );
    }

    static{
        System.out.println("父类静态块2");
        System.out.println("父类静态块2---pa--"+a);
//        System.out.println("父类静态块2---pb--"+b);
    }


    public Parent() {
        System.out.println("父类无参构造");
    }

    public Parent(int a) {
        System.out.println("父类有参构造");
    }


}


class Son extends Parent{

    static int a = 3;
    int b = 4;


    static{
        System.out.println("子类静态块1");
        System.out.println("子类静态块1---sa--"+a);
//        System.out.println("子类静态块1---pb--"+b);
    }


    static{
        System.out.println("子类静态块2");
        System.out.println("子类静态块2---sa--"+a);
//        System.out.println("子类静态块2---pb--"+b);
    }

    public Son() {
        System.out.println("子类无参构造");
    }

    public Son(int a) {
        System.out.println("子类有参构造");
    }




}



class Super {
    private String baseName = "super";

    public Super() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

}


class Sub extends Super {
    private String baseName = "sub";

    public void callName() {
        System.out.println(baseName);
    }
}