package offer.no13;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {

    @Test
    public void testOne() {
        Assert.assertEquals(3, movingCount(2, 3, 1));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(1, movingCount(3, 1, 0));
    }


    public int movingCount(int m, int n, int k) {
        int[][] array = new int[m][n];
        int count = 1;
        array[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempR = temp[0];
            int tempC = temp[1];
            if (tempR + 1 < m && array[tempR + 1][tempC] == 0 && smallerByK(tempR + 1, tempC, k)) {
                array[tempR + 1][tempC] = 1;
                count++;
                queue.offer(new int[]{tempR + 1, tempC});
            }
            if (tempC + 1 < n && array[tempR][tempC + 1] == 0 && smallerByK(tempR, tempC + 1, k)) {
                array[tempR][tempC + 1] = 1;
                count++;
                queue.offer(new int[]{tempR, tempC + 1});
            }
        }
        return count;
    }

    private boolean smallerByK(int m, int n, int k) {
        int count = 0;
        while (m != 0 && n != 0) {
            count += m % 10;
            count += n % 10;
            m = m / 10;
            n = n / 10;
        }
        while (m != 0) {
            count += m % 10;
            m = m / 10;
        }
        while (n != 0) {
            count += n % 10;
            n = n / 10;
        }
        return count <= k;
    }
}
