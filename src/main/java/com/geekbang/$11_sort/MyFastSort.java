package com.geekbang.$11_sort;

import java.util.Arrays;

/**
 * 快排
 * <p>
 * Created by robin on 18/12/3.
 */
public class MyFastSort {

    public static void main(String[] args) {


//        int[] a = new int[]{3, 5, 7, 8, 9, 5, 1, 2, 6};
        int[] a = new int[]{8, 7, 5, 3};

        fastSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));


//        int[] b = new int[]{1, 8, 3, 9, 4, 5, 7};
        int[] b = new int[]{8, 7, 5, 3};
        quickSort(b, 0, b.length - 1); /** GeekforGeek.com 推荐 */
        System.out.println(Arrays.toString(b));
    }

    private static void quickSort(int[] b, int low, int high) {

        if (low < high) {
            int pi = patation(b, low, high);
            quickSort(b, low, pi - 1);
            quickSort(b, pi + 1, high);
        }
    }

    private static int patation(int[] b, int low, int high) {
        int i = low - 1;
        int piovt = b[high];
        for (int j = low; j <= high - 1; j++) {
            if (b[j] <= piovt) {
                i++;
                int tmp = b[i];
                b[i] = b[j];
                b[j] = tmp;
            }
        }
        int tmp = b[i + 1];
        b[i + 1] = b[high];
        b[high] = tmp;
        return i + 1;
    }


    private static void fastSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int standard = a[begin];
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
