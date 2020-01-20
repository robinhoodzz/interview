package algo_2.$6_recursive_divide_conquer;

import org.junit.Assert;
import org.junit.Test;

/**
 * 即计算 x 的 n 次幂函数。
 * 50
 * <p>
 * Created by Administrator on 2019/9/15.
 */
public class $16_Pow {
    /*
    思路:
    1. 调用函数库, 但是面试不会这样
    2. 暴力, 使用循环求解, 时间 O(N)
    3. 分治
       拆分成  n/2 个 x 相乘
       y = x ^ (1/2), 再转换成  y * y
    4. 非递归
     */

    @Test
    public void testMyPow() throws Exception {
        Assert.assertEquals(4.00000, myPow(2.00000, 2), 0.00);
        Assert.assertEquals(8.00000, myPow(2.00000, 3), 0.00);
        Assert.assertEquals(16.00000, myPow(2.00000, 4), 0.00);
        Assert.assertEquals(1024.00000, myPow(2.00000, 10), 0.00);
        Assert.assertEquals(9.26100, myPow(2.10000, 3), 0.00000000000001);
        Assert.assertEquals(0.25000, myPow(2.00000, -2), 0.00);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertEquals(4.00000, myPowNoRe(2.00000, 2), 0.00);
        Assert.assertEquals(8.00000, myPowNoRe(2.00000, 3), 0.00);
        Assert.assertEquals(16.00000, myPowNoRe(2.00000, 4), 0.00);
        Assert.assertEquals(1024.00000, myPowNoRe(2.00000, 10), 0.00);
        Assert.assertEquals(9.26100, myPowNoRe(2.10000, 3), 0.00000000000001);
        Assert.assertEquals(0.25000, myPowNoRe(2.00000, -2), 0.00);
    }

    public double myPow(double x, int n) {
        if (n < 0) return 1 / x * myPow(1 / x, -(n + 1)); // n次幂当n为负, 相当于底数的倒数的N次幂
        if (n == 0) return 1;
        if (n == 2) return x * x;
        if (n % 2 == 0) return myPow(myPow(x, n / 2), 2); // 相当于 [x ^ (n/2)] ^ 2, x的二分之N的平方
        else return x * myPow(myPow(x, n / 2), 2); // 相当于 x的二分之N的平方再乘以x
    }

    double myPowNoRe(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
