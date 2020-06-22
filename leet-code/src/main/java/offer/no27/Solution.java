package offer.no27;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengouqiang
 * @date 2020/6/22
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


    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root) {
        dfs1(root);
        dfs2(root);
        return root;
    }

    List<Integer> list = new ArrayList<>();
    int index=0;
    public void dfs1(TreeNode root){
        if(root == null ){
            return;
        }
        dfs1(root.right);
        list.add(root.val);
        dfs1(root.left);
    }

    public void dfs2(TreeNode root){
        if(root == null){
            return;
        }
        dfs2(root.left);
        root.val=list.get(index++);
        dfs2(root.right);
    }

}
