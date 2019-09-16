package algo.$3_greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 买卖股票最大收益
 * 121. Best Time to Buy and Sell Stock (Easy)
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * <p>
 * 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 * 思路:
 * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
 */
public class $5_BestTimeToBuyAndSellStock {

    private int[] a = new int[]{7, 1, 5, 3, 6, 4};

    @Test
    public void testBestTimeToBuyAndSellStock() {
        int i = bestTimeToBuyAndSellStock(a);
        Assert.assertEquals(5, i);
    }


    public int bestTimeToBuyAndSellStock(int[] a) {
        // 要想往小比较, 初始值就要设置的很大
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < a.length; i++) {
            min = Math.min(a[i], min);
            profit = Math.max(a[i] - min, profit);
        }
        return profit;
    }


}
