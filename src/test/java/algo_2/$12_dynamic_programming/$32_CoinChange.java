package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 零钱兑换
 * 322
 * [1,2,5] 拼凑成 11 -> [5,5,1]  -> 总计3个
 * [2] 拼凑成 3 -> [-1] 总计 -> -1个
 * Created by Administrator on 2019/10/6.
 */
public class $32_CoinChange {
    /*
    从上至下的动态规划
    思路: 拆分成子问题, 然后缓存
    F(S) = F(S-C) + 1
    但是不止一个C, 如 {1,2,3} 拼凑 6
    6拆分成 6-1, 6-2, 6-3,
        即 F(6) = min[F(6-1), F(6-2), F(6-3)] + 1

    问题: 在递归树中使用了回溯和剪枝, 从而导致不能适应变化
    当我们设计一组硬币, 其中一个硬币大于要拼凑的面额, 就会出问题

    https://leetcode.com/problems/coin-change/solution/


    从下至上的动态规划
    使用循环而不是递归的问题在于, 计算出F(i)之前,已经计算出F(i-1)
    也就是计算出从 0 - amount之期间所有的拼凑硬币数
    min[F(i) = F(i - j) + 1]
    amount  C1(硬币1元)    C2(硬币2元)    C3(硬币3元)    F[i](等于前面的最小值+1, 如F(0) + 1  = 1)
    1       F(0)                                            1
    2       F(1)            F(0)                            1
    3       F(2)            F(1)            F(0)            1
    4       F(3)            F(2)            F(1)            2
    5       F(4)            F(3)            F(2)            2
    6       F(5)            F(4)            F(3)            2

    F(3) = min[f(3-c1), f(3-c2), f(3-c3)] + 1
         = min[f(3-1), f(3-2), f(3-3)] + 1
         = min[f(2), f(1), f(0)] + 1
         = min[1,1,0] + 1
         = 1
     */


    @Test
    public void testCoinChange() throws Exception {

        Assert.assertEquals(3, coinChange(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(2, coinChange(new int[]{1, 2, 3}, 6));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertEquals(2, coinChageButtomToUp(new int[]{1, 2, 3}, 6));
        Assert.assertEquals(2, coinChageButtomToUp(new int[]{1, 2, 3}, 6));
    }


    public int coinChange(int[] arr, int amount) {
        if (amount < 1) return 0;
        return coinChange(arr, amount, new int[amount]);


    }

    private int coinChange(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }


    public int coinChageButtomToUp(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }

        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
