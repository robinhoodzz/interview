package algo_2.$9_binary_search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 求平方根
 * <p>
 * Created by Administrator on 2019/9/21.
 */
public class $21_SquareRoot {


    @Test
    public void name() throws Exception {

        Assert.assertEquals(2, sqrt(4));
        Assert.assertEquals(2, sqrt(8));
        Assert.assertEquals(3, sqrt(9));
        Assert.assertEquals(4, sqrt(16));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertEquals(2, newton(4));
        Assert.assertEquals(2, newton(8));
        Assert.assertEquals(3, newton(9));
        Assert.assertEquals(4, newton(16));

    }


    public int sqrt(int x) {
        if (x == 0 || x == 1) return x;

        int l = 1, r = x, m = 0, res = 0;
        while (l <= r) {
            m = (r - l) / 2 + l;

            if (m == x / m) return m;
            else if (m > x / m) r = m - 1;
            else {
                l = m + 1;
                res = m;
            }

        }
        return res;
    }

    public int newton(int x) {
        int r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }


}
