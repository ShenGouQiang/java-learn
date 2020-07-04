package leetcode.no121;

import org.junit.Test;

public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int temp : prices) {
            if (temp < min) {
                min = temp;
            } else {
                if (max < temp - min) {
                    max = temp - min;
                }
            }
        }
        return max;
    }

    @Test
    public void testOne(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
