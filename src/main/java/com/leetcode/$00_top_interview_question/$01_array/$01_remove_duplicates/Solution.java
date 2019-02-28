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
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] arr = new int[]{1, 1, 1};
//        int result = solution.removeDuplicates(arr);
//        System.out.println(result);

        int result = solution.removeDuplicates2(arr);
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

    /**
     * 双指针法, i和j, i慢,j快, 当i与j不能时, i+1, 然后j的值覆盖i(加一后的)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i;
    }
}

