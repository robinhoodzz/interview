package com.leetcode.$00_top_interview_question.$04_tree.$01_maximum_depth_of_binary_tree;

/**
 * 3
 * /  \
 * 9  20
 * /  \
 * 15   7
 * Created by Administrator on 2019/2/28.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;

        n3.left = n4;
        n3.right = n5;

        System.out.println(maxDepth(n1));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
