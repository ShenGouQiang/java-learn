package plugins.leetcode.editor.cn;
//[15]三数之和
// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import org.junit.Test;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class threeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> numsSet = new HashMap<>();
        quickSort(nums,0,nums.length -1);
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = nums.length-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return result;
    }


    public static void quickSort(int[] nums,int left,int right){
        if(nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int medIndex = medIndex(nums,left,right);
        quickSort(nums,left,medIndex -1);
        quickSort(nums,medIndex + 1 ,right);
    }

    public static int medIndex(int[] nums,int left,int right){
        int k = nums[left];
        boolean reverseScan = true;
        while (left < right){
            if(reverseScan){
                while (right > left){
                    if(nums[right] >=k){
                        right--;
                        continue;
                    }
                    nums[left] = nums[right];
                    reverseScan = false;
                    break;
                }
            }else{
                while (right > left){
                    if(nums[left]<=k){
                        left++;
                        continue;
                    }
                    nums[right] = nums[left];
                    reverseScan = true;
                    break;
                }
            }
        }
        nums[left] = k;
        return left;
    }

    @Test
    public void testOne(){
        int[] array = new int[]{4,1,7,6,9,2,8,0,3,5};
        quickSort(array,0,array.length -1);
        print(array);
    }

    @Test
    public void testTwo(){
        int[] array = new int[]{4,2,3,1};
        medIndex(array,0,array.length -1);
        print(array);
    }

    @Test
    public void testThree(){
        int[] array = new int[]{1,4,3,2,6,5};
        medIndex(array,0,array.length -1);
        print(array);
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        quickSort(array,0,array.length -1);
        print(array);
        System.out.println(threeSum(array));;
    }



    private static void print(int[] array){
        for (int i =0;i<array.length;i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
