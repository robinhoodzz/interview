package com.geekbang.$11_sort;

import java.util.Arrays;

/**
 * Created by robin on 18/12/4.
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void selectSort(int[] a) {

        int minIdex = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdex]) {
                    minIdex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIdex];
            a[minIdex] = tmp;
        }
    }


}
