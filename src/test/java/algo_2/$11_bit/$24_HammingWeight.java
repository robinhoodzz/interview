package algo_2.$11_bit;

import org.junit.Assert;
import org.junit.Test;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * 191
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by Administrator on 2019/9/21.
 */
public class $24_HammingWeight {

    @Test
    public void testHammingWeight() throws Exception {
        Assert.assertEquals(2, mod2(3));
        Assert.assertEquals(2, mod2(5));
        Assert.assertEquals(1, mod2(8));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertEquals(2, bit(3));
        Assert.assertEquals(2, bit(5));
        Assert.assertEquals(1, bit(8));
    }

    /**
     * 位运算
     * 举例 3 (011)
     * 011 & 010 =
     * 010 (cnt++)
     * <p>
     * 010 & 001 =
     * 000 (cnt++)
     * <p>
     * 返回2
     *
     * @param i 十进制数字
     * @return
     */
    private int bit(int i) {
        int cnt = 0;
        while (i != 0) {
            i = i & i - 1;
            cnt++;
        }
        return cnt;
    }

    /**
     * 模2
     *
     * @param i 十进制数字
     * @return
     */
    private int mod2(int i) {
        int cnt = 0;
        while (i != 0) {
            if (i % 2 == 1) {
                cnt++;
            }
            i = i >> 1;
        }
        return cnt;
    }
}


