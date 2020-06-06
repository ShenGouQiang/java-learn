package mianshi;

import org.junit.Test;

/**
 * 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author shengouqiang
 * @date 2020/5/12
 */
public class sortedArrayToBST {

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
        int[] array = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(array);
        print(root);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return arrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode arrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBST(nums, start, mid - 1);
        root.right = arrayToBST(nums, mid + 1, end);
        return root;
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
}
