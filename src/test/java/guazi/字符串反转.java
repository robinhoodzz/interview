package guazi;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by robin on 19/1/30.
 */
public class 字符串反转 {

    @Test
    public void name() throws Exception {
//        String ori = "___abc_def__gh_";
        String ori = "ab___c_def__gh_";
        String reverse = reverse(ori);
        System.out.println(ori);
        System.out.println(reverse);

    }

    /**
     * 字符串反转
     *
     * @param ori 原始字符串
     * @return
     */
    private String reverse(String ori) {
        char[] a = ori.toCharArray();
        char[] b = null;
        String reverse = "";


        int left = 0;
        int right = 1;

        Stack<String> stack = new Stack<>();
        while (right < a.length) {

            while (a[left] == '_' && a[right] == '_') {
                right++;
            }
            while (a[left] != '_' && a[right] != '_') {
                right++;
            }

            b = new char[right - left];
            System.arraycopy(a, left, b, 0, right - left);


            stack.push(new String(b));

            if (right == a.length - 1) {
                stack.push(String.valueOf(a[right]));
            }

            left = right;
            right = left + 1;


        }

        while (!stack.isEmpty()) {
            reverse += stack.pop();
        }


        return reverse;
    }

    /**
     * 字符串反转
     *
     * @param ori 原始字符串
     * @return
     */
    private String reverse2(String ori) {
        char[] a = ori.toCharArray();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {

        }


        return null;
    }


}
