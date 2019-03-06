package com.leetcode.$00_top_interview_question.$06_dynamic_programming.$03_maximum_subarray;

/**
 * Created by robin on 19/3/6.
 */
public class Solution {
    public static void main(String[] args) {

        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(a));
    }

    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            if (currentMax > globalMax)
                globalMax = currentMax;
        }

        return globalMax;
    }
}
