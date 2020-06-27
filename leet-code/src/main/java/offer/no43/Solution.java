package offer.no43;

import org.junit.Test;

public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                int yuNum = temp % 10;
                if (yuNum == 1) {
                    count++;
                }
                temp = temp / 10;
            }
        }
        return count;
    }

    @Test
    public void testOne() {
        System.out.println(countDigitOne(12));
    }
}
