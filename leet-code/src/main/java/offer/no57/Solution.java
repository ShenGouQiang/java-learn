package offer.no57;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shengouqiang
 * @date 2020/6/28
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(target - i)) {
                result[0] = i;
                result[1] = target - i;
                return result;
            }
            set.add(i);
        }
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{nums[start], nums[end]};
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[2];
    }

    /**
     * 采用 回溯的思想，来解决这个问题
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int[] array = new int[target];
        for (int i = 0; i < target; i++) {
            array[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        int maxSingleListSize = 0;
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                temp.add(array[j]);
                if (sum == target) {
                    flag = true;
                    maxSingleListSize = Math.max(maxSingleListSize, temp.size());
                    break;
                } else if (sum > target) {
                    break;
                }
            }
            if (flag && temp.size() >= 2) {
                result.add(temp);
            }
        }
        List<int[]> resultArray = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int[] temp = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++) {
                temp[j] = result.get(i).get(j);
            }
            resultArray.add(temp);
        }
        return resultArray.toArray(new int[result.size()][]);
    }

    @Test
    public void testThree() {
        System.out.println(findContinuousSequence(9));
    }

    @Test
    public void testFour() {
        System.out.println(findContinuousSequence(15));
    }


}
