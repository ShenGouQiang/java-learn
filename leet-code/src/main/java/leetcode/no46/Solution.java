package leetcode.no46;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 通过次数137,111提交次数180,005
 *
 * @author shengouqiang
 * @date 2020/6/10
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] bitArray = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        dfs(nums, 0, new ArrayList<>(), result, bitArray);
        return result;
    }

    public void dfs(int[] nums, int depth, List<Integer> oneList, List<List<Integer>> resultList, boolean[] flag) {
        if (depth == nums.length) {
            resultList.addAll(new ArrayList(oneList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                oneList.add(nums[i]);
                dfs(nums, depth + 1, oneList, resultList, flag);
                oneList.remove(oneList.size() - 1);
                flag[i] = false;
            }
        }
    }
}
