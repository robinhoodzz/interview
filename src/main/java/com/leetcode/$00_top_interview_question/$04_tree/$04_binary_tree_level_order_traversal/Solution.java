package com.leetcode.$00_top_interview_question.$04_tree.$04_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 19/3/1.
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

        List<List<Integer>> lists = levelOrder(n1);
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, 0, root);
        return result;
    }

    private static void traverse(List<List<Integer>> result, int level, TreeNode node) {
        if (node == null) return;

        if (result.size() - 1 < level) {
            result.add(new ArrayList<>());
        }
        traverse(result, level + 1, node.left);
        result.get(level).add(node.val);
        traverse(result, level + 1, node.right);
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