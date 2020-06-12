package leetcode.no55;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 通过次数117,665提交次数293,598
 *
 * @author shengouqiang
 * @date 2020/6/12
 */
public class Solution {

    public void testOne(){

    }


    public boolean canJump(int[] nums) {
        help(0, nums, nums.length);
        return flag;
    }

    boolean flag = false;
    public void help(int startIndex, int[] nums, int length) {
        if (flag) {
            return;
        }
        if (startIndex + nums[startIndex] >= length) {
            flag = true;
        }
        for (int i = startIndex; i < startIndex + nums[startIndex]; i++) {
            help(i, nums, length);
        }
    }
}
