package com.geekbang.$11_sort;

import java.util.Arrays;

/**
 * Created by robin on 18/12/4.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 2, 7, 8, 1, 2, 0, 4, 7, 4, 3, 8};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }


    private static void shellSort(int[] a) {

        /** 遍历所有步长 */
        for (int d = a.length / 2; d > 0; d = d / 2) {
            /** 遍历所有元素 */
            for (int i = d; i < a.length; i++) {
                /** 遍历本组中所有元素 */
                for (int j = i - d; j >= 0; j -= d) {
                    /** 如果 当前元素 > 加上步长后的元素 */
                    if (a[j] > a[j + d]) {
                        int tmp = a[j];
                        a[j] = a[j + d];
                        a[j + d] = tmp;

                    }
                }
            }
        }
    }


}
