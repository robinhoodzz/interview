package com.geekbang.$11_sort;

import java.util.Arrays;

/**
 * 快排
 *
 * Created by robin on 18/12/3.
 */
public class MyFastSort {

    public static void main(String[] args) {


        int[] a = new int[]{3, 5, 7, 8, 9, 5, 1, 2, 6};

        fastSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }


    private static void fastSort(int[] a, int begin, int end) {
        if(begin >= end) {
            return;
        }

        int standard = a[begin];
//        int i = 0;
//        int j = a.length - 1;
        int low = begin;
        int high = end;


        while (low < high) {
            while (low < high && standard <= a[high]) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= standard) {
                low++;
            }
            a[high] = a[low];
        }

        a[low] = standard;
        fastSort(a, begin, low);
        fastSort(a, low + 1, end);
    }
}
