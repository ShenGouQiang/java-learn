package leetcode.no200;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertEquals(1, numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(3, numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        int tempR = temp[0];
                        int tempC = temp[1];
                        if (tempR - 1 >= 0 && grid[tempR - 1][tempC] == '1') {
                            grid[tempR - 1][tempC] = '2';
                            queue.offer(new int[]{tempR - 1, tempC});
                        }
                        if (tempR + 1 < row && grid[tempR + 1][tempC] == '1') {
                            grid[tempR + 1][tempC] = '2';
                            queue.offer(new int[]{tempR + 1, tempC});
                        }
                        if (tempC - 1 >= 0 && grid[tempR][tempC - 1] == '1') {
                            grid[tempR][tempC - 1] = '2';
                            queue.offer(new int[]{tempR, tempC - 1});
                        }
                        if (tempC + 1 < col && grid[tempR][tempC + 1] == '1') {
                            grid[tempR][tempC + 1] = '2';
                            queue.offer(new int[]{tempR, tempC + 1});
                        }
                    }
                }
            }
        }
        return island;
    }
}
