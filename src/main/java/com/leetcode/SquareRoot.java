package com.leetcode;

import java.util.Scanner;

/**
 * 利用二分法 求 平方根
 * Created by robin on 19/1/31.
 */
public class SquareRoot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while ((str = sc.nextLine()) != null) {
            float value = Float.valueOf(str);
            System.out.println(getRoot(value, 0.01D));
        }

    }

    /**
     * 计算: 平方根
     *
     * @param n       原数
     * @param precise 精度
     * @return 平方根
     */
    public static double getRoot(double n, Double precise) {

        double left = 0, right = n, mid, square, prec = (precise != null) ? precise : 0.01d;

        while (right - left > prec) {
            mid = (left + right) / 2;
            square = mid * mid;

            if (square > n) {
                right = mid;
            } else {
                left = mid;
            }

        }
        return (left + right) / 2;

    }

}
