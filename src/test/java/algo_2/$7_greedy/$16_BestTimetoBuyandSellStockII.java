package algo_2.$7_greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 买股票问题
 * 122
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * Created by Administrator on 2019/9/15.
 */
public class $16_BestTimetoBuyandSellStockII {
    /*
    注意
    最多持有1股
    买卖无限制

    如    1,     2,      3,      4,      5
    可以  买   卖+买    卖+买   卖+买   卖+买
    最后      1  +   1   +    1   +   1    =    4

    思路:
    贪心算法

    适用于贪心算法的场景:
    1. 问题能拆解成子问题
    2. 子问题的最优解能递推到最终问题的最优解

    贪心 VS 动态规划
    贪心 每个子问题的最优解不能回退
    DP   保存以前的运算结果,并根据以前结果对当前进行选择, 有回退功能
     */

    @Test
    public void testBestTimetoBuyandSellStockII() throws Exception {
        Assert.assertEquals(7, bestTimetoBuyandSellStockII(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(4, bestTimetoBuyandSellStockII(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, bestTimetoBuyandSellStockII(new int[]{7, 6, 4, 3, 1}));
    }


    public int bestTimetoBuyandSellStockII(int[] a) {
        int sum = 0;
        for (int i = 0, j = 1; i < a.length - 1 && j < a.length; i++, j++) {
            if (a[j] - a[i] > 0) {
                sum += a[j] - a[i];
            }
        }
        return sum;
    }
}
