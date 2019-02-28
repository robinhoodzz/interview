package com.leetcode.$00_top_interview_question.$01_array.$09_two_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by robin on 19/2/27.
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(a, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int next = target - nums[i];
            if (map.containsKey(next)) {
                return new int[]{map.get(next), 1};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
