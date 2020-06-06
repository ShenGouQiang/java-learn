package mianshi;

import org.junit.Test;

/**
 * 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * 提示:
 * <p>
 * 保证乘法范围不会溢出
 *
 * @author shengouqiang
 * @date 2020/5/27
 */
public class Multiplys {

    @Test
    public void testOne() {
        System.out.println(multiply(1, 10));
        System.out.println(multiply(3, 4));
        System.out.println(multiply(797231563, 2));
        System.out.println(multiply(73807517, 14));
    }

    public int multiply(int A, int B) {
        int index = 1;
        long result = 0;
        while (B != 0) {
            if ((B & 1) == 1) {
                System.out.println(result);
                result = result + (A << (index - 1));
            }
            B = B >>> 1;
            index++;
        }
        return (int) result;
    }
}