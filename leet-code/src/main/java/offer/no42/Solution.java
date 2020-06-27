package offer.no42;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] array = new int[nums.length];
        array[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            array[i] = Math.max(array[i - 1], 0) + nums[i];
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
