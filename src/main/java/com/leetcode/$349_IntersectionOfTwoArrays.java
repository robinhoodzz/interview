package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by robin on 19/2/20.
 */
public class $349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{2, 3, 4, 5};

        Set<Integer> set = new HashSet<>();

        for (int i : arr1) {
            set.add(i);
        }

        int count = 0;
        for (int j : arr2) {
            if(set.contains(j))
                count++;
        }

        System.out.println(count);
    }
}
