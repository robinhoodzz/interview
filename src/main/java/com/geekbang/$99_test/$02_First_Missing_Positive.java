package com.geekbang.$99_test;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/2/8.
 */
public class $02_First_Missing_Positive {

    public static void main(String[] args) {
        $02_First_Missing_Positive solution = new $02_First_Missing_Positive();

        int[] arr1 = new int[]{1, 2, 0}; // 3
        int[] arr2 = new int[]{3, 4, -1, 1}; // 2
        int[] arr3 = new int[]{7, 8, 9, 11, 12};
        int[] arr4 = new int[]{};
        int[] arr5 = new int[]{2};
        int[] arr6 = new int[]{-2};
        int[] arr7 = new int[]{1};
        int[] arr8 = new int[]{3};
        int[] arr9 = new int[]{-1, -2};
        int[] arr10 = new int[]{-1, 1000};

        System.out.println(solution.firstMissingPositive(arr1));
        System.out.println(solution.firstMissingPositive(arr2));
        System.out.println(solution.firstMissingPositive(arr3));
        System.out.println(solution.firstMissingPositive(arr4));
        System.out.println(solution.firstMissingPositive(arr5));
        System.out.println(solution.firstMissingPositive(arr6));
        System.out.println(solution.firstMissingPositive(arr7));
        System.out.println(solution.firstMissingPositive(arr8));
        System.out.println(solution.firstMissingPositive(arr9));
        System.out.println(solution.firstMissingPositive(arr10));
    }

    public int firstMissingPositive(int[] nums) {

        if (nums.length == 0) return 1;


        if (nums.length == 1) {
            if (nums[0] > 1) return 1;
            else if (nums[0] == 1) return 2;
            else return 1;
        }


        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] > 0 && nums[i] - 1 > 0) {
                return 1;
            }
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] > 0 ? nums[nums.length - 1] + 1 : 1;


    }

}
