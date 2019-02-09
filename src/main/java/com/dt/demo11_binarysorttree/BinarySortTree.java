package com.dt.demo11_binarysorttree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉排序树
 *
 * 性质:
 * 若左子树不空, 左子树上所有节点的值 < 它根节点的值
 * 若右子树不空, 右子树上所有节点的值 > 它根节点的值
 * 左右子树也分别为二叉排序树
 * 没有键值相等的节点
 *
 * Created by Administrator on 2018/12/24.
 */
public class BinarySortTree {

    Node root;

    /**
     * 向二叉排序树添加节点
     *
     * @param node 节点
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void frontShow() {
        if (root == null) return;
        root.frontShow();
    }


    public void midShow() {
        if (root == null) return;
        root.midShow();
    }


    /**
     * 层级遍历
     */
    public void floorShow() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + ",");
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
    }

    /**
     * 节点的查找
     *
     * @param value 值
     * @return
     */
    public Node search(int value) {
        if (root == null) return null;
        return root.search(value);
    }

    @Override
    public String toString() {
        return "BinarySortTree{" +
                "root=" + root +
                '}';
    }

    /**
     * 删除节点
     * <p>
     * 分3种情况
     * 1. 节点是 叶子节点
     * 2. 节点有 1个叶子节点
     * 3. 节点有 2个叶子节点
     *
     * @param value
     */
    public void delete(int value) {
        if (root == null) return;

        // 找到这个节点
        Node curr = this.search(value);
        if (curr == null) return;
        // 找到父节点
        Node parent = this.searchParent(value);
        if (parent == null) return;


        if (curr.left == null && curr.right == null) { // 要删除的节点是 叶子节点
            if (value == parent.left.value) { // 要删除的节点是 父节点的 左节点
                parent.left = null;
            } else { // 要删除的节点是 父节点的 右节点
                parent.right = null;
            }


        } else if (curr.left != null && curr.right != null) { // 要删除的节点是 有2个叶子节点

            // 找到右子树中最小的节点, 并考虑该节点还有子节点的情况
            // 删除右子树中 值最小的节点, 并获取到该节点的值
            int min = this.deleteMin(curr.right);
            // 替换目标节点中的内容
            curr.value = min;

        } else { // 要删除的节点是 有1个叶子节点
            if (curr.left != null) { // 有左子节点的情况
                if (value == parent.left.value) { // 要删除的节点是 父节点的 左子节点
                    parent.left = curr.left;
                } else { // 要删除的节点是 父节点的 右子节点
                    parent.right = curr.left;
                }
            } else { // 有右子节点的情况
                if (value == parent.left.value) {
                    parent.left = curr.right;
                } else {
                    parent.right = curr.right;
                }
            }
        }

    }

    /**
     * 删除一颗树中最小的节点
     *
     * @param node 右节点
     * @return
     */
    private int deleteMin(Node node) {
        Node min = node;
        // 找到最小的节点
        while (min.left != null) {
            min = min.left;
        }

        // 如果这个节点有子节点
        delete(min.value);
        return min.value;
    }

    /**
     * 查找父节点
     *
     * @param value 值
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) return null;
        if (root.value == value) return null;
        return root.searchParent(value);
    }
}
