package com.geekbang.$99_test;

/**
 * Created by Administrator on 2019/2/9.
 */
public class $53_ValidateBinarySearchTree {

    public static void main(String[] args) {
        $53_ValidateBinarySearchTree solution = new $53_ValidateBinarySearchTree();

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(6);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node4.right = node5;


        System.out.println(solution.isValidBST(node1));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
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
