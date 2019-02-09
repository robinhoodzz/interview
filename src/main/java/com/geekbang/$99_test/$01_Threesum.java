package com.geekbang.$99_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/2/8.
 */
public class $01_Threesum {

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = threeSum(nums);

        System.out.println(lists);

    }


    public static List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> out = new ArrayList<>();

        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);

        Arrays.sort(arr);


        for (int left = 0; left < arr.length && arr[left] <= 0; left++) {
            int mid = left + 1;
            int right = arr.length - 1;
            int tmp = 0 - arr[left];

            if (left > 0 && arr[left] == arr[left - 1]) {
                continue;
            }

            while (mid < right) {


                if (arr[mid] + arr[right] == tmp) {

                    int tmp_mid = arr[mid];
                    int tmp_right = arr[right];

                    List<Integer> in = new ArrayList<>();
                    in.add(arr[left]);
                    in.add(tmp_mid);
                    in.add(tmp_right);
                    out.add(in);

                    while (mid < right && arr[++mid] == tmp_mid) ;
                    while (mid < right && arr[--right] == tmp_right) ;

                } else if (arr[mid] + arr[right] < tmp) {
                    mid++;
                } else {
                    right--;
                }
            }
        }

        return out;
    }
}
