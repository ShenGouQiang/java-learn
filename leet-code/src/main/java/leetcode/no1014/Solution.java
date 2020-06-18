package leetcode.no1014;

import org.junit.Test;

/**
 * 1014. 最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 * 通过次数18,388提交次数35,187
 *
 *
 *
 * @author shengouqiang
 * @date 2020/6/17
 */
public class Solution {

    /**
     * 这道题目，感觉像是DP。。但是实际一看，并不是DP。
     *
     * 这道题目的解决思路还是要从这个公式下手   A[i]+A[j] + i -j  其实就是等价于  (A[i] + i) + (A[j]-j) 这两个部分。。当我们指向第j个节点的时候，此时我们的(A[j]-j)
     * 是固定得了。。。但是在0~j之间，我们的（A[i] + i） 却有很多种可能。 因此，我们需要的是求取 (A[i] + i) 的最大值即可。
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int result =0;
        int mx = 0;
        for (int j=0;j<A.length;j++){
            result = Math.max(result,mx +A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }
        return result;
    }






    @Test
    public void testOne(){
        int[] array = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(array));
    }
}
