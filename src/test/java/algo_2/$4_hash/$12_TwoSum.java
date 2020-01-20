package algo_2.$4_hash;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * Created by Administrator on 2019/9/14.
 */
public class $12_TwoSum {

    /**
     * 思路:
     * 1. 双指针, 一左一右, 如果大, 右指针向小移动, 如果小, 左指针向右移动
     * 2. 缓存+遍历, 将target-当前值, 存入缓存, 然后遍历判等
     *
     * @throws Exception
     */
    @Test
    public void testTwoSum() throws Exception {
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, twoSum_1(new int[]{2, 7, 11, 15}, 9)));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, twoSum_2(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum_1(int[] a, int t) {
        if (a == null || a.length == 0) {
            return new int[0];
        }

        int l = 0;
        int r = a.length - 1;

        while (l < r && a[l] != a[r]) {
            if (a[l] + a[r] == t) {
                return new int[]{l, r};
            } else if (a[l] + a[r] < t) {
                l++;
            } else {
                r--;
            }
        }

        return new int[0];
    }

    public int[] twoSum_2(int[] a, int t) {
        Map<Integer, Integer> s = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if(s.containsKey(a[i])) {
                return new int[]{s.get(a[i]), i};
            }
            s.put(t - a[i], i);
        }

        return new int[0];
    }

}
