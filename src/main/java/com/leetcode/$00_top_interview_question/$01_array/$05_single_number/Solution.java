package com.leetcode.$00_top_interview_question.$01_array.$05_single_number;

/**
 * Created by Administrator on 2019/1/19.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = new int[]{5, 2, 6, 8, 1};
//        int[] arr = new int[]{2, 2, 1};
        int[] arr = new int[]{4, 1, 2, 1, 2};
//        int max = solution.findMax(arr);
//        System.out.println(max);
        int single = solution.singleNumber(arr);
        System.out.println(single);

    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i <nums.length; i++){
            single = single ^ nums[i];
        }
        return single;
    }
}
