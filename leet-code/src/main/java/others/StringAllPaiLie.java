package others;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全排列
 */
public class StringAllPaiLie {

    @Test
    public void testOne() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] bitArray = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        dfs(nums, 0, bitArray, new ArrayList<>(), result);
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(int[] nums, int dept, boolean[] bitArray, List<Integer> oneList, List<List<Integer>> result) {
        if (dept == nums.length) {
            result.add(new ArrayList<>(oneList));
            return;
        }
        for (int i = 0; i < bitArray.length; i++) {
            if (!bitArray[i]) {
                bitArray[i] = true;
                oneList.add(nums[i]);
                dfs(nums, dept + 1, bitArray, oneList, result);
                oneList.remove(oneList.size() - 1);
                bitArray[i] = false;
            }
        }
    }


    private void dfs1(int[] nums, int dept, boolean[] bitArray, List<Integer> oneList, List<List<Integer>> result) {
        if (dept == nums.length) {
            result.add(new ArrayList<>(oneList));
            return;
        }
        for (int i = 0; i < bitArray.length; i++) {
            if (bitArray[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !bitArray[i - 1]) {
                continue;
            }
            bitArray[i] = true;
            oneList.add(nums[i]);
            dfs1(nums, dept + 1, bitArray, oneList, result);
            oneList.remove(oneList.size() - 1);
            bitArray[i] = false;

        }
    }


}
