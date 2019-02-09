package com.geekbang.$99_test;

/**
 * Created by Administrator on 2019/2/9.
 */
public class $51_InvertBinaryTree {

    public static void main(String[] args) {
        $51_InvertBinaryTree solution = new $51_InvertBinaryTree();

        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        solution.invertTree(node1);
        System.out.println(node1);

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        if(root.left != null)
            invertTree(root.left);

        if(root.right != null)
            invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
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
