package offer.no63;

import org.junit.Test;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] array = new int[prices.length];
        array[0] = 0;
        int minBuyrice = prices[0];
        int maxVal = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuyrice = Math.min(minBuyrice, prices[i]);
            maxVal = Math.max(prices[i] - minBuyrice, maxVal);
            array[i] = maxVal;
        }
        return maxVal;
    }

    @Test
    public void testOne() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
