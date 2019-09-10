package algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最长子序列
 * 524. Longest Word in Dictionary through Deleting (Medium)
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 * "apple"
 *
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
 * 通过删除字符串 s 中的一个字符能得到字符串 t，可以认为 t 是 s 的子序列，我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
 *
 * 我的思路: 用数组去找字符串, 而不是用字符串找数组
 *
 */
public class $7_LongestWordInDic {

    private String s = "abpcplea";
    private String[] d = {"ale", "apple", "monkey", "plea"};

    @Test
    public void testLongWord() {
        Assert.assertTrue("", isMatch("abpcplea", "apple"));
        Assert.assertTrue("", isMatch("abpcplea", "plea"));
        Assert.assertFalse("", isMatch("abpcplea", "money"));

        String x = longWord(this.s, d);
        Assert.assertEquals("apple", x);


    }

    private String longWord(String s, String[] d) {

        /* 变量: 已经匹配的字符串 */
        String l = "";

        for (String x : d) {
            boolean match = isMatch(s, x);
            if(match) {
                l = x.length() > l.length() ? x : l;
            }
        }


        return l;
    }

    private boolean isMatch(String s, String x) {


        int si = 0;
        int xi = 0;
        int matchTime = 0;

        while (si <= s.length() - 1 && xi <= x.length() - 1) {
            if (s.charAt(si) == x.charAt(xi)) {
                matchTime++;
                si++;
                xi++;
            } else {
                si++;
            }
        }

        return x.length() == matchTime;
    }


}
