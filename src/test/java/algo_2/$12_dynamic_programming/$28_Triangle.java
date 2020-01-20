package algo_2.$12_dynamic_programming;

import java.util.List;

/**
 * 三角形最小路径和
 * 120
 * Created by Administrator on 2019/10/5.
 */
public class $28_Triangle {
    /*
               2
             /  \
            3   2
           / \ / \
          6   5   4
         / \ /   /  \
        4   1   100 101


    思路:
    1. 递归 + 判定, 时间复杂度O(2^n)
    2. 贪心,不可取, 因为局部最优 != 全局最优
        最优 2 3 5 1, 局部最优 2 2 4 100, 但是最后100的出现,导致全局不是最优

    3. DP
        1.定义DP[i,j]: buttom -> (i,j) path sum, min
        2 方程: DP[i,j] = min(DP[i+1,j], DP[i+1, j+1]) + triangle[i,j]
        DP[m-1,j] = triangle[m-1,j]
        时间复杂度O(m * n)

     */

    public int minimumTotal(List<List<Integer>> triangle) {

        // dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]]) + triangle[i][j]
        int row = triangle.size();
        int[] dp = new int[row + 1];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];

    }
}
