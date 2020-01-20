package algo.$3_greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 不重叠区间个数
 * 435. Non-overlapping Intervals (Medium)
 * <p>
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * -
 * Input: [ [1,2], [2,3] ]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * <p>
 * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
 * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 * <p>
 * 我的总结:
 * 用本次最左与上次最右比较, 本次最左<=上次最右, 则是重叠
 */
public class $2_NonOverlappingIntervals {

    private int[][] a1 = new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}};
    private int[][] a2 = new int[][]{new int[]{1, 2}, new int[]{2, 3}};


    @Test
    public void testNonOverlapping() {

        int i1 = eraseOverlapIntervals(a1);
        int i2 = eraseOverlapIntervals(a2);

        Assert.assertEquals(2, i1);
        Assert.assertEquals(0, i2);
    }


    public int nonOverlapping(int[][] a) {
        if (a.length == 0) {
            return 0;
        }

        // 缺少一步排序, 因为可能出现如: [2,1] [3,2] 这种
        Arrays.sort(a, Comparator.comparingInt(x -> x[0]));

        int over = 0;

        int l = 0;
        int r = 0;

        for (int[] ax : a) {
            if (ax[0] < l || ax[1] > r) {
                over++;
            }
            l = ax[0];
            r = ax[1];
        }

        return a.length - over;
    }

    /**
     * 给出的答案
     * 与自己的区别
     * <p>
     * 1.排序
     * 2.只用right指针即可
     * 3.for循环可以再精简
     * 4.
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
