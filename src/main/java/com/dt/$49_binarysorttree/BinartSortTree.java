package com.dt.$49_binarysorttree;

/**
 * Created by robin on 18/12/21.
 */
public class BinartSortTree {

    Node root;


    /**
     * 向二叉排序树中添加点解
     *
     * @param node
     */
    public void add(Node node) {
        // 如果是一颗空树
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void frontShow() {
        root.frontShow();
    }

    public void midShow() {
        root.midShow();
    }

    public Node search(int value) {
        return root.search(value);
    }

    public Node searchParent(int value) {
        if (root == null) return null;
        return root.searchParent(value);
    }

    public void delete(int value) {
        if (root == null) return;


        Node target = this.search(value);
        if (target == null) return;

        // 找到他的父节点
        Node parent = this.searchParent(value);
        // 要删除的节点是叶子节点
        if (target.left == null && target.right == null) {
            if (parent.left.value == value) {
                parent.left = null;
            }
            if (parent.right.value == value) {
                parent.right = null;
            }
            // 要删除的节点与有2个子节点的情况
        } else if (target.left != null && target.right != null) {
            // 删除右子树中值最小的节点, 获取到该节点的值
            int min = this.deleteMin(target.right);
            // 替换目标节点中的值
            target.value = min;


            // 要删除的节点有1个子节点的情况
        } else {
            // 有左子节点
            if (target.left != null) {
                // 要删除的节点是父节点的左子节点
                if (parent.left.value == value) {
                    parent.left = target.left;
                } else {
                    parent.right = target.left;
                }
                // 有右子节点
            } else {
                // 要删除的节点是父节点的右子节点
                if (parent.left.value == value) {
                    parent.left = target.right;
                } else {
                    parent.right = target.right;
                }
            }
        }


        root.delete(value);
    }

    /**
     * 删除一棵树中最小的节点
     *
     * @param node
     * @return
     */
    private int deleteMin(Node node) {

        Node target = node;
        // 递归向左找
        while (target.left != null) {
            target = target.left;
        }
        // 删除最小的节点
        delete(target.value);

        return target.value;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9};
        BinartSortTree tree = new BinartSortTree();
        for (int i : arr) {
            tree.add(new Node(i));
        }


//        tree.frontShow();
        tree.midShow();

        Node node = tree.search(5);
        System.out.println(node == null ? null : node.value);


        tree.delete(7);
    }
}
