package com.ssy.jdk8.$01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * lambda 表达式本质是对象
 * Created by robin on 19/1/11.
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        HerInterface her = () -> {
        };
        HerInterface her2 = () -> {
        };
        HisInterface his = () -> {
        };

        System.out.println(her.getClass().getInterfaces()[0]);
        System.out.println(his.getClass().getInterfaces()[0]);

        System.out.println(her.hashCode());
        System.out.println(her2.hashCode());
        System.out.println(his.hashCode());


        System.out.println(her == her2);
        System.out.println(her.equals(her2));


        System.out.println(her == his);
        System.out.println(her.equals(his));


        /** 线程执行也可以用 lambda表达式 */
        new Thread(() -> System.out.println("线程执行")).start();


        /** 例子: 把List里的小写字符, 转成大写字符 */
        List<String> inputList = Arrays.asList("abc", "edf", "ghi");
        List<String> outputList = new ArrayList<>();

        inputList.forEach(x -> outputList.add(x.toUpperCase()));
        System.out.println(outputList);

        /** 例子: 方法引用, 来源于 java.util.Function */
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
        /** 因为 toUpperCase是由对象驱动的, 而Function中有泛型, 所以 String:: 对应的是 Function<String>这声明 */


    }


}

@FunctionalInterface
interface HerInterface {

    void myMethod();

}


@FunctionalInterface
interface HisInterface {

    void hisMethod();
}