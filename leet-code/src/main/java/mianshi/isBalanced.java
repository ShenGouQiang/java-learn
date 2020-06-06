package mianshi;

/**
 * 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 *
 * @author shengouqiang
 * @date 2020/5/12
 */
public class isBalanced {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean returnFlag = true;
    public boolean isBalanced(TreeNode root) {
        treeHeightSub(root,0);
        return returnFlag;
    }


    private int treeHeightSub(TreeNode root,int dept){
        if(root == null){
            return dept;
        }
        if(!returnFlag){
            return 0;
        }
        int left = treeHeightSub(root.left,dept+1);
        int right = treeHeightSub(root.right,dept +1);
        if(Math.abs(left-right) >1){
            returnFlag =false;
        }
        return Math.max(left,right);
    }

}
