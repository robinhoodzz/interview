package com.dt.demo12_binarysorttree;

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

        // 判断是否是平衡二叉树
        // 进行右旋转
        if (left.height() - right.height() >= 2) {
            rightRotate();
            // 左旋转
        } else {
            leftRotate();
        }
    }

    /**
     * 左边旋转
     *
     * 步骤:
     * 1. 构建一个新的 当前节点 newCurr
     * 2. 构建一个新的 当前节点的左节点 newCurrLeft, 并作为 newCurr的左节点
     * 3. 投建一个新的 当前节点的右节点的左节点 newCurrRightLeft, 并作为 newCurr的右节点
     * 4. 当前节点的值 等于 当前节点右节点的值 curr.value = curr.right.value
     * 5. 当前节点的右节点 等于 当前节点的右节点的右节点
     * 6. 新节点 等于 当前节点的左节点
     *
     */
    private void leftRotate() {

        Node newCurr = new Node(this.value);

        Node newCurrLeft = this.left;

        Node newCurrRightLeft = this.right.left;

        this.value = this.right.value;

        this.right = this.right.right;

        this.left = newCurr;


    }

    /**
     * 右边旋转
     * <p>
     * 步骤:
     * 1. 构建一个新的当前节点 newCurr
     * 2. 构建一个新的当前节点的右节点 newCurrRight, 并作为newCurr的右节点
     * 3. 构建一个新的当前节点的左节点的右节点 newCurrLeftRight, 并作为newCurr的左节点
     * _________newCurr___________
     * |                           |
     * newCurrLeftRight             newCurrRight
     *
     * 4. 让当前节点的值 变为 当前左节点的值  curr.value = curr.left.value
     * 5. 让当前节点的左节点为当前节点的左节点的左节点 curr.left = curr.left.left
     * 6. 让当前节点的右节点为新构造的节点 curr.right = newCurr
     */
    private void rightRotate() {
        // 创建新节点, 值等于当前节点的值
        Node newCurr = new Node(this.value);
        // 把新节点的右子树设置了当前节点的右子树
        newCurr.right = this.right;
        // 把新节点的左子树设置为 当前节点的左子树的右子树
        newCurr.left = this.left.right;
        // 把当前节点的值换为左子节点的值
        this.value = this.left.value;
        // 把当前节点的左子树设置为左子树的左子树
        this.left = this.left.left;
        // 把当前节点的右子树设置为新节点
        this.right = newCurr;
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
        else if (this.right != null && value > this.value)
            return this.right.searchParent(value);

        return null;
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
}
