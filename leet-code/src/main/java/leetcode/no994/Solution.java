package leetcode.no994;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    @Test
    public void testOne() {
        Assert.assertEquals(4, orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(2, orangesRotting(new int[][]{{2}, {1}, {1}, {1}, {2}, {1}, {1}}));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(-1, orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }

    @Test
    public void testFour() {
        Assert.assertEquals(0, orangesRotting(new int[][]{{0}}));
    }


    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int healtyOrangesCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    healtyOrangesCount++;
                }
            }
        }
        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int tempR = temp[0];
                int tempC = temp[1];
                if (tempR - 1 >= 0 && grid[tempR - 1][tempC] == 1) {
                    grid[tempR - 1][tempC] = 2;
                    healtyOrangesCount--;
                    queue.offer(new int[]{tempR - 1, tempC});
                }
                if (tempR + 1 < row && grid[tempR + 1][tempC] == 1) {
                    grid[tempR + 1][tempC] = 2;
                    healtyOrangesCount--;
                    queue.offer(new int[]{tempR + 1, tempC});
                }
                if (tempC - 1 >= 0 && grid[tempR][tempC - 1] == 1) {
                    grid[tempR][tempC - 1] = 2;
                    healtyOrangesCount--;
                    queue.offer(new int[]{tempR, tempC - 1});
                }
                if (tempC + 1 < col && grid[tempR][tempC + 1] == 1) {
                    grid[tempR][tempC + 1] = 2;
                    healtyOrangesCount--;
                    queue.offer(new int[]{tempR, tempC + 1});
                }
            }
        }
        return healtyOrangesCount > 0 ? -1 : minutes == -1 ? 0 : minutes;
    }
}
