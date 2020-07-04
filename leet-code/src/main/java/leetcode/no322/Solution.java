package leetcode.no322;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] result = new int[amount + 1];
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && result[i - coins[j]] < min) {
                    if (result[i - coins[j]] == -1) {
                        continue;
                    }
                    min = result[i - coins[j]] == 0 ? 1 : result[i - coins[j]] + 1;
                }
            }
            result[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return result[result.length - 1];
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, coinChange(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(-1, coinChange(new int[]{2}, 3));
        Assert.assertEquals(20, coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

}
