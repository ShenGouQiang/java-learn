package offer.no53;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/28
 */
public class Solution {

    public int missingNumber(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > index) {
                return index;
            } else {
                index++;
            }
        }
        return index;
    }

    @Test
    public void testOne() {
        Assert.assertEquals(missingNumber(new int[]{0, 1, 3}), 2);
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}), 8);
    }


    public int search(int[] nums, int target) {
        int targetIndex = targetIndex(nums, target);
        if (targetIndex == -1) {
            return 0;
        }
        int count = 1;
        int leftIndex = targetIndex - 1;
        while (leftIndex >= 0 && nums[leftIndex--] == target) {
            count++;
        }
        int rightIndex = targetIndex + 1;
        while (rightIndex < nums.length && nums[rightIndex++] == target) {
            count++;
        }
        return count;
    }

    public int targetIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int med = (start + end) >>> 1;
            if (nums[med] == target) {
                return med;
            } else if (nums[med] > target) {
                end = med - 1;
            } else {
                start = med + 1;
            }
        }
        return -1;
    }

    @Test
    public void testThree() {
        Assert.assertEquals(2, search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    @Test
    public void testFour() {
        Assert.assertEquals(0, search(new int[]{5,7,7,8,8,10}, 6));
    }
}
