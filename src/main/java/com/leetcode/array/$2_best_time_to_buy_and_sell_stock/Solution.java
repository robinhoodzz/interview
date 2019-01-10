package com.leetcode.array.$2_best_time_to_buy_and_sell_stock;

/**
 * Created by robin on 19/1/3.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i];
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(solution.maxProfit(arr));

    }
}
