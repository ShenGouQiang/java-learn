package leetcode.no98;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 通过次数126,784提交次数404,305
 *
 * @author shengouqiang
 * @date 2020/6/9
 */
public class Solution {

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
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        System.out.println(isValidBST(n2));
    }

    @Test
    public void testTwo() {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        n5.left = n1;
        n5.right = n4;
        n4.left = n3;
        n4.right = n6;
        System.out.println(isValidBST(n5));
    }

    public boolean isValidBST(TreeNode root) {
        help1(root);
        return flag;
    }

    private List<Integer> arrayList = new ArrayList<>();




    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        System.out.println(root.val);
        arrayList.add(root.val);
        help(root.right);
    }

    private  TreeNode prev;
    private boolean flag= true;
    public void help1(TreeNode root) {
        if (root == null || !flag) {
            return;
        }
        help1(root.left);
        if(prev != null && prev.val >= root.val){
            flag= false;
            return;
        }
        prev= root;
        help1(root.right);
    }

    /**
     * 采用迭代的方式
     * @param root
     */
    public void help2(TreeNode root){

    }


}
