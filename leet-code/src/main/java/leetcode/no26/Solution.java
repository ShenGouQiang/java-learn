package leetcode.no26;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void testOne() {
        TreeNode t110 = new TreeNode(10);
        TreeNode t112 = new TreeNode(12);
        TreeNode t18 = new TreeNode(8);
        TreeNode t13 = new TreeNode(3);
        TreeNode t16 = new TreeNode(6);
        TreeNode t111 = new TreeNode(11);
        t110.left = t112;
        t110.right = t16;
        t112.left = t18;
        t112.right = t13;
        t16.left = t111;

        TreeNode t210 = new TreeNode(10);
        TreeNode t212 = new TreeNode(12);
        TreeNode t28 = new TreeNode(8);
        TreeNode t26 = new TreeNode(6);
        t210.left = t212;
        t210.right = t26;
        t212.left = t28;


        System.out.println(isSubStructure(t110, t210));
    }


    int index = 0;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        dsf(B, list);
        System.out.println(list);
        dsf1(A, list);
        return index == list.size() - 1 ? true : false;
    }

    private void dsf1(TreeNode root, List<Integer> list) {
        if (root == null || index == list.size() -1) {
            return;
        }
        if (root.val == list.get(index)) {
            index++;
        } else if (index > 0) {
            return;
        }
        dsf1(root.left, list);
        dsf1(root.right, list);
    }


    private void dsf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dsf(root.left, list);
        dsf(root.right, list);
    }
}
