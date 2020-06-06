package leetcode.no4;


import java.util.Objects;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法参考
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * @author shengouqiang
 * @date 2020/4/2
 */
public class FindMedian {

    public static void main(String[] args) {
        int[] nums1 = {1,6,9,11,15};
        int[] nums2 = {3,7,9,11};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    /**
     * 解法三
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean nums1Check = Objects.isNull(nums1) || 0 == nums1.length;
        boolean nums2Check = Objects.isNull(nums2) || 0 == nums2.length;
        if(nums1Check && nums2Check){
            return 0D;
        }
        if(nums1Check){
            return getOneArrayMedia(nums2);
        }
        if(nums2Check){
            return getOneArrayMedia(nums1);
        }
        int c1= nums1.length;
        int c2 = nums2.length;
       // int medIndex = (c1 + c2) % 2 == 0 ?
        return 0D;
    }

    public static double getOneArrayMedia(int[] array){
        if(array.length %2 == 0){
            return (array[array.length/2] + array[array.length/2+1]) * 0.5;
        }
        return array[array.length /2];
    }
}
