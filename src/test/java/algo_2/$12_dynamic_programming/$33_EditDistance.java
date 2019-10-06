package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编辑距离
 * 72
 * word1 -> word2
 * Insert, Delete, Replace
 * 把单词1变成单词2, 需要多少步骤的操作, 只能插入,删除,替换
 * <p>
 * horse -> ros
 * 替换 h -> r    1步
 * 保留 o
 * 删除 r         2步
 * 保留 s
 * 删除 e         3步
 * <p>
 * intention -> execution
 * 删除第一个 t   inention
 * 替换 i -> e    enention
 * 替换 n -> x    exention
 * 替换 n -> c    exection
 * 插入 u         execution
 * <p>
 * Created by Administrator on 2019/10/6.
 */
public class $33_EditDistance {

    /*
    思路:
    1, 暴力破解
    BFS 把操作的字符串放进队列, 直到匹配到word2
        或者word2也同时BFS, 改变后(3种操作)放进队列, 然后相遇
    不推荐


    2.DP
        1.状态 dp[i][j]
            i是word1的前i个字符
            j是word2的前j个字符
          word1前i个字符 => word2前j个字符最少步数
          结果就是dp[m][n]
        2.DP状态方程
            dp[i][j] =
                        if wd1[i] == wd2[j]
                            dp[i][j] = dp[i-1][j-1]
                        else
                            min{dp[i-1][j-1],dp[i][j-1],dp[i-1][j]} + 1
     */


    @Test
    public void testMinDistance() throws Exception {

        Assert.assertEquals(3, minDistance("horse", "ros"));
        Assert.assertEquals(5, minDistance("intention", "execution"));
        Assert.assertEquals(0, minDistance("abc", "abc"));

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        // 第一个单词前缀有i个字符, 第二个单词前缀0个字符的时候, 相当于全部删除所需要的步骤数
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = dp[i][j];
                    int b = dp[i][j + 1];
                    int c = dp[i + 1][j];

                    dp[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    dp[i + 1][j + 1]++;
                }
            }
        }
        return dp[m][n];
    }
}
