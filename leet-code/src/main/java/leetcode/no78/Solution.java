package leetcode.no78;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengouqiang
 * @date 2020/6/2
 */
public class Solution {

    @Test
    public void testOne() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    @Test
    public void testTwo(){
        System.out.println(1-0.9);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int count = 1 << nums.length;
        for (int i = 0; i < count; i++) {
            int curNo = i;
            List<Integer> tmp = new ArrayList<>();
            int index = 0;
            while (curNo != 0) {
                if ((curNo & 1) == 1) {
                    tmp.add(nums[index]);
                }
                curNo = curNo >>> 1;
                index++;
            }
            result.add(tmp);
        }
        return result;
    }
}
