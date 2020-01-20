package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最大子数组的乘积
 * 152
 * <p>
 * 2 3 -2 4 => 6
 * <p>
 * Created by Administrator on 2019/10/6.
 */
public class $29_MaxProductSubArray {
    /*
    思路
    1. 暴力求解
        Recursion
    2. DP
        1. 状态的定义
        2. 递推方程

     */


    @Test
    public void testMaxProductSubArray() throws Exception {

        int[] arr1 = new int[]{2, 3, -2, 4};
        int[] arr2 = new int[]{-1, 0, -2};
        int[] arr3 = new int[]{-3, 2, -4, 5};


        Assert.assertEquals(6, maxProductSubArray(arr1));
        Assert.assertEquals(0, maxProductSubArray(arr2));
        Assert.assertEquals(120, maxProductSubArray(arr3));

    }


    public int maxProductSubArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int[][] dp = new int[2][2]; // 第一维表示数组的长度，由于不需要保存整个数组，所以长度只需要取2即可，第二维用0表示是正的最大值，用1表示为负的最大值

        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // 滚动数组, 用于累乘
            int x = i % 2;
            int y = (i - 1) % 2;

            // if (nums[i] >= 0) {
            // dp[x][0] = Math.max(dp[y][0] * nums[i], nums[i]); // 正的最大值
            // dp[x][1] = Math.min(dp[y][1] * nums[i], nums[i]); // 负的最大值
            // } else {
            // dp[x][0] = Math.max(dp[y][1] * nums[i], nums[i]); // 正的最大值，负负得正
            // dp[x][1] = Math.min(dp[y][0] * nums[i], nums[i]); // 负的最大值
            // }
            // 上面的if语句可以简写成下面这样
            dp[x][0] = Math.max(Math.max(dp[y][0] * arr[i], dp[y][1] * arr[i]), arr[i]);
            dp[x][1] = Math.min(Math.min(dp[y][0] * arr[i], dp[y][1] * arr[i]), arr[i]);
            res = Math.max(res, dp[x][0]);
        }
        return res;
    }

}
