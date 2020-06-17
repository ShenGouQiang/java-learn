package leetcode.no33;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 通过次数131,906提交次数346,457
 *
 *
 * @author shengouqiang
 * @date 2020/6/17
 */
public class Solution {


    /**
     * 自己的解题思路
     *  1.首先根据二分查找，找到数组中的最大值
     *  2.以最大值为基点，将数组分成两个单调增的区分
     *  3.在每个单调增的区间，在进行二分查找
     *  4.获取最终的返回值
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return -1;
    }

    private int findMaxValueIndexByBinarySearch(int[] array){
        int left = 0;
        int right = array.length -1;
        int med = (left +right) /2;
        while (left < right){

        }
    }
}
