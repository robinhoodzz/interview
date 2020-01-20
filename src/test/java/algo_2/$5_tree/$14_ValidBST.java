package algo_2.$5_tree;

import algo_2.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 判断是否是二叉搜索树
 * 98
 * Created by Administrator on 2019/9/14.
 */
public class $14_ValidBST {
    /*
    思路:
    1. 递归
    2. 中序遍历, 然后再和排序后的树比较
     */

    TreeNode treeNode1 = null;
    TreeNode treeNode2 = null;
    TreeNode treeNode3 = null;
    TreeNode treeNode4 = null;

    @Before
    public void setUp() throws Exception {
        treeNode1 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(3);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode2 = new TreeNode(5);
        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(4);
        TreeNode treeNode23 = new TreeNode(3);
        TreeNode treeNode24 = new TreeNode(6);
        treeNode2.left = treeNode21;
        treeNode2.right = treeNode22;
        treeNode22.left = treeNode23;
        treeNode22.right = treeNode24;


        treeNode3 = new TreeNode(3);
        TreeNode treeNode31 = new TreeNode(1);
        TreeNode treeNode32 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(5);
        treeNode3.left = treeNode31;
        treeNode3.right = treeNode33;
        treeNode31.right = treeNode32;

    }

    @Test
    public void testIsValidBST() throws Exception {
        Assert.assertTrue(isValidBST(treeNode1));
        Assert.assertFalse(isValidBST(treeNode2));
        Assert.assertTrue(isValidBST(treeNode3));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Assert.assertTrue(isValidBSTInOrder(treeNode1));
        Assert.assertFalse(isValidBSTInOrder(treeNode2));
        Assert.assertTrue(isValidBSTInOrder(treeNode3));
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }


    /**
     * 中序遍历, 对比数组
     *
     * @param root
     * @return
     */
    public boolean isValidBSTInOrder(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);

        List<Integer> tmp = Arrays.asList(inOrder.toArray(new Integer[inOrder.size()]));
        tmp.sort(Integer::compareTo);
        return inOrder.equals(tmp);
    }

    private void inOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

    public void mid(TreeNode root) {
        if (root == null) return;
        mid(root.left);
        System.out.println(root.val);
        mid(root.right);
    }
}
