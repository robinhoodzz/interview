package com.leetcode.$00_top_interview_question.$06_dynamic_programming.$01_climbing_stairs;

import java.util.HashMap;

/**
 * Created by robin on 19/3/6.
 */
public class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStaris(45));

    }


    public int climbStaris(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n))
            return map.get(n);
        else
            map.put(n, climbStaris(n - 1));
        return climbStaris(n - 1) + climbStaris(n - 2);
    }


}
