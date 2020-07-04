package leetcode.no718;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertEquals(3, findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(4, findLength(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0}));
    }

    public int findLength(int[] A, int[] B) {
        int[][] array = new int[A.length][B.length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] != B[j]) {
                    array[i][j] = 0;
                } else {
                    if (i - 1 < 0 || j - 1 < 0) {
                        array[i][j] = 1;
                    } else {
                        array[i][j] = array[i - 1][j - 1] + 1;
                    }
                }
                max = Math.max(max, array[i][j]);
            }
        }
        return max;
    }


}
