package com.ssy.jvm.classloader;

/**
 * Created by robin on 19/1/23.
 */
public class MyTest7 {


    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazzA = Class.forName("java.lang.String");
        ClassLoader classLoaderA = clazzA.getClassLoader();// 返回针对这个类的类加载器
        System.out.println(classLoaderA); // 返回null, 则表示, 这个类是由bootstrap启动类加载的
        // 因为bootstrap会加载rt.jar. 而String类是在这个jar包里


        Class<?> classB = Class.forName("com.ssy.jvm.classloader.MyClass");
        ClassLoader classLoaderB = classB.getClassLoader();
        System.out.println(classLoaderB);

    }
}

class MyClass {

}
