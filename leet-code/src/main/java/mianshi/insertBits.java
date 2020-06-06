package mianshi;

import org.junit.Test;

/**
 * 面试题 05.01. 插入
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，
 * 到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。
 * 例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 10000000000, M = 10011, i = 2, j = 6
 *  输出：N = 10001001100
 * 示例2:
 *
 *  输入： N = 0, M = 11111, i = 0, j = 4
 *  输出：N = 11111
 *
 * @author shengouqiang
 * @date 2020/5/13
 */
public class insertBits {

    @Test
    public void testTwo(){
        System.out.println(charArrayToInt("00000000000000000000010000000000".toCharArray())); }


    @Test
    public void testOne(){
        System.out.println(insertBits(1024,19,2,6));
        System.out.println(insertBits(0,31,0,4));
        System.out.println(insertBits(1143207437,1017033,11,31));
    }

    private char[] intToCharArray(int num) {
        char[] chs = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char) (((num >> i) & 1) + '0');
        }
        return chs;
    }

    private int charArrayToInt(char[] array){
        int result =0;
        for (int i=array.length -1 ;i>=0;i--){
            if('1'==array[i]){
                result = result | 1 << (array.length -1 -i);
            }
        }
        return result;
    }

    public int insertBits(int N, int M, int i, int j) {
        char[] charM = intToCharArray(M);
        char[] charN = intToCharArray(N);
        for (int p=Integer.SIZE -1 -i,q=Integer.SIZE-1;p>=Integer.SIZE -1 -j;p--,q--){
            charN[p] = charM[q];
        }
        return charArrayToInt(charN);
    }

}
