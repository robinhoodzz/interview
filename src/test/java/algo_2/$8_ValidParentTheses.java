package algo_2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断括号是否合法
 * Created by Administrator on 2019/9/13.
 * Input: "()"
 * Output: true
 * Input: "()[]{}"
 * Output: true
 * Input: "(]"
 * Output: false
 * Input: "([)]"
 * Output: false
 * Input: "{[]}"
 * Output: true
 */
public class $8_ValidParentTheses {
    /*
    思路
    1. 左 -> push
    2, 右 -> peek ? pop
    3. 返回stack是否是空
     */

    @Test
    public void testValidParentTheses() throws Exception {
        Assert.assertTrue(validParentThesesOld("()"));
        Assert.assertTrue(validParentThesesOld("()[]{}"));
        Assert.assertFalse(validParentThesesOld("(]"));
        Assert.assertFalse(validParentThesesOld("([)]"));
        Assert.assertTrue(validParentThesesOld("{[]}"));
        Assert.assertFalse(validParentThesesOld("((([]))"));
        Assert.assertFalse(validParentThesesOld("]][["));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertTrue(validParentTheses1("()"));
        Assert.assertTrue(validParentTheses1("()[]{}"));
        Assert.assertFalse(validParentTheses1("(]"));
        Assert.assertFalse(validParentTheses1("([)]"));
        Assert.assertTrue(validParentTheses1("{[]}"));
        Assert.assertFalse(validParentTheses1("((([]))"));
        Assert.assertFalse(validParentTheses1("]][["));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertTrue(validParentTheses2("()"));
        Assert.assertTrue(validParentTheses2("()[]{}"));
        Assert.assertFalse(validParentTheses2("(]"));
        Assert.assertFalse(validParentTheses2("([)]"));
        Assert.assertTrue(validParentTheses2("{[]}"));
        Assert.assertFalse(validParentTheses2("((([]))"));
        Assert.assertFalse(validParentTheses2("]][["));
    }

    /**
     * 用栈 空间O(n) 时间O(n)
     * @param s
     * @return
     */
    public boolean validParentTheses1(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && map.get(c) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 用字符串替换 很难判定时间空间复杂度, 差于用栈
     * @param s
     * @return
     */
    public boolean validParentTheses2(String s) {
        int length;
        do {
            length = s.length();
            s = s.replaceAll("\\(\\)", "").replaceAll("\\[]", "").replaceAll("\\{}", "");
        } while (length != s.length());

        return s.length() == 0;
    }


    public boolean validParentThesesOld(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            Character peek = stack.isEmpty() ? null : stack.peek();
            if (peek != null && peek.equals(map.get(aChar))) {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

}
