package com.dt.$49_binarysorttree;

/**
 * Created by robin on 18/12/23.
 */
public class AvlTree {


    AvlNode root;


    /**
     * 向二叉排序树中添加点解
     *
     * @param node
     */
    public void add(AvlNode node) {
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

    public AvlNode search(int value) {
        return root.search(value);
    }

    public AvlNode searchParent(int value) {
        if (root == null) return null;
        return root.searchParent(value);
    }

    public void delete(int value) {
        if (root == null) return;


        AvlNode target = search(value);
        if (target == null) return;

        // 找到他的父节点
        AvlNode parent = searchParent(value);
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
            int min = deleteMin(target.right);
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
    private int deleteMin(AvlNode node) {

        AvlNode target = node;
        // 递归向左找
        while (target.left != null) {
            target = target.left;
        }
        // 删除最小的节点
        delete(target.value);

        return target.value;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 6, 7, 5, 4};
        AvlTree tree = new AvlTree();
        for (int i : arr) {
            tree.add(new AvlNode(i));
        }


//        tree.midShow();
//        AvlNode node = tree.search(5);
//        System.out.println(node == null ? null : node.value);


        System.out.println(tree.root.height());
        System.out.println(tree.root.value);
    }

}
