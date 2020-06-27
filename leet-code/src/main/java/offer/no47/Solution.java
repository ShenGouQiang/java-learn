package offer.no47;

import org.junit.Test;

public class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int[][] array = new int[grid.length][grid[0].length];
        array[0][0] = grid[0][0];
        for (int j = 1; j < array.length; j++) {
            array[0][j] = array[0][j - 1] + grid[0][j];
        }
        for (int j = 1; j < array[0].length; j++) {
            array[j][0] = array[j - 1][0] + grid[j][0];
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]) + grid[i][j];
            }
        }
        return array[grid.length - 1][grid[0].length - 1];
    }


    @Test
    public void testOne() {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(array));
    }

}
