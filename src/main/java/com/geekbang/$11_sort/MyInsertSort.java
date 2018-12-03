package com.geekbang.$11_sort;

import java.util.Arrays;

/**
 * Created by robin on 18/11/21.
 */
public class MyInsertSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 6, 3, 2, 1};

        int[] sortedArr = sort(arr);

//        System.out.println(sortedArr);
        System.out.println(Arrays.toString(arr));

    }


    private static int[] sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                if (arr[j] > val) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }


            }

            arr[j + 1] = val;

        }

        return arr;

    }


}
