package com.leetcode.$00_top_interview_question.$05_sorting_and_searching.$000_raisedownfindmax;

/**
 * Created by Administrator on 2019/2/28.
 */
public class RaiseDownFindMax {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 5, 5, 9, 4, 4, 2, 1};
//        int[] a = new int[]{1, 2, 2, 5, 1};
        System.out.println(findMax(a));
    }

    public static int findMax(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left <= right) {
//            mid = left + (right - left) >> 1;
            mid = left + (right - left) / 2;

//            if (a[mid] < a[mid + 1] && a[mid] >= a[mid - 1]) {
//                left = mid;
//            } else if (a[mid] > a[mid + 1] && a[mid] <= a[mid - 1]) {
//
//            }
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return a[mid];
            } else if (a[mid] == a[mid + 1]) {
                right--;
            } else if (a[mid] == a[mid - 1]) {
                left++;
            } else if (a[mid] > a[left]) {
                left = mid;
            } else if (a[mid] > a[right]) {
                right = mid;
            }
        }
        return a[left + (right - left) / 2];
    }
}
