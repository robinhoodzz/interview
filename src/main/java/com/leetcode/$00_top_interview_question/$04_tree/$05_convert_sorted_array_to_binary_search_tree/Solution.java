package com.leetcode.$00_top_interview_question.$04_tree.$05_convert_sorted_array_to_binary_search_tree;


/**
 * Created by robin on 19/3/1.
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{-10, -3, 0, 5, 9};
        Integer[] b = new Integer[]{0, -3, 9, -10, null, 5};

        System.out.println(sortedArrayToBST(a));
        System.out.println(sortedArrayToBST(b));

    }

    public static TreeNode sortedArrayToBST(Integer[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(Integer[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}