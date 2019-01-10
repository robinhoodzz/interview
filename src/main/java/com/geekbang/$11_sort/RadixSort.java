package com.geekbang.$11_sort;

/**
 * 基数排序
 * Created by robin on 18/12/6.
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] a = new int[]{23, 6, 189, 45, 9, 287, 56, 1, 798, 34, 65, 652, 5};
        radixSort(a);
    }

    private static void radixSort(int[] a) {

        // 找到最大的数
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int[][] bucket = new int[10][a.length];

        int point = 1;
        while (max / point > 0) {

            for (int i = 0; i < a.length; i++) {
                int tmp = a[i] / point % 10;
                bucket[tmp][i] = a[i];
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int i1 = bucket[i][j];
                    if(i1 != 0) {
                        // TODO
                    }

                }
            }

            point = point * 10;
        }
    }


}
