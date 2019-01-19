package com.leetcode.$00_top_interview_question.$01_array.$03_rotate_array;

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
//        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        solution.rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length; // 怕 k > 数组长度

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}

