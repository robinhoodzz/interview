package com.leetcode.$00_top_interview_question.$06_dynamic_programming.$04_house_robber;

/**
 * Created by robin on 19/3/6.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = new int[]{1, 2, 3, 1};
        int[] b = new int[]{2, 7, 9, 3, 1};
        int[] c = new int[]{2, 1, 1, 2};

        System.out.println(solution.rob(a));
        System.out.println(solution.rob(b));
        System.out.println(solution.rob(c));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = nums[1];
        f[2] = Math.max(nums[0] + nums[2], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            f[i] = Math.max(Math.max(f[i - 2] + nums[i], f[i - 3] + nums[i]), f[i - 1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < f.length; i++) {
            res = f[i] > res ? f[i] : res;
        }


        return res;
    }
}
