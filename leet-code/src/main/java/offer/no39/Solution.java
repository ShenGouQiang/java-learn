package offer.no39;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int thresold = nums.length / 2 + 1;
        for (int i : nums) {
            Integer count = map.get(i);
            if (count != null && count + 1 >= thresold) {
                return i;
            } else if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }
        return -1;
    }

    @Test
    public void testOne() {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
