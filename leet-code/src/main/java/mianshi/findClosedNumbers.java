package mianshi;

import com.sun.media.jfxmediaimpl.HostUtils;

/**
 * 面试题 05.04. 下一个数
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 * <p>
 * 示例1:
 * <p>
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 * <p>
 * 输入：num = 1
 * 输出：[2, -1]
 * 提示:
 * <p>
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 *
 * @author shengouqiang
 * @date 2020/5/14
 */
public class findClosedNumbers {
    public static int[] findClosedNumbers(int num) {

        return new int[]{getMaxValue(num), getMinValue(num)};
    }


    private static int getMaxValue(int num) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >>> i) & 1) == 1) {
                count++;
            }
            if (((num >>> i) & 1) == 1 && ((num >>> (i + 1)) & 1) == 0) {
                index = i;
                break;
            }
        }
        int err = 3 << index;
        num = num ^ err;
        num = (num >>> index) << index;
        int tmp = 0;
        for(int i=0;i<count -1;i++){
            tmp += 1 << i;
        }
        return num + tmp;

    }

    private static int getMinValue(int num) {
        if(num == 1 ){
            return -1;
        }
        int index = -1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >>> i) & 1) == 1) {
                count++;
            }
            if (((num >>> i) & 1) == 0 && ((num >>> (i + 1)) & 1) == 1) {
                index = i;
                break;
            }
        }
        int err = 3 << index;
        num = num ^ err;
        num = (num >>> index) << index;
        int tmp = 0;
        for(int i=0;i<count;i++){
            tmp += 1 << i;
        }
        tmp = tmp << (index -count);
        return num + tmp;
    }


    public static void main(String[] args) {
        System.out.println(findClosedNumbers(2)[0] == 4);
        System.out.println(findClosedNumbers(2)[1] == 1);

        System.out.println(findClosedNumbers(1)[0] == 2);
        System.out.println(findClosedNumbers(1)[1] == -1);

        System.out.println(findClosedNumbers(1837591841)[0] ==1837591842);
        System.out.println(findClosedNumbers(1837591841)[1] == 1837591832);

        System.out.println(findClosedNumbers(1913007205)[0] == 1913007206);
        System.out.println(findClosedNumbers(1913007205)[1] == 1913007203);


//        System.out.println(findClosedNumbers(2)[0] == 4);
//        System.out.println("原来值---》" + Integer.toBinaryString(2));
//        System.out.println("最小值---》" + Integer.toBinaryString(1));
//        System.out.println("计算值---》" + Integer.toBinaryString(getMaxValue(2)));
//        System.out.println("计算值---》" + Integer.toBinaryString(getMinValue(2)));

    }
}
