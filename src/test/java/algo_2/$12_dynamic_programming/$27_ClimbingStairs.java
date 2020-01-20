package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * 爬楼梯
 * 70
 * <p>
 * Created by Administrator on 2019/10/5.
 */
public class $27_ClimbingStairs {
    /*
    思路:
    1. 回溯
        f(n) = f(n-1) + f(n-2)

    2. 动态规划
        for i=2 -> n
            f[n] = f[n-1] + f[n-2]
        只需要记录前面2个元素即可, 时间复杂度 O(n), 空间 O(1)[只占用2个元素]

    动态规划需要:
        1. DP状态的定义(边界值的设计)
        2. DP方程

    本身转化成了斐波那契数列求解
     */


    @Test
    public void testClimbStairs() throws Exception {

        Assert.assertEquals(3, climbStairsRecursive(3));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertEquals(3, climbStairsDynamic(3));
    }

    private int climbStairsDynamic(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    public int climbStairsRecursive(int n) {
        if (n <= 1) return 1;
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }
}
