package algo_2.$8_dfs_bfs;

import algo_2.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 广度搜索遍历 二叉树
 * 102
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class $17_BinaryTreeLevelOrderTraversal {


    private TreeNode node3 = new TreeNode(3);


    @Before
    public void setUp() throws Exception {
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
    }

    @Test
    public void testBinaryTreeLevelOrderTraversal() {
        List<List<Integer>> lists1 = levelOrderUseBFS(node3);
        Assert.assertEquals("[[3], [9, 20], [15, 7]]", lists1.toString());

        List<List<Integer>> lists2 = levelOrderUseDFS(node3);
        Assert.assertEquals("[[3], [9, 20], [15, 7]]", lists2.toString());
    }


    public List<List<Integer>> levelOrderUseBFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        /*
        如果是图 需要记录那些已经访问, 不能重复记录
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        */

        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll(); // 出队列
                if (node != null) {
                    curr.add(node.val);
                    if (node.left != null) deque.add(node.left); // 进队列
                    if (node.right != null) deque.add(node.right); // 进队列
                }
            }
            result.add(curr);
        }

        return result;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> levelOrderUseDFS(TreeNode root) {
        if (root == null) return new ArrayList<>();
        levelOrderUseDFS(root, 0);
        return r;
    }

    public void levelOrderUseDFS(TreeNode node, int level) {
        if (node == null) return;

        // 如果当前层级不存在, 创建层级, 也就是里面的List
        if (r.size() < level + 1) {
            r.add(new ArrayList<>());
        }

        // 获取当前层级, 并添加元素
        r.get(level).add(node.val);

        levelOrderUseDFS(node.left, level + 1);
        levelOrderUseDFS(node.right, level + 1);

    }
}
