package com.geekbang.$11_sort;

import java.util.Arrays;

/**
 * Created by robin on 18/11/22.
 */
public class MyMergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 6, 3, 2, 1};

        sort(arr, 0, arr.length - 1);

//        System.out.println(sortedArr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr, int low, int high) {

        int mid = (low + high) / 2;
        if (low < high) {

            sort(arr, low, mid);
            sort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }

    }

    private static void merge(int[] arr, int low, int mid, int high) {

        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;

        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tmp[k] = arr[i];
                i++;
                k++;
            } else {
                tmp[k] = arr[j];
                j++;
                k++;
            }
        }


        while (i <= mid) {
            tmp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= high) {
            tmp[k] = arr[j];
            k++;
            j++;
        }

        for (int l = 0; l < tmp.length; l++) {
            arr[l + low] = tmp[l];
        }
    }


}
