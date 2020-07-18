package leetcode.no33;

import org.junit.Assert;
import org.junit.Test;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 通过次数131,906提交次数346,457
 *
 * @author shengouqiang
 * @date 2020/6/17
 */
public class Solution {


    @Test
    public void testOne() {
        Assert.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(1, search(new int[]{8,9,2,3,4}, 9));
    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int length = nums.length;
        if (nums[0] < nums[length - 1]) {
            return findValue(nums, 0, length - 1, target);
        } else {
            int maxValueIndex = findMaxIndex(nums, 0, length - 1);
            int tempA = findValue(nums, 0, maxValueIndex, target);
            int tempB = findValue(nums, maxValueIndex + 1, length - 1, target);
            if (tempA == -1 && tempB == -1) {
                return -1;
            }
            return tempA == -1 ? tempB : tempA;
        }

    }

    public int findMaxIndex(int[] nums, int start, int end) {
        int maxValueIndex = start;
        while (start <= end) {
            int med = start + ((end - start) >>> 1);
            if (nums[med] < nums[maxValueIndex]) {
                end = med - 1;
            } else {
                start = med + 1;
                maxValueIndex = med;
            }
        }
        return maxValueIndex;
    }

    public int findValue(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int med = start + ((end - start) >>> 1);
            if (nums[med] == target) {
                return med;
            }
            if (nums[med] < target) {
                start = med + 1;
            } else {
                end = med - 1;
            }
        }
        return -1;
    }
}
