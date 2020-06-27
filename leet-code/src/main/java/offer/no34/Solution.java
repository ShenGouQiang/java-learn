package offer.no34;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        TreeNode p5 = new TreeNode(5);
        TreeNode p4 = new TreeNode(4);
        TreeNode p8 = new TreeNode(8);
        TreeNode p11 = new TreeNode(11);
        TreeNode p13 = new TreeNode(13);
        TreeNode p44 = new TreeNode(4);
        TreeNode p7 = new TreeNode(7);
        TreeNode p2 = new TreeNode(2);
        TreeNode p55 = new TreeNode(5);
        TreeNode p1 = new TreeNode(1);
        p5.left = p4;
        p5.right = p8;
        p4.left = p11;
        p8.left = p13;
        p8.right = p44;
        p11.left = p7;
        p11.right = p2;
        p44.left = p55;
        p44.right = p1;
        System.out.println(pathSum(p5, 22));
    }

    @Test
    public void testTwo(){
        TreeNode pF2 = new TreeNode(-2);
        TreeNode pF3 = new TreeNode(-3);
        pF2.right=pF3;
        System.out.println(pathSum(pF2,-5));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> oneList = new ArrayList<>();
        dfs(result, oneList, root, sum, 0, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> oneList, TreeNode root, int sum, int calSum, int depth) {
        if (root == null) {
            return;
        }
        calSum += root.val;
        if (calSum == sum && (root.left == null && root.right == null)) {
            oneList.add(root.val);
            result.add(new ArrayList<>(oneList));
            oneList.remove(oneList.size() - 1);
            return;
        }
        oneList.add(root.val);
        dfs(result, oneList, root.left, sum, calSum, depth + 1);
        dfs(result, oneList, root.right, sum, calSum, depth + 1);
        oneList.remove(oneList.size() - 1);
    }
}
