package algo_2.$5_tree;

import algo_2.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2019/9/14.
 */
public class $15_LowestCommonAncessorOfBinaryTree {
    /*
      思路:
      递归去找 p或者q, 找到就返回根节点, 注意一定是根节点, 用于递归回去后的比较
     */

    TreeNode node6 = new TreeNode(6);

    @Before
    public void setUp() throws Exception {

        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);


        node6.left = node2;
        node6.right = node8;

        node2.left = node0;
        node2.right = node4;

        node4.left = node3;
        node4.right = node5;

        node8.left = node7;
        node8.right = node9;


    }

    @Test
    public void testLowestCommonAncessorOfBinaryTree() throws Exception {
        TreeNode treeNode = lowestCommonAncessorOfBinaryTree(node6, 5, 9);
        Assert.assertEquals(6, treeNode.val);
    }

    public TreeNode lowestCommonAncessorOfBinaryTree(TreeNode node, int p, int q) {
        if (node == null || node.val == p || node.val == q) return node;
        TreeNode left = lowestCommonAncessorOfBinaryTree(node.left, p, q);
        TreeNode right = lowestCommonAncessorOfBinaryTree(node.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }

    }

}
