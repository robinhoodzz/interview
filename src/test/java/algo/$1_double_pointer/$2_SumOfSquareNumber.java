package algo.$1_double_pointer;

import org.junit.Before;
import org.junit.Test;

/**
 * 两数平方和
 * 633. Sum of Square Numbers (Easy)
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 双指针
 * small = 1, big = 平方根(number)
 * 平方(small) + 平方(number) == target, 返回true
 * 平方(small) + 平方(number) > target, big往小移动
 * 平方(small) + 平方(number) < target, small往大移动
 *
 *
 */
public class $2_SumOfSquareNumber {

    private int number;

    @Before
    public void setUp() throws Exception {
        number = 5;
    }

    @Test
    public void testSumOfSquareNumber() {

        boolean b = sumOfSquareNumber(number);
        System.out.println(b);
    }

    private boolean sumOfSquareNumber(int number) {
        int small = 1, big = (int) Math.sqrt(number);
        while (small <= big) {
            int i = small * small + big * big;
            if (i == number) {
                return true;
            } else if (i > number) {
                big--;
            } else {
                small++;
            }
        }
        return false;
    }

}
