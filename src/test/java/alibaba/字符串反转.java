package alibaba;

/**
 * Created by robin on 19/1/30.
 */
public class 字符串反转 {

    public static void main(String[] args) {

        String str1 = "abc";
        System.out.println(reverseTotal(str1));

        String str2 = "I am a student";
        System.out.println(reverseWordWithSpace(str2));


    }

    private static String reverseTotal(String str) {
        char[] arr = str.toCharArray();
        String x = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            x += arr[i];
        }
        return x;
    }

    private static String reverseWordWithSpace(String str) {

//        Stack<String> stack = new Stack<>();

        String[] arr = str.split(" ");
        String newStr = "";
        String space = " ";

        for (int i = arr.length - 1; i >= 0; i--) {
            newStr += arr[i] + space;
        }

        return newStr.trim();
    }

}
