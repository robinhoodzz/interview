package com.leetcode.$00_top_interview_question.$01_array.$06_intersection_of_two_arrays_ii;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Created by Administrator on 2019/1/19.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums1 = new int[]{1, 2, 2, 1};
//        int[] nums2 = new int[]{2, 2};
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};

        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                list.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }

        int[] arr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
        }

        return arr;
    }

}
