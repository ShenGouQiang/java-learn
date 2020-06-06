package mianshi;

import org.junit.Test;

/**
 * 面试题 05.06. 整数转换
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 *
 *
 * @author shengouqiang
 * @date 2020/5/13
 */
public class convertInteger {

    @Test
    public void testOne(){
        System.out.println(convertInteger(29,15));
        System.out.println(convertInteger(1,2));
    }

    public int convertInteger(int A, int B) {
        int a = A ^ B;
        int count =0;
        while(a !=0){
            a = a & (a -1);
            count++;
        }
        return count;
    }
}
