package leetcode.no309;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertEquals(3, maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(0, maxProfit(new int[]{1}));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(0, maxProfit(new int[]{2, 1}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]), 0);
    }
}
