package algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 回文字符串
 * 680. Valid Palindrome II (Easy)
 * <p>
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 * <p>
 * 思路: 当出现不一致的情况时, 左指针右移动,判定是否回文数, 右指针左移动,判定是否回文
 */
public class $4_Palindrome {


    private String s = null;

    @Before
    public void setUp() throws Exception {
        s = "abca";
    }


    @Test
    public void testPalinDrome() {
        boolean b = isPalinDrome(s);
        Assert.assertTrue("", b);
    }

    boolean isPalinDrome(String s) {
        int i = 0, j = s.length() - 1;
        while (s.charAt(i++) != s.charAt(j--)) {
            return isPalinDrome(s, i + 1, j) || isPalinDrome(s, i, j - 1);
        }
        return true;
    }

    boolean isPalinDrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
