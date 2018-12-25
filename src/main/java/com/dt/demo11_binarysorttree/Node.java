package com.dt.demo11_binarysorttree;

/**
 * Created by Administrator on 2018/12/24.
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

        // 判断传入的节点的值,与当前子树的根节点的值 大还是小
        if (node.value < this.value) { // 要添加的节点值 < 当前节点值
            if (this.left == null) { // 如果左子节点为空, 则新节点为当前节点的左子树
                this.left = node;
            } else {
                left.add(node);
            }
        } else { // 要添加的节点值 > 当前节点值
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 先序遍历
     */
    public void frontShow() {
        System.out.print(this.value + ",");
        if (this.left != null) left.frontShow();
        if (this.right != null) right.frontShow();
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        if (this.left != null) this.left.midShow();
        System.out.print(this.value + ",");
        if (this.right != null) this.right.midShow();
    }

    /**
     * 节点的查找
     *
     * @param value 值
     * @return
     */
    public Node search(int value) {
        if (this.value == value) return this;
        if (value < this.value && left != null) return left.search(value);
        if (value > this.value && right != null) return right.search(value);
        return null;
    }

    /**
     * 查找父节点
     *
     * @param value 值
     * @return
     */
    public Node searchParent(int value) {

        if (this.left != null && left.value == value) return this;
        if (this.right != null && right.value == value) return this;

        if (this.left != null && value < this.value)
            return this.left.searchParent(value);
        else if(this.right != null && value > this.value)
            return this.right.searchParent(value);

        return null;
    }
}
