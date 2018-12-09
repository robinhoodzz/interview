package com.geekbang.$11_sort;

/**
 * Created by robin on 18/11/21.
 */
public class MyBubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 5, 6, 3, 2, 1};

//        int[] sortedArr = sort(arr);
        sort(arr);

//        System.out.println(sortedArr);
        System.out.println(arr);

    }


//    private static int[] sort(int[] arr) {
    private static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j +1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
//        return arr;

    }


}
