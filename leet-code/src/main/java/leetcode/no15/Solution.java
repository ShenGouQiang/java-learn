package leetcode.no15;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shengouqiang
 * @date 2020/6/12
 */
public class Solution {

    @Test
    public void testOne() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        bubbleSort(nums);
        show(nums);
    }

    @Test
    public void testTwo() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    private void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }


    public List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                if (nums[i] + nums[m] + nums[n] < 0) {
                    while (m < n && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    m++;
                } else if (nums[i] + nums[m] + nums[n] == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    while (m < n && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    m++;
                    while (m < n && nums[n] == nums[n - 1]) {
                        n--;
                    }
                    n--;
                } else {
                    while (m < n && nums[n] == nums[n - 1]) {
                        n--;
                    }
                    n--;
                }
            }
        }
        return resultList;
    }

    private void sort(int[] nums) {
        bubbleSort(nums);
    }

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
