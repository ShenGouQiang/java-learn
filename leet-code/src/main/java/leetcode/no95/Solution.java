package leetcode.no95;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 通过回溯 + 自建 搜索二叉树 的方式，来创建订单
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        boolean[] flag = new boolean[n + 1];
        flag[0] = true;
        List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            flag[i] = true;
            root = new TreeNode(i);
            dsf(flag, n, 1, result);
            flag[i] = false;
        }
        return result;
    }

    TreeNode root = null;

    public void dsf(boolean[] flag, int n, int depth, List<TreeNode> result) {
        if (depth == n) {
            result.add(root);
            root = new TreeNode(root.val);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                flag[i] = true;
                buildBinarySearchTree(root, i);
                dsf(flag, n, depth + 1, result);
                flag[i] = false;
            }
        }
    }

    public void buildBinarySearchTree(TreeNode root, int val) {
        TreeNode temp = root;
        TreeNode parent = null;
        while (temp != null) {
            parent = temp;
            if (temp.val > val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (parent.val > val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
    }

    @Test
    public void testOne() {
        int[] array = new int[]{3, 1, 2};
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            buildBinarySearchTree(root, array[i]);
        }
        System.out.println(root);
    }


    private List<Integer> printTreeNode(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                result.add(null);
            }else{
                result.add(temp.val);
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return result;
    }

    @Test
    public void testThree(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        System.out.println(queue.size());
    }

    @Test
    public void testTwo() {
        List<TreeNode> result = generateTrees(4);
        result.forEach(treeNode -> {
            System.out.println(printTreeNode(treeNode));
        });
    }
}
