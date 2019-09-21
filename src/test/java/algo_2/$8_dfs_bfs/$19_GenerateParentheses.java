package algo_2.$8_dfs_bfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号, 输入N, 生成N对括号
 * 22
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class $19_GenerateParentheses {

    /*
     描述:
     n=1时, ()
     n=2时, ()(), (())
     以此类推

     思路:
     1. 数学归纳法, 比较复杂
        在n=1的基础上, 嵌套或者追加
     2. 递归搜索
        字符串长度 = 2 * n
        枚举各种情况,如((((((,))))))但是时间复杂度很高 O的2N次方
     3. 改进: 剪枝
        1. 局部不合法, 不再递归
        2. 左括号只能放3个, 右括号也是如此, left,right用了多少
        复杂度O(2^N)

     条件理解为:
     1. 左括号的次数 < n (总数2n, 小于一半)
     2. 右括号的次数 < n
     3. 右括号的次数不能 < 左括号次数 (非法)

     */

    List<String> list = new ArrayList<>();

    @Test
    public void testGenerateParentheses() {
        generateParentheses(3);
        System.out.println(list);
        Assert.assertEquals("[((())), (()()), (())(), ()(()), ()()()]", list.toString());
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<String> list1 = generateParentheses_2(3);
        System.out.println(list1);
        Assert.assertEquals("[((())), (()()), (())(), ()(()), ()()()]", list1.toString());
    }


    private void generateParentheses(int n) {
        generateParentheses(0, 0, n, "");
    }

    private void generateParentheses(int left, int right, int n, String result) {
        if (left == n && right == n) {
            list.add(result);
            return;
        }

        if (left < n) {
            generateParentheses(left + 1, right, n, result + "(");
        }
        if (left > right && right < n) {
            generateParentheses(left, right + 1, n, result + ")");
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private List<String> generateParentheses_2(int n) {
        List<String> list = new ArrayList<>();
        generateOneByOne("", list, n, n);
        return list;
    }

    /**
     * @param s     原始字符串
     * @param list  结果集
     * @param left  左括号剩余数量
     * @param right 右括号剩余数量
     */
    private void generateOneByOne(String s, List<String> list, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(s);
            return;
        }

        if (left > 0) {
            generateOneByOne(s + "(", list, left - 1, right);
        }
        if (right > left) {
            generateOneByOne(s + ")", list, left, right - 1);
        }


    }
}
