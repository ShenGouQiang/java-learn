package leetcode.no64;

import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/10
 */
public class Solution {

    @Test
    public void testOne() {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = 0;
                if (i == 0 && j == 0) {
                    min = 0;
                } else if (i == 0) {
                    min = grid[i][j - 1];
                } else if (j == 0) {
                    min = grid[i - 1][j];
                } else {
                    min = Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
                grid[i][j] = grid[i][j] + min;
            }
        }
        return grid[m - 1][n - 1];
    }
}
