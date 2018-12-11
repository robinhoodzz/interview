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

    /**
     * 查找 数组中是否存在 最大值都大于等于 其他元素的2倍
     *
     * @param nums 数组
     * @return
     */
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

    /**
     * 把数组转化成 数字, 并保持进位
     * [9] plusOne = [1,0]
     * [1,9] plusOne = [2,0]
     * [1,9,9] plusOne = [2,0,0]
     *
     * @param digits 数组
     * @return
     */
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

    /**
     * 数组 蛇形打印
     * [
     * [ 1, 2, 3 ],
     * /  /
     * [ 4, 5, 6 ],
     * /  /
     * [ 7, 8, 9 ]
     * ]
     * <p>
     * Output:  [1,2,4,7,5,3,6,8,9]
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {


        int row = matrix[0].length - 1;
        int column = matrix.length - 1;
        int total = row + column;


        int x = 0;

        for (int i = 0; i < total + 1; i++) {
            for (int j = 0; j <= i; j++) {

                System.out.println(matrix[x][i - x]);
                if (x > i) continue;
                x++;
                x = i - j;
            }
        }

        // FIXME 待完善


        return null;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

//        char[] achars = a.toCharArray();
//        char[] bchars = b.toCharArray();

        char[] newChars;
        if (a.length() > b.length()) {
            newChars = makenew(a.toCharArray(), b.toCharArray());
        } else {
            newChars = makenew(b.toCharArray(), a.toCharArray());
        }


        return new String(newChars);

    }

    private char[] makenew(char[] xChar, char[] ychars) {
        char[] newChars = new char[xChar.length];
        for (int i = ychars.length - 1; i >= 0; i--) {
            if (xChar[i] == '0' || ychars[i] == '0') {
                newChars[i] = '0';
            } else if (xChar[i] == '1' && ychars[i] == '1') {
                newChars[i] = '2';
            } else if (xChar[i] == '1' || ychars[i] == '1') {
                newChars[i] = '1';
            } else {
                newChars[i] = xChar[i];
            }
        }
        return newChars;
    }

}
