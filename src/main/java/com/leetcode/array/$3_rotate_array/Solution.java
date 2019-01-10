package com.leetcode.array.$3_rotate_array;

import java.util.Arrays;

/**
 * Created by robin on 19/1/3.
 */
public class Solution {


    public void rotate(int[] nums, int k) {
        for (; k > 0; k--) {
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        solution.rotate(arr, 3);

        System.out.println(Arrays.toString(arr));
    }
}
