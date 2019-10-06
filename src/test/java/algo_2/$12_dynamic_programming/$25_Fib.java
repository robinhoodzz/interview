package algo_2.$12_dynamic_programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * 斐波那契数列 + 动态规划
 * Created by Administrator on 2019/10/5.
 */
public class $25_Fib {

    int[] cache = new int[100];
    int[] cache2 = new int[100];

    {
        cache[0] = 0;
        cache[1] = 1;
        cache2[0] = 0;
        cache2[1] = 1;
    }

    @Test
    public void testFib() throws Exception {

        Assert.assertEquals(0, fib(0));
        Assert.assertEquals(1, fib(1));
        Assert.assertEquals(1, fib(2));
        Assert.assertEquals(2, fib(3));
        Assert.assertEquals(3, fib(4));
        Assert.assertEquals(5, fib(5));
        Assert.assertEquals(8, fib(6));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Assert.assertEquals(0, fibUseCache(0));
        Assert.assertEquals(1, fibUseCache(1));
        Assert.assertEquals(1, fibUseCache(2));
        Assert.assertEquals(2, fibUseCache(3));
        Assert.assertEquals(3, fibUseCache(4));
        Assert.assertEquals(5, fibUseCache(5));
        Assert.assertEquals(8, fibUseCache(6));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Assert.assertEquals(0, fibUseDynamic(0));
        Assert.assertEquals(1, fibUseDynamic(1));
        Assert.assertEquals(1, fibUseDynamic(2));
        Assert.assertEquals(2, fibUseDynamic(3));
        Assert.assertEquals(3, fibUseDynamic(4));
        Assert.assertEquals(5, fibUseDynamic(5));
        Assert.assertEquals(8, fibUseDynamic(6));



    }

    public int fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }

    public int fibUseCache(int n) {
        if (n <= 1) {
            return n;
        } else if (cache[n] == 0) {
            cache[n] = fibUseCache(n - 1) + fibUseCache(n - 2);
        }
        return cache[n];
    }


    public int fibUseDynamic(int n) {
        for (int i = 2; i <= n ; i++) {
            cache2[i] = cache2[i - 1] + cache2[i - 2];
        }
        return cache2[n];
    }


}
