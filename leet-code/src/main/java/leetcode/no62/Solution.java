package leetcode.no62;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testThree() {
        Assert.assertEquals(2, uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        result[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int tempA = i - 1 < 0 || obstacleGrid[i - 1][j] == 1 ? 0 : result[i - 1][j];
                int tempB = j - 1 < 0 || obstacleGrid[i][j - 1] == 1 ? 0 : result[i][j - 1];
                result[i][j] = tempA + tempB;
            }
        }
        return result[m - 1][n - 1];
    }


    public int version2(int m, int n) {
        int[][] result = new int[m][n];
        result[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int tempA = i - 1 < 0 ? 0 : result[i - 1][j];
                int tempB = j - 1 < 0 ? 0 : result[i][j - 1];
                result[i][j] = tempA + tempB;
            }
        }
        return result[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        if (m == 1) {
            return dfs(0, 0 + 1, m, n);
        }
        if (n == 1) {
            return dfs(0 + 1, 0, m, n);
        }
        return dfs(0 + 1, 0, m, n) + dfs(0, 0 + 1, m, n);
    }

    public int dfs(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (row == m - 1) {
            return dfs(row, col + 1, m, n);
        } else if (col == n - 1) {
            return dfs(row + 1, col, m, n);
        } else {
            return dfs(row + 1, col, m, n) + dfs(row, col + 1, m, n);
        }
    }

    @Test
    public void testOne() {
        Assert.assertEquals(uniquePaths(1, 1), 1);
        Assert.assertEquals(uniquePaths(3, 2), 3);
        Assert.assertEquals(uniquePaths(7, 3), 28);
        Assert.assertEquals(uniquePaths(1, 2), 1);
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(version2(1, 1), 1);
        Assert.assertEquals(version2(3, 2), 3);
        Assert.assertEquals(version2(7, 3), 28);
        Assert.assertEquals(version2(1, 2), 1);
    }
}
