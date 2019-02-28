package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by robin on 19/2/20.
 */
public class $350_IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{2, 3, 4, 5};

        Set<Integer> set = new HashSet<>();
        int[] arr3 = new int[arr1.length > arr2.length ? arr1.length : arr2.length];
        int[] arr4 = null;

        for (int i : arr1) {
            set.add(i);
        }

        int index = -1;
        for (int j : arr2) {
            if (set.contains(j)) {
                arr3[++index] = j;
            }
        }

        arr4 = new int[index];
        System.arraycopy(arr3, 0, arr4, 0, index);




        System.out.println(Arrays.toString(arr4));

    }
}
