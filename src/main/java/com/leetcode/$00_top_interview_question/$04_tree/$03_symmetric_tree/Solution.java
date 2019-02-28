package com.leetcode.$00_top_interview_question.$04_tree.$03_symmetric_tree;

/**
 * Created by Administrator on 2019/2/28.
 */
public class Solution {


    public static void main(String[] args) {


        TreeNode nn1 = new TreeNode(1);
        TreeNode nn2 = new TreeNode(2);
        TreeNode nn3 = new TreeNode(2);
        TreeNode nn4 = new TreeNode(3);
        TreeNode nn5 = new TreeNode(4);
        TreeNode nn6 = new TreeNode(3);
        TreeNode nn7 = new TreeNode(4);

        nn1.left = nn2;
        nn1.right = nn3;

        nn2.left = nn4;
        nn2.right = nn5;

        nn3.left = nn6;
        nn3.right = nn7;


        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        n2.right = n4;
        n3.right = n5;

        System.out.println(isSymmetric(nn1));
        System.out.println(isSymmetric(n1));

    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isSymmetric(t1.right, t2.left)
                && isSymmetric(t1.left, t2.right);
    }


//    public static boolean isSymmetric(TreeNode root, TreeNode left, TreeNode right) {
//        if (root == null) return true;
//
//
//    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
