package algo.$1_double_pointer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 反转字符串中的元音字符
 * 345. Reverse Vowels of a String (Easy)
 *
 * Given s = "leetcode", return "leotcede".
 */
public class $3_ReverseVowelOfAString {

    private Set<Character> set = new HashSet<>();
    private String sample = "leetcode";


    @Before
    public void setUp() throws Exception {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

    }

    /**
     * 提供了2种思路, 都可以解决
     * 1. 基于数组交换
     * 2. 基于数组插入
     */
    @Test
    public void testReverseVowelOfAString() {
        /* 基于数组交换 */
        String resultOld = reverseVowelOfAStringOld(sample);
        System.out.println(resultOld);
        Assert.assertEquals("leotcede", resultOld);

        /* 基于数组插入 */
        String resultNew = reverseVowelOfAStringNew(sample);
        System.out.println(resultNew);
        Assert.assertEquals("leotcede", resultNew);
    }


    public String reverseVowelOfAStringNew(String sample) {
        int i = 0, j = sample.length() - 1;
        char[] chars = new char[sample.length()];
        while (i <= j) {
            char ci = sample.charAt(i);
            char cj = sample.charAt(j);
            if (set.contains(sample.charAt(i)) && set.contains(sample.charAt(j))) {
                chars[i++] = cj;
                chars[j--] = ci;
            } else if (!set.contains(sample.charAt(i)) && set.contains(sample.charAt(j))) {
                chars[i++] = ci;
            } else {
                chars[j--] = cj;
            }
        }
        return new String(chars);
    }


    public String reverseVowelOfAStringOld(String sample) {
        int head = 0, tail = sample.length() - 1;
        // 这里返回的是一个新数组
        char[] chars = sample.toCharArray();
        while (head <= tail) {
            if (set.contains(chars[head]) && set.contains(chars[tail])) {
                swap(chars, head, tail);
                head++;
                tail--;
            } else if (!set.contains(chars[head]) && set.contains(chars[tail])) {
                head++;
            } else {
                tail--;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int head, int tail) {
        char tmp = chars[head];
        chars[head] = chars[tail];
        chars[tail] = tmp;
    }

}
