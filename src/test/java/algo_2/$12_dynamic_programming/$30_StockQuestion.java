package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * 股票问题
 * 121, 122, 123, 309, 188, 714
 * <p>
 * 7 1 5 3 6 4
 * <p>
 * <p>
 * Created by Administrator on 2019/10/6.
 */
public class $30_StockQuestion {

    /*
    DP思路
    1. 状态定义
        dp[i]到了第i天,最大的利润是多少
    2. 状态转移方程
        dp[i] = dp[i-1] + -a[i](买股票) + a[i](买股票)
            解释一下: -a[i]表示买入那天的收益, 如2, 则这天的收益为-2

        因为要持有股票, 才能卖, 状态不够了, 需要改进, 最简单的方式是加维度:
        dp[i][0](没有持有股票) = dp[i-1][0](不交易) or dp[i-1][1] + a[i](交易卖) 的最大值
        dp[i][1](持有一股股票) = dp[i-1][1](不交易) or dp[i-1][1] - a[i](交易买) 的最大值





     */

    @Test
    public void testBuyStock() throws Exception {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};


        Assert.assertEquals(5, buy1(arr));
        Assert.assertEquals(7, buy2(arr));


    }

    /**
     * 121
     * 只能买卖一次
     * 记录数组中最小的元素
     * 用当前元素减去最小元素, 赋值给利润, 并判断与原利润谁最大
     * @param arr
     * @return
     */
    public int buy1(int[] arr) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            profit = Math.max(profit, arr[i] - min);
        }
        return profit;
    }


    /**
     * 122
     * 买卖无限制, 但只能持有1股
     * 后面一个元素减去前面一个元素, 然后再加起来
     *
     * @param arr
     * @return
     */
    public int buy2(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 0 ) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }


}
