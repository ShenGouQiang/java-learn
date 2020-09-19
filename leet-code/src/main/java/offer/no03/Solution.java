package offer.no03;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
