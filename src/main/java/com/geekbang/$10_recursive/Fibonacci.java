package com.geekbang.$10_recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by robin on 18/12/3.
 */
public class Fibonacci {

    static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 斐波那契数列
     * [1 1 2 3 5 8 13 21 34]
     * 0 1 2 3 4 5 6  7  8
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(calc(45));
    }


    /**
     * 计算
     *
     * @param x
     * @return
     */
    public static int calc(int x) {

        if (x == 0) return 0;
        if (x - 1 == 0) return 1;
        if (x - 2 == 0) return 2;

        if (map.containsKey(x)) {
            return map.get(x);
        }
        map.put(x, calc(x - 1) + calc(x - 2));


        return calc(x - 1) + calc(x - 2);

    }
}
