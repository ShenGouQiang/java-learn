package offer.no54;

/**
 * @author shengouqiang
 * @date 2020/6/28
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

    int index = 0;
    int val = 0;

    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return val;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null || index >= k) {
            return;
        }
        dfs(root.right, k);
        index++;
        if (index == k) {
            val = root.val;
            return;
        }
        dfs(root.left, k);
    }
}
