package com.dt.demo12_binarysorttree;

/**
 * 二叉排序树
 * Created by Administrator on 2018/12/24.
 */
public class TestBinarySortTree {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        BinarySortTree tree = new BinarySortTree();
        for (int i : arr) {
            tree.add(new Node(i));
        }


        // 查看高度
        System.out.println(tree.root.height());

    }
}
