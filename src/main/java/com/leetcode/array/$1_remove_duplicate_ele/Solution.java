package com.leetcode.array.$1_remove_duplicate_ele;

/**
 * Created by robin on 19/1/3.
 */
class Solution {

    /**
     * 去重复后的长度
     *
     * @param nums 数组
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int cnt = 0;

        for (int i = 1; i < size; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
            }
            nums[i - cnt] = nums[i];
        }

        return size - cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1, 1, 2};
//        int[] arr = new int[]{1, 1, 1, 1};
//        int[] arr = new int[]{0, 0, 0, 0, 0};

        System.out.println(solution.removeDuplicates(arr));
    }
}
