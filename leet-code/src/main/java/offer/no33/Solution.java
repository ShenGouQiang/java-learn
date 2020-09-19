package offer.no33;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return dfs(postorder, 0, postorder.length - 1);
    }

    public boolean dfs(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = postorder[end];
        int index = -1;
        for (int i = start; i <= end - 1; i++) {
            if (postorder[i] > rootVal) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i <=end - 1; i++) {
                if (postorder[i] < rootVal) {
                    return false;
                }
            }
        }
        if (-1 != index) {
            return dfs(postorder, start, index - 1) && dfs(postorder, index, end - 1);
        } else {
            return dfs(postorder, start, end - 1);
        }
    }

    @Test
    public void testOne() {
        Assert.assertFalse(verifyPostorder(new int[]{1, 6, 3, 2, 5}));
    }

    @Test
    public void testTwo() {
        Assert.assertTrue(verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    @Test
    public void testThree() {
        Assert.assertTrue(verifyPostorder(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testFour() {
        Assert.assertFalse(verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }
}
