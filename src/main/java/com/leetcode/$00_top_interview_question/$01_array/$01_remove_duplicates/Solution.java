package com.leetcode.$00_top_interview_question.$01_array.$01_remove_duplicates;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Created by Administrator on 2019/1/19.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] arr = new int[]{1, 1, 2};
//        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr = new int[]{1, 1, 1};
        int result = solution.removeDuplicates(arr);
        System.out.println(result);
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {

        int j = 0;
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                j++;
                nums[j] = nums[i];
                k++;
            }
        }

        return k;
    }
}

