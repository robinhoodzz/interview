package com.atguigu.$05_recursive;

/**
 * Created by Administrator on 2018/11/10.
 */
public class TestStep {


    public static void main(String[] args) {
        /**
         * 求n步台阶， 一共有几种走法
         * 特性
         * 1. f(n) = f(n-1) + f(n-2)  其中n>=3时成立，f(1)=1, f(2)=2
         * 2. 每加一个数， 都等于前两个数之和
         */
        TestStep tp = new TestStep();
        int possible = tp.f(7);
        System.out.println(possible);


        System.out.println(tp.loop(7));


    }

    /**
     * 递归求解
     *
     * @param n
     * @return
     */
    public int f(int n) {
        if (n < 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return f(n - 2) + f(n - 1);
    }

    /**
     * 使用 循环求解
     *
     * @param n
     * @return
     */
    public int loop(int n) {
        if (n < 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int first = 1;
        int second = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}
