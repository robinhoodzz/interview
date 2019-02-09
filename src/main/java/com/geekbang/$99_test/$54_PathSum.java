package com.geekbang.$99_test;

import java.util.Stack;

/**
 * Created by Administrator on 2019/2/9.
 */
public class $54_PathSum {

    public static void main(String[] args) {
        $54_PathSum solution = new $54_PathSum();

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = null;

        node3.left = node5;
        node3.right = node6;

        node4.left = node7;
        node4.right = node8;

        node6.right = node9;

        int sum = 22;

        System.out.println(node1);
        System.out.println(solution.hasPathSum(node1, sum));
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() && root != null) {
            TreeNode cur = stack.pop();

            if (cur.left == null && cur.right == null) {
                if (cur.val == sum) return true;
            }

            if (cur.right != null) {
                cur.right.val = cur.val + cur.right.val;
                stack.push(cur.right);

            }

            if (cur.left != null) {
                cur.left.val = cur.val + cur.left.val;
                stack.push(cur.left);
            }
        }
        return false;
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
