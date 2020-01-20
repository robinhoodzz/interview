package algo_2.$6_recursive_divide_conquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 找众数
 * 169
 * 出现最多的次数, 且 count(x) > n/2
 * Created by Administrator on 2019/9/15.
 */
public class $17_Majority {
    /*
    思路
    1. 暴力, 时间O(N^2)
    2. Map计数器 时间O(N)
    3, 排序, 获取下标 n/2, 时间O(NlogN)
    4. 分治
     */

    private Map<Integer, Integer> map = new HashMap<>();

    @Test
    public void testMajority() throws Exception {

        Assert.assertEquals(3, majorityUseMap(new int[]{3, 2, 3}));
        Assert.assertEquals(2, majorityUseMap(new int[]{2, 2, 1, 1, 1, 2, 2}));
        Assert.assertEquals(3, majorityUseMap(new int[]{1, 3, 3, 2, 3}));

        Assert.assertEquals(3, majorityUseSort(new int[]{3, 2, 3}));
        Assert.assertEquals(2, majorityUseSort(new int[]{2, 2, 1, 1, 1, 2, 2}));
        Assert.assertEquals(3, majorityUseSort(new int[]{1, 3, 3, 2, 3}));

        Assert.assertEquals(3, majorityUseDivideConquer(new int[]{3, 2, 3}));
        Assert.assertEquals(2, majorityUseDivideConquer(new int[]{2, 2, 1, 1, 1, 2, 2}));
        Assert.assertEquals(3, majorityUseDivideConquer(new int[]{1, 3, 3, 2, 3}));


    }

    public int majorityUseMap(int[] a) {
        map.clear();
        for (int x : a) {
            Integer tmp = map.get(x);
            tmp = (tmp == null ? 1 : tmp + 1);
            map.put(x, tmp);
        }
        int maxValue = Integer.MIN_VALUE;
        int maxTime = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > maxTime) {
                maxTime = e.getValue();
                maxValue = e.getKey();
            }
        }

        return maxTime > a.length / 2 ? maxValue : 0;
    }

    public int majorityUseSort(int[] a) {
        Arrays.sort(a);
        return a[a.length / 2];
    }

    public int majorityUseDivideConquer(int[] a) {
        return majorityUseDivideConquer(a, 0, a.length - 1);
    }

    public int majorityUseDivideConquer(int[] a, int l, int r) {

        if (l == r) return a[l];

        int mid = (r - l) / 2 + l;
        int lv = majorityUseDivideConquer(a, l, mid);
        int rv = majorityUseDivideConquer(a, mid + 1, r);

        if (lv == rv) return lv;

        return count(a, lv, l, mid) >= count(a, rv, l, r) ? lv : rv;
    }

    private int count(int[] a, int v, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (a[i] == v) {
                count++;
            }
        }
        return count;
    }
}
