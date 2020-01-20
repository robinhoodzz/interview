package algo_2.$4_hash;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效字母的异位词
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * nput: s = "rat", t = "car"
 * Output: false
 * Created by Administrator on 2019/9/14.
 */
public class $11_ValidAnagram {

    /*
    思路:
    1. 排序2个字符串数组, 然后比较hashCode, 时间复杂度 O(NlogN)
    2. map收集2个字符串的分数, 然后比较Map, 时间复杂度 O(N)
     */

    @Test
    public void testValidAnagram() throws Exception {
        Assert.assertTrue(isAnagram_1("anagram", "nagaram"));
        Assert.assertFalse(isAnagram_1("rat", "car"));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertTrue(isAnagram_2("anagram", "nagaram"));
        Assert.assertFalse(isAnagram_2("rat", "car"));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertTrue(isAnagram_3("anagram", "nagaram"));
        Assert.assertFalse(isAnagram_3("rat", "car"));
    }


    public boolean isAnagram_1(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        return Arrays.equals(sc, tc);
    }

    public boolean isAnagram_2(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        for (char c : sc) {
            Integer v = sm.get(c);
            sm.put(c, v == null ? 1 : ++v);
        }

        for (char c : tc) {
            Integer v = tm.get(c);
            tm.put(c, v == null ? 1 : ++v);
        }
        return sm.equals(tm);
    }

    public boolean isAnagram_3(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] sa = new int[25];
        int[] ta = new int[25];

        for (char c : sc) {
            sa[c - 'a']++;
        }

        for (char c : tc) {
            ta[c-'a']++;
        }
        return Arrays.equals(sa, ta);
    }
}
