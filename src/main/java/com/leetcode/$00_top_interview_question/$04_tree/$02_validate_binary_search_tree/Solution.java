package com.leetcode.$00_top_interview_question.$04_tree.$02_validate_binary_search_tree;

/**
 * Created by Administrator on 2019/2/28.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        TreeNode nn1 = new TreeNode(5);
        TreeNode nn2 = new TreeNode(1);
        TreeNode nn3 = new TreeNode(4);
        TreeNode nn4 = new TreeNode(3);
        TreeNode nn5 = new TreeNode(6);

        nn1.left = nn2;
        nn1.right = nn3;

        nn3.left = nn4;
        nn3.right = nn5;

        System.out.println(isValidBST(n1));
        System.out.println(isValidBST(nn1));


    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long leftVal, long rightVal) {
        if (node == null) return true;
        if (leftVal > node.val || rightVal < node.val) return false;
        return isValidBST(node.left, leftVal, node.val) && isValidBST(node.right, node.val, rightVal);
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