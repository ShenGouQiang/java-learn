package leetcode.no198;

import org.junit.Test;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author shengouqiang
 * @date 2020/5/29
 */
public class Solution {

    @Test
    public void testOne() {
        System.out.println(rob(new int[]{1, 2, 3, 1}) == 4);
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}) == 12);
        System.out.println(rob(new int[]{1, 2}) == 2);
        System.out.println(rob(new int[]{1, 2, 3}) == 4);
        System.out.println(rob(new int[]{1, 3, 1}) == 3);
    }


    @Test
    public void testTwo() {
        System.out.println(version2(new int[]{1, 2, 3, 1}) == 4);
        System.out.println(version2(new int[]{2, 7, 9, 3, 1}) == 12);
        System.out.println(version2(new int[]{1, 2}) == 2);
        System.out.println(version2(new int[]{1, 2, 3}) == 4);
        System.out.println(version2(new int[]{1, 3, 1}) == 3);
    }

    @Test
    public void testThree() {
        System.out.println(version2(new int[]{2,1,1,2}) == 4);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        boolean[] bitArray = new boolean[nums.length];
        return dfs(nums, bitArray, 0, 0, 0);
    }

    public int dfs(int[] nums, boolean[] bitArray, int max, int count, int step) {
        if (step >= bitArray.length) {
            return Math.max(max, count);
        }
        for (int i = step; i < nums.length; i++) {
            bitArray[i] = true;
            count += nums[i];
            max = dfs(nums, bitArray, max, count, i + 2);
            count -= nums[i];
            bitArray[i] = false;
        }
        return max;
    }


    public int version2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = nums[1];
        int maxVal = Math.max(result[0], result[1]);
        int temp = 0;
        for (int i = 2; i < nums.length; i++) {
            temp = Math.max(temp, result[i - 2]);
            result[i] = temp + nums[i];
            maxVal = Math.max(maxVal, result[i]);
        }
        return maxVal;
    }

}
