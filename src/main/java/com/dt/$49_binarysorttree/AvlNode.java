package com.dt.$49_binarysorttree;

/**
 * Created by robin on 18/12/21.
 */
public class AvlNode {

    int value;
    AvlNode left;
    AvlNode right;

    public AvlNode(int value) {
        this.value = value;
    }

    /**
     * 返回当前节点的高度
     *
     * @return
     */
    public int height() {
        return Math.max(
                left == null ? 0 : left.height(),
                right == null ? 0 : right.height())
                + 1;
    }

    /**
     * 向子树中添加节点
     *
     * @param node
     */
    public void add(AvlNode node) {
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

        // 查询是否平衡
        if ((left == null ? 0 : left.height()) - (right == null ? 0 : right.height()) > 1) {
            // 进行右旋转
            rightRotate();

        } else {
            leftRotate();
            // 左旋转
        }

    }

    private void leftRotate() {

    }

    private void rightRotate() {
        // 创建新节点, 值等于当前节点的值
        AvlNode newNode = new AvlNode(value);
        // 把新节点的右子树设置了当前节点的右子树
        newNode.right = right;
        // 把新节点的左子树设置为当前节点的左子树的右子树
        newNode.left = left.right;
        // 把当前节点的值, 换为左子节点
        value = left.value;
        // 把当前节点的左子树设置了左子树的左子树
        left = left.left;
        // 把当前节点的右子树设置为新的节点
        right = newNode;

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


    public AvlNode search(int value) {
        if (value == this.value)
            return this;
        if (value < this.value && this.left != null)
            return this.left.search(value);
        else if (value > this.value && this.right != null)
            return this.right.search(value);
        return null;
    }

    public void delete(int value) {
        System.out.println(searchParent(value).value);
    }

    public AvlNode searchParent(int value) {
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
}
