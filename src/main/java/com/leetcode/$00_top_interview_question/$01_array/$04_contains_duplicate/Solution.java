package com.leetcode.$00_top_interview_question.$01_array.$04_contains_duplicate;


import java.util.HashSet;
import java.util.Set;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Created by Administrator on 2019/1/19.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer i :nums){
            set.add(i);
        }
        return nums.length != set.size();
    }

}

