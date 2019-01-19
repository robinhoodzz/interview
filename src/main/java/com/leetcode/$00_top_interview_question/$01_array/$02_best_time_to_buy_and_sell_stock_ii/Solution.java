package com.leetcode.$00_top_interview_question.$01_array.$02_best_time_to_buy_and_sell_stock_ii;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Created by Administrator on 2019/1/19.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
//        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr = new int[]{7, 6, 4, 3, 1};

        int result = solution.maxProfit(arr);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            sum += Integer.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }
}

