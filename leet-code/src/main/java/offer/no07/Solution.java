package offer.no07;

import org.junit.Test;
import sun.misc.LRUCache;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
         if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootVal = preorder[0];
        int iIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            iIndex++;
        }
        TreeNode root = new TreeNode(preorder[0]);
        root.left = dfs(preorder,1,iIndex,inorder,0,iIndex-1);
        root.right= dfs(preorder,iIndex +1,preorder.length-1,inorder,iIndex+1,inorder.length-1);
        return  root;
    }

    public TreeNode dfs(int[] preorder,int pStart,int pEnd,int[]inorder,int iStart,int iEnd){
        if(pStart>=preorder.length || pStart > pEnd){
            return null;
        }
        int rootVal =preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        if(pEnd== pStart){
            return root;
        }
        int iIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
            iIndex++;
        }
        root.left = dfs(preorder,pStart+1,pStart +iIndex ,inorder,iStart,iStart+iIndex-1);
        root.right = dfs(preorder,pStart +iIndex+1,pEnd,inorder,iStart+iIndex+1,iEnd);
        return root;
    }

    @Test
    public void testOne(){
        int[] perorder = {1,2,4,5,3,6,7};
        int[] inorder ={4,2,5,1,6,3,7};
        TreeNode p = buildTree(perorder,inorder);
        System.out.println(p);
    }

    @Test
    public void testTwo(){
        int[] perorder = {1,2,3,4};
        int[] inorder ={1,2,3,4};
        TreeNode p = buildTree(perorder,inorder);
        System.out.println(p);
    }

}
