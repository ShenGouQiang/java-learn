package offer.no14;

import org.junit.Test;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1）
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 *
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        if (n == 5) return 6;
        if (n == 6) return 9;
        long sum = 1;
        while (n >6){
            sum =(sum *3) %1000000007;
            n-=3;
        }
        sum = (sum * cuttingRope(n)) %1000000007;
        return (int) sum;
    }

    @Test
    public void testOne(){
        System.out.println(cuttingRope(54));
    }

    @Test
    public void testTwo(){
        System.out.println(3^3);
        System.out.println(3^1);
        System.out.println(3^2);
    }

    @Test
    public void testThree(){
        int sum = 1;
        for (int i=0;i<17;i++){
            sum = (sum * 3) %1000000007;
        }
        System.out.println((sum * 2) % 1000000007);
    }
}
