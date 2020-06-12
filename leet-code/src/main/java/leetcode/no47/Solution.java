package leetcode.no47;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * 通过次数62,883提交次数106,665
 *
 * @author shengouqiang
 * @date 2020/6/10
 */
public class Solution {


    @Test
    public void testOne() {
        int[] array = new int[]{3, 3, 0, 3};
        System.out.println(permuteUnique(array));
    }

    @Test
    public void testTwo(){
        int[] array = new int[]{3, 3, 0, 3};
        sorted(array);
        System.out.println(Arrays.asList(array));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] array = new boolean[nums.length];
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();
        sorted(nums);
        dfs(array, 0, nums, oneList, resultList);
        return resultList;
    }

    private void sorted(int[] array){
        for (int i=0;i<array.length -1;i++){
            for (int j =i;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i]= array[j];
                    array[j]= temp;
                }
            }
        }
    }


    private void dfs(boolean[] array, int dept, int[] nums, List<Integer> oneList, List<List<Integer>> result) {
        if (dept == nums.length) {
            result.add(new ArrayList(oneList));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && array[i - 1]) {
                continue;
            }
            array[i] = true;
            oneList.add(nums[i]);
            dfs(array, dept + 1, nums, oneList, result);
            oneList.remove(oneList.size() - 1);
            array[i] = false;
        }
    }
}
