package com.ssy.jdk8.$01;

import java.util.function.Function;

/**
 * Created by robin on 19/1/14.
 */
public class FunctionTest {

    public static void main(String[] args) {

        FunctionTest functionTest = new FunctionTest();
        final int compute = functionTest.compute(1, (x) -> x + 2);
        System.out.println(compute);

        String str = functionTest.convert(1, x -> x + ": string type");
        System.out.println(str);

    }

    public int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }


    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

}
