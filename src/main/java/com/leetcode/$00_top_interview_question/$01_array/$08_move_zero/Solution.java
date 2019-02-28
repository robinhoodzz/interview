package com.leetcode.$00_top_interview_question.$01_array.$08_move_zero;

import java.util.Arrays;

/**
 * Created by robin on 19/2/27.
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
//        int[] arr = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
//        int[] arr = new int[]{0, 0};

        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int i = 0;
        int j = nums.length - 1;
        while (i < j && i < nums.length && j >= 0) {
            while (nums[j] == 0 && j >= 0) j--;

            while (nums[i] != 0 && i < nums.length) i++;

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }
        }
    }

}
