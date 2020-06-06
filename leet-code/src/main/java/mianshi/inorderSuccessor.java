package mianshi;

import lombok.Data;
import org.junit.Test;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 *
 * @author shengouqiang
 * @date 2020/5/13
 */
public class inorderSuccessor {

    @Data
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void testOne() {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p2.left = p1;
        p2.right = p3;
        TreeNode result = inorderSuccessor(p2, new TreeNode(1));
        System.out.println(result == null ? null : result.val);
    }

    @Test
    public void testTwo() {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        p5.left = p3;
        p5.right = p6;
        p3.left = p2;
        p3.right = p4;
        p2.left = p1;
        TreeNode result = inorderSuccessor(p5, new TreeNode(6));
        System.out.println(result == null ? null : result.val);
    }

    private TreeNode returnNode = null;
    private boolean continueFlag = true;
    private Integer prevVal = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        printCenter(root, p);
        return returnNode;
    }

    private void printCenter(TreeNode root, TreeNode p) {
        if (!continueFlag) {
            return;
        }
        if (root == null) {
            return;
        }
        printCenter(root.left, p);
        if (null == returnNode && null != prevVal) {
            returnNode = root;
            continueFlag = false;
        }
        if (null == prevVal && root.val == p.val) {
            prevVal = p.val;
        }

        printCenter(root.right, p);
    }
}
