package offer.no174;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertEquals(7, calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(1, calculateMinimumHP(new int[][]{{0, 5}, {-2, -3}}));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(1, calculateMinimumHP(new int[][]{{2}, {1}}));
    }

    private void printArray(int[][] array) {
        System.out.println("----------------start-------------------");
        int row = array.length;
        int col = array[0].length;
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (index > 0 && index % col == 0) {
                    System.out.println();
                }
                System.out.print(array[i][j] + "\t");
                index++;
            }
        }
        System.out.println();
        System.out.println("----------------end-------------------");
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length < 1) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] array = new int[row][col];
        array[row - 1][col - 1] = 1 - dungeon[row - 1][col - 1] > 0 ? 1 - dungeon[row - 1][col - 1] : 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    continue;
                }
                int a = 1, b = 1;
                if (i + 1 >= row) {
                    array[i][j] = Math.max(1, array[i][j + 1] - dungeon[i][j]);
                } else if (j + 1 >= col) {
                    array[i][j] = Math.max(1, array[i + 1][j] - dungeon[i][j]);
                } else {
                    a = Math.abs(array[i][j + 1] - dungeon[i][j]);
                    b = Math.abs(array[i + 1][j] - dungeon[i][j]);
                    array[i][j] = Math.min(a, b);
                }
            }
        }
        printArray(array);
        return array[0][0] <= 0 ? 1 : array[0][0];
    }
}
