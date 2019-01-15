package com.ssy.jdk8.$01;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by robin on 19/1/14.
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        Function<Integer, Integer> aop = x -> x + 2;
        Function<Integer, Integer> func = x -> x * 2;


        FunctionTest2 functionTest2 = new FunctionTest2();

        /**
         * 先执行 aop  -> 1 + 2  = 3
         * 再执行 func -> 3 * 2 = 6
         */
        final int i = functionTest2.compute1(1, func, aop);
        System.out.println(i);

        /**
         * 先执行 func -> 1 * 2 = 2
         * 再执行 aop  -> 2 + 2  = 4
         */
        final int j = functionTest2.compute2(1, func, aop);
        System.out.println(j);


        final int k = functionTest2.compute3(1, 2, (x, y) -> x + y);
        System.out.println(k);


    }

    public int compute1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }


    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }
}
