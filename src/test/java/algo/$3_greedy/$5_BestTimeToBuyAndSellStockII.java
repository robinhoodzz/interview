package algo.$3_greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 买卖股票最大收益II
 * 122. Best Time to Buy and Sell Stock II (Easy)
 * 题目描述：可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
 * <p>
 * 思路:
 * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
 * 而 d - a = (d - c) + (c - b) + (b - a) ，
 * 因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，
 * 那么就把 prices[i] - prices[i-1] 添加到收益中。
 */
public class $5_BestTimeToBuyAndSellStockII {
    /*
    Input: [7,1,5,3,6,4]
    Output: 7
    Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

    Input: [1,2,3,4,5]
    Output: 4
    Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.

    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */

    private int[] a = new int[]{7, 1, 5, 3, 6, 4};
    private int[] b = new int[]{1, 2, 3, 4, 5};
    private int[] c = new int[]{7, 6, 4, 3, 1};

    @Test
    public void testBestTimeToBuyAndSellStock() {
        int i = bestTimeToBuyAndSellStock(a);
        Assert.assertEquals(7, i);

        int m = bestTimeToBuyAndSellStock(b);
        Assert.assertEquals(4, m);

        int n = bestTimeToBuyAndSellStock(c);
        Assert.assertEquals(0, n);
    }


    public int bestTimeToBuyAndSellStock(int[] a) {


        if (a == null || a.length == 0) {
            return 0;
        }

        int p = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] > 0) {
                p += a[i + 1] - a[i];
            }
        }
        return p;
    }


}
