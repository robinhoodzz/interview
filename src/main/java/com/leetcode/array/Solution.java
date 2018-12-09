package com.leetcode.array;

/**
 * Created by Administrator on 2018/12/9.
 */
public class Solution {


    /**
     * 找到 左之和 = 右之和
     *
     * @param nums 数组
     * @return
     */
    public int pivotIndex(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int cum = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            if (sum - nums[i] == cum) {
                return i;
            }

            sum -= nums[i];
            cum += nums[i];
        }

        return -1;
    }

    public int dominantIndex0(int[] nums) {

        int[] c = new int[100];
        for (int i = 0; i < nums.length; i++) {
            c[nums[i]] = nums[i];
        }

        int max = 0;
        int maxIndex = 0;
        for (int j = c.length - 1; j > 0; j--) {
            if (c[j] != 0) {
                max = c[j];
                maxIndex = j;
                break;
            }
        }


        for (int k = maxIndex; k > 0; k--) {
            if (c[k] != 0 && c[k] * 2 < max) {
                return max;
            }
        }

        return -1;
    }


    public int dominantIndex(int[] nums) {

        int maxIndex = 0;
        int max = 0;
        int secondMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMax && nums[i] < max) {
                secondMax = nums[i];
            }
        }

        if (secondMax * 2 <= max) {
            return maxIndex;
        }

        return -1;
    }

    public int[] plusOne(int[] digits) {

        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i] = 0;
                digits[i - 1]++;
            }
        }

        int[] tmp = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp[i + 1] = digits[i];
            if (digits[i] == 10) {
                tmp[i + 1] = 0;
            }
        }

        if (digits[0] >= 10) {
            tmp[0] = 1;
            return tmp;
        }

        return digits;
    }
}
