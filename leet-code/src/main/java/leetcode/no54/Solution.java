package leetcode.no54;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 通过次数64,368提交次数158,697
 *
 * @author shengouqiang
 * @date 2020/6/19
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0){
            return result;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        for (int i = 0; i <(Math.min(rowNum, colNum)+1)/2; i++) {
           for (int j = i ;j < colNum -i ;j ++){
               result.add(matrix[i][j]);
           }
           for (int j = i +1;j<rowNum - i ;j++){
               result.add(matrix[j][colNum -1-i]);
           }
           for (int j = colNum -1 - i  - 1;j >= i  && rowNum -1 -i !=i;j--){
               result.add(matrix[rowNum-1-i][j]);
           }
           for (int j = rowNum -1- i -1; j >= i+1 && colNum - 1 - i != i;j--){
               result.add(matrix[j][i]);
           }
        }
        return result;
    }

    @Test
    public void testOne(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    @Test
    public void testTwo(){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    @Test
    public void testThree(){
        int[][] matrix = {{7},{9},{6}};
        System.out.println(spiralOrder(matrix));
    }

    @Test
    public void testFour(){
        int[][] matrix = {{2,5,8},{4,0,-1}};
        System.out.println(spiralOrder(matrix));
    }



}
