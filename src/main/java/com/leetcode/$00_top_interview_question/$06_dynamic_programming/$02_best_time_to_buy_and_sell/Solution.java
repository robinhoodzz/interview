package com.leetcode.$00_top_interview_question.$06_dynamic_programming.$02_best_time_to_buy_and_sell;

/**
 * Created by robin on 19/3/6.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
//        int[] a = new int[]{7, 6, 4, 3, 1};

        System.out.println(solution.maxProfit(a));
    }


    public int maxProfit(int[] a) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;


        for (int i = 0; i < a.length; i++) {
            if (a[i] < minProfit) {
                maxProfit = a[i];
            } else if (a[i] - minProfit > maxProfit) {
                maxProfit = a[i] - minProfit;
            }
        }

        return maxProfit;
    }


}
