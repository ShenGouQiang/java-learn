package offer.no29;

import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int index = 0;
        for (int i = 0; i < (row +1) /2; i++) {
            for (int j = i; j <= col - 1 - i; j++) {
                result[index++] = matrix[i][j];
            }
            for (int j = i + 1; j <= row-1-i; j++) {
                result[index++] = matrix[j][col - i - 1];
            }
            for (int j = col - 1 - i - 1; j >= i && row - 1 - i > i; j--) {
                result[index++] = matrix[row - i - 1][j];
            }
            for (int j = row - 1 - i - 1; j > i && col - 1 - i > i; j--) {
                result[index++] = matrix[j][i];
            }
        }
        return result;
    }

    @Test
    public void testOne(){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int[] result =spiralOrder(matrix);
        System.out.println(result);
    }

    @Test
    public void testTwo(){
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] result =spiralOrder(matrix);
        System.out.println(result);
    }


    @Test
    public void testThree(){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[] result =spiralOrder(matrix);
        System.out.println(result);
    }

    @Test
    public void testFour(){
        int[][] matrix={{1},{2},{3}};
        int[] result =spiralOrder(matrix);
        System.out.println(result);
    }

    @Test
    public void testFive(){
        int[][] matrix={{1,2,3}};
        int[] result =spiralOrder(matrix);
        System.out.println(result);
    }

    @Test
    public void testSix(){
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] result =spiralOrder(matrix);
        System.out.println(result);
    }

    @Test
    public void testSeven(){
        int[][] matrix={{2,5,8},{4,0,-1}};
        int[] result =spiralOrder(matrix);
        System.out.println(result);
    }



}
