package com.leetcode.$00_top_interview_question.$01_array.$099_maximun_subarray;

/**
 * Created by robin on 19/2/27.
 */
public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int max = maxSubArray(arr);
        System.out.println(max);
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= 0) {
                nums[i] += nums[i - 1];
                max = Math.max(max, nums[i]);
            }
        }

        return max;
    }
}
