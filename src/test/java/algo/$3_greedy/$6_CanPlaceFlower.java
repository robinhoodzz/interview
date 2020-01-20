package algo.$3_greedy;

import org.junit.Assert;
import org.junit.Test;

/**
 * 种植花朵
 * 605. Can Place Flowers (Easy)
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * -
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * 题目描述：flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下 n 朵花。
 */
public class $6_CanPlaceFlower {


    int[] a = new int[]{1, 0, 0, 0, 1};

    @Test
    public void testCanPlaceFlower() {
        boolean b1 = canPlaceFlower(a, 1);
        Assert.assertTrue(b1);

        boolean b2 = canPlaceFlower(a, 2);
        Assert.assertFalse(b2);

    }

    public boolean canPlaceFlower(int[] a, int n) {
        int k = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == 1) {
                continue;
            }
            int pre = (i == 0 ? 0 : a[i - 1]);
            int next = (i == a.length - 1 ? a.length - 1 : a[i + 1]);
            if (pre == 0 && next == 0) {
                k++;
                a[i] = 1;
            }
        }

        return k >= n;
    }
}
