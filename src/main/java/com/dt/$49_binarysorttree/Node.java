package com.dt.$49_binarysorttree;

/**
 * Created by robin on 18/12/21.
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 向子树中添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) return;

        // 判断传入的节点的值(node) 与 当前子树的根节点的值(this) 大还是小
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void frontShow() {
        System.out.println(this.value);
        if (this.left != null) this.left.frontShow();
        if (this.right != null) this.right.frontShow();
    }

    public void midShow() {
        if (this.left != null) this.left.midShow();
        System.out.println(this.value);
        if (this.right != null) this.right.midShow();
    }


    public Node search(int value) {
        if (value == this.value)
            return this;
        if (value < this.value && this.left != null)
            return this.left.search(value);
        else if (value > this.value && this.right != null)
            return this.right.search(value);
        return null;
    }

    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && value < this.value) {
                return this.left.searchParent(value);
            } else if (this.right != null && value > this.value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void delete(int value) {
        System.out.println(searchParent(value).value);
    }


}
