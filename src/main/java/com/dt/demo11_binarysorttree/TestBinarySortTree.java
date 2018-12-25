package com.dt.demo11_binarysorttree;

/**
 * 二叉排序树
 * Created by Administrator on 2018/12/24.
 */
public class TestBinarySortTree {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        BinarySortTree tree = new BinarySortTree();
        for (int i : arr) {
            tree.add(new Node(i));
        }

        System.out.println(tree);
        tree.frontShow();
        System.out.println();
        tree.midShow();
        System.out.println();

//        System.out.println(tree.search(8));

        System.out.println(tree.searchParent(10));

        tree.delete(1);
        tree.midShow();
    }
}
