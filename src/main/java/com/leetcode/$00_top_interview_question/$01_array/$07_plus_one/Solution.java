package com.leetcode.$00_top_interview_question.$01_array.$07_plus_one;

import java.util.Arrays;

/**
 * Created by robin on 19/2/27.
 */
public class Solution {

    public static void main(String[] args) {
//        int[] a = new int[]{1, 2, 3};
        int[] a = new int[]{9, 9, 9};
        int[] b = plusOne(a);
        System.out.println(Arrays.toString(b));
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }

        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i >= 0; i--) {
            int left = digits[i] / 10;
            if (left == 0) {
                return digits;
            }

            int dig = digits[i] % 10;
            if (i == 0) {
                int[] b = new int[digits.length + 1];
                System.arraycopy(digits, 0, b, 1, b.length - 1);

                b[1] = dig;
                b[0] += left;
                return b;
            } else {
                digits[i] = dig;
                digits[i - 1] += left;
            }

        }


        return digits;
    }

}
