package com.geekbang.$99_test;

/**
 * Created by Administrator on 2019/2/8.
 */
public class $21_Sqrt {

    public static void main(String[] args) {

        $21_Sqrt solution = new $21_Sqrt();

        int a = 8;

        float b = 17F;
        float precision = 0.0001F;
        System.out.println(solution.mySqrt(a));
        System.out.println(solution.mySqrt(b, precision));
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int start = 1, end = x;
        while (true) {
            int mid = start + (end - start) / 2;
            if (mid > x / mid)
                end = mid - 1;
            else if (mid + 1 > x / (mid + 1))
                return mid;
            else
                start = mid + 1;
        }
    }


    public float mySqrt(float x, float precision) {

        float root = x / 2;

        while (true) {
            float sq = root * root;

            if (sq - x > 0 && sq - x < precision) {
                return root;
            } else if (sq > x) {
                root = root / 2;
            } else {
                root = root + root / 2;
            }

        }


    }


}
