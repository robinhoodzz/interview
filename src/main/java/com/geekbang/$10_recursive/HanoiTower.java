package com.geekbang.$10_recursive;

/**
 * Created by robin on 18/12/3.
 */

public class HanoiTower {

    private static String template = "第%s个盘子从%s移到%s";

    public static void main(String[] args) {
        move(4, 'A', 'B', 'C');

    }


    /**
     * 移动
     *
     * @param n    共有N个盘子
     * @param from 开始的柱子
     * @param in   中间的柱子
     * @param to   目标的柱子
     *             无论有多少个盘子, 都认为只有2个,上面所有的盘子和最下面的盘子
     */
    public static void move(int n, char from, char in, char to) {
        /** 只有一个盘子 或 最下面一个盘子 */
        if (n == 1) {
            System.out.println(String.format(template, n, from, to));
        } else {

            /** 把上面所有盘子 移动到 中间去 */
            move(n - 1, from, to, in);

            System.out.println(String.format(template, n, from, to));

            /** 把上面所有盘子 从中间位置 移动到 目标位置 */
            move(n - 1, in, from, to);
        }
    }
}
