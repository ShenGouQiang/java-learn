package mianshi;

import org.junit.Test;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示:
 *
 * 1.n范围在[1, 1000000]之间
 *
 * @author shengouqiang
 * @date 2020/5/27
 */
public class WaysToStep {

    @Test
    public void testOne(){
//        System.out.println(waysToStep(10));
//        System.out.println(waysToStep(3));
//        System.out.println(waysToStep(5));
//        System.out.println(waysToStep(61));
        System.out.println(waysToStep(76) == 176653584);

        System.out.println(waysToStep(76));
    }

    public int waysToStep(int n) {
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 2;
        }
        if(n ==3){
            return 4;
        }
        int x1=1;
        int x2=2;
        int x3=4;
        int xn=0;
        for (int i=4;i<=n;i++){
            xn =( ((x1 +x2) & (1000000007- 1)) + x3) & (1000000007- 1);
            x1=x2;
            x2=x3;
            x3=xn;
        }
        return xn;
    }
}
