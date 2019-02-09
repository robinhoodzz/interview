package com.geekbang.$99_test;

/**
 * Created by Administrator on 2019/2/8.
 */
public class $41_reverseWord {

    public static void main(String[] args) {
        String str = "the sky is blue";
        $41_reverseWord solution = new $41_reverseWord();
        System.out.println(solution.reverseWords(str));
    }

    public String reverseWords(String s) {
        String newWord = "";
        String[] strs = s.trim().split(" +");
        for (int i = strs.length - 1; i >= 0; i--) {
            newWord += strs[i] + " ";
        }
        return newWord.trim();

//        String[] arr = s.trim().split(" +");
//        String s1="";
//        for(int i = arr.length-1; i>=0; i--){
//            s1=s1+arr[i] + " ";
//        }
//        return s1.trim();

    }
}
