package offer.no21;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {

    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int jIndex = 0;
        int oIndex = nums.length - 1;
        for (int i = 0; i < result.length; i++) {
            if (nums[i] % 2 == 0) {
                result[oIndex--] = nums[i];
            } else {
                result[jIndex++] = nums[i];
            }
        }
        return result;
    }

    public int[] exchange1(int[] nums) {
        int lIndex = 0;
        int rIndex = nums.length - 1;
        while (lIndex < rIndex) {
            if (nums[lIndex] % 2 == 0 && nums[rIndex] % 2 != 0) {
                swap(nums, lIndex, rIndex);
                lIndex++;
                rIndex--;
            } else if (nums[lIndex] % 2 != 0 && nums[rIndex] % 2 == 0) {
                lIndex++;
                rIndex--;
            } else if (nums[lIndex] % 2 == 0 && nums[rIndex] % 2 == 0) {
                rIndex--;
            } else if (nums[lIndex] % 2 != 0 && nums[rIndex] % 2 != 0) {
                lIndex++;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
