package leetcode.no35;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

    @Test
    public void testFour() {
        Assert.assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int med = start + ((end - start) >>> 1);
            if (nums[med] == target) {
                return med;
            } else if (nums[med] > target) {
                end = med - 1;
            } else {
                start = med + 1;
            }
        }
        if (nums[start] >= target) {
            return start;
        } else {
            return start + 1;
        }
    }
}
