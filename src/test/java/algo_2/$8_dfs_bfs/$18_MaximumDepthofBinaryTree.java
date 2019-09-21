package algo_2.$8_dfs_bfs;

import algo_2.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树最大深度
 * 104
 * Created by Administrator on 2019/9/17.
 */
public class $18_MaximumDepthofBinaryTree {


    private TreeNode node3 = new TreeNode(3);


    @Before
    public void setUp() throws Exception {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        node15.right = node4;
    }


    @Test
    public void testMaximumDepthofBinaryTree() throws Exception {
        int result1 = maximumDepthofBinaryTreeRecursive(node3);
        Assert.assertEquals(4, result1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int result2 = maximumDepthofBinaryTreeBFS(node3);
        Assert.assertEquals(4, result2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int result3 = maximumDepthofBinaryTreeDFS(node3);
        Assert.assertEquals(4, result3);
    }


    /**
     * 最大深度 递归
     *
     * @param node 节点
     * @return
     */
    public int maximumDepthofBinaryTreeRecursive(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maximumDepthofBinaryTreeRecursive(node.left), maximumDepthofBinaryTreeRecursive(node.right));
    }


    private int maximumDepthofBinaryTreeBFS(TreeNode node) {
        if (node == null) return 0;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(node);
        int cnt = 0;


        while (!deque.isEmpty()) {
            int s = deque.size();
            for (int i = 0; i < s; i++) {
                TreeNode tmp = deque.poll();
                if (tmp.left != null) deque.add(tmp.left);
                if (tmp.right != null) deque.add(tmp.right);
            }
            cnt ++;
        }
        return cnt;
    }

    private int maximumDepthofBinaryTreeDFS(TreeNode node) {
        if (node == null) return 0;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();

        nodeStack.push(node);
        cntStack.push(1);
        int max = 0;

        while (!nodeStack.isEmpty()) {
            int size = nodeStack.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = nodeStack.pop();
                Integer tmpCnt = cntStack.pop();
                max = Math.max(tmpCnt, max);

                if (tmpNode.left != null) {
                    nodeStack.push(tmpNode.left);
                    cntStack.push(tmpCnt + 1);
                }
                if (tmpNode.right != null) {
                    nodeStack.push(tmpNode.right);
                    cntStack.push(tmpCnt + 1);
                }

            }
        }
        return max;
    }

}
