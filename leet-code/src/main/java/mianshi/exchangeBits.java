package mianshi;

/**
 * 面试题 05.07. 配对交换
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * 示例2:
 * <p>
 * 输入：num = 3
 * 输出：3
 * 提示:
 * <p>
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 * @author shengouqiang
 * @date 2020/5/14
 */
public class exchangeBits {

    public static int exchangeBits(int num) {
        int k = 3;
        int sum = 0;
        for (int i = 0; i < 32; i += 2) {
            int result = (num & (k << i)) >>> i;
            int tmpA = result & 1;
            int tmpB = result & 2;
            sum = sum | (((tmpA << 1) | (tmpB >>> 1)) << i);
        }
        return sum;
    }

    public static void main(String[] args) {
       // System.out.println(exchangeBits(3));
        //System.out.println(exchangeBits(2));
       // System.out.println(exchangeBits(1));
        System.out.println(Integer.toBinaryString(571603718));
        System.out.println(Integer.toBinaryString(exchangeBits(571603718)));
        System.out.println(exchangeBits(571603718));

    }

}
