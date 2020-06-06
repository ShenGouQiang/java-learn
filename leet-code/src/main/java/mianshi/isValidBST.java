package mianshi;

import org.junit.Test;

/**
 * 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author shengouqiang
 * @date 2020/5/12
 */
public class isValidBST {

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
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t2.left = t1;
        t2.right = t3;
        System.out.println(isValidBST(t2));
    }

    @Test
    public void testTwo() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t5.left = t1;
        t5.right = t4;
        t4.left = t3;
        t4.right = t6;

        System.out.println(isValidBST(t5));
    }

    @Test
    public void testTree(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t11 = new TreeNode(1);
        t1.right = t11;
        System.out.println(isValidBST(t1));
        t1.right = null;
        t1.left = t11;
        System.out.println(isValidBST(t1));
    }

    @Test
    public void testFour(){
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t10 = new TreeNode(10);
        TreeNode t15 = new TreeNode(15);
        TreeNode t20 = new TreeNode(20);
        t10.left = t5;
        t10.right=t15;
        t15.left = t6;
        t15.right = t20;
        System.out.println(isValidBST(t10));

        check(t10);
    }

    Integer lastNum = null;
    private boolean returnFlag = true;

    public boolean isValidBST(TreeNode root) {
        check(root);
        return returnFlag;
    }

    private void check(TreeNode root){
        if(!returnFlag){
            return;
        }
        if(root == null){
            return;
        }
        check(root.left);
        if(lastNum == null){
            lastNum = root.val;
        }else{
            if(returnFlag){
                returnFlag = root.val > lastNum ;
                lastNum = root.val;
            }
        }
        check(root.right);
    }

}
