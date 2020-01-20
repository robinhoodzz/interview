package algo.$3_greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 分配饼干
 * 455. Assign Cookies (Easy)
 * <p>
 * Input: [1,2], [1,2,3]
 * Output: 2
 * <p>
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 * 找零问题不能用贪婪算法，即使有面值为一元的币值也不行：考虑币值为100，99和1的币种，每种各一百张，找396元。
 *  动态规划可求出四张99元，但贪心算法解出需三张一百和96张一元。
 *
 *
 */
public class $1_AssignCookies {
    /*
    题目描述：每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
    给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。因为最小的孩子最容易得到满足，所以先满足最小的孩子。

    证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干。
    假设存在一种最优策略，给该孩子分配第 n 个饼干，并且 m < n。
    我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。
    因此在后续的分配中，贪心策略一定能满足更多的孩子。
    也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。
     */

    private int[] chd = new int[]{1, 2};
    private int[] cke = new int[]{1, 2, 3};


    @Test
    public void testAssignCookies() {
        int num = assignCookies(chd, cke);
        Assert.assertEquals(2, num);
    }


    public int assignCookies(int[] chd, int[] cke) {
        Arrays.sort(chd);
        Arrays.sort(cke);

        int i = 0, j = 0;
        while (i < chd.length && j < cke.length) {
            if(chd[i] <= cke[j]) {
                i++;
            } else {
                j++;
            }
        }
        return i;

    }


    public int assignCookiesOld(int[] chd, int[] cke) {
        int m = 0;
        Arrays.sort(chd);
        Arrays.sort(cke);


        for (int i = 0, j = 0; i < chd.length && j < cke.length; ) {
            if (chd[i++] <= cke[j++]) {
                m++;
            } else {
                j++;
            }
        }

        return m;
    }
}
