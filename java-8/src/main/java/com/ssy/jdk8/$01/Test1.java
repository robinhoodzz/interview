package com.ssy.jdk8.$01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * for循环 JDK不同版本的实现
 * Created by robin on 19/1/11.
 */
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // JDK 1.5 之前
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------------");

        // JDK 1.6 之后
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("------------------");

        // JDK 1.8
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        System.out.println("------------------");


        // JDK 1.8
        list.forEach(x -> System.out.println(2 * x));

        // JDK 1.8 方法引用
        list.forEach(System.out::println);

    }
}
