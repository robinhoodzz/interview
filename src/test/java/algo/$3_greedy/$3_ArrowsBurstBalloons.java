package algo.$3_greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 投飞镖刺破气球
 * 452. Minimum Number of Arrows to Burst Balloons (Medium)
 * 题目描述：气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的投飞镖次数使所有气球都被刺破。
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 * Output:
 * 2
 * 思路:
 * 也是计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
 * <p>
 * 用本次最左与上次最右比较, 本次最左<=上次最右, 则是重叠
 */
public class $3_ArrowsBurstBalloons {

    private int[][] a = new int[][]{new int[]{10, 16}, new int[]{2, 8}, new int[]{1, 6}, new int[]{7, 12}};

    @Test
    public void testArrowsBurstBalloon() {

        int i = arrowsBurstBalloon(a);
        Assert.assertEquals(2, i);

    }

    public int arrowsBurstBalloon(int[][] a) {
        if (a.length == 0) {
            return 0;
        }

        Arrays.sort(a, Comparator.comparing(x -> x[0]));
        int m = 1;
        int r = a[0][1];

        for (int i = 1; i < a.length; i++) {
            if (a[i][0] <= r) {
                continue;
            }
            m++;
            r = a[i][1];

        }
        return m;
    }
}
