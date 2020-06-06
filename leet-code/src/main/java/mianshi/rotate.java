package mianshi;

import org.junit.Test;

/**
 * 面试题 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author shengouqiang
 * @date 2020/5/14
 */
public class rotate {

    @Test
    public void testOne(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        show(matrix);
        System.out.println("++++++++++++++++++++++++");
        rotate1(matrix);
        System.out.println("++++++++++++++++++++++++");

        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        show(matrix1);
        System.out.println("++++++++++++++++++++++++");
        rotate1(matrix1);
        System.out.println("++++++++++++++++++++++++");

    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                result[j][n-1-i] = matrix[i][j];
            }
        }
        show(result);
        matrix =result;
    }

    public void rotate1(int[][] matrix){
        int n = matrix.length;
        for (int i=0;i<(n+1)/2;i++){
            for (int j=i;j<n-i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=tmp;
            }
        }
        show(matrix);
    }


    private void show(int[][] matrix){
        int n = matrix.length;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
