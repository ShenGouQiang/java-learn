package leetcode.no53;

import org.junit.Test;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = sum + nums[i];
            if (temp < 0) {
                sum = nums[i];
                max = Math.max(nums[i], max);
            } else {
                sum = Math.max(temp, nums[i]);
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    @Test
    public void testOne() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void testTwo() {
        System.out.println(maxSubArray(new int[]{-1, -2}));
    }
}
