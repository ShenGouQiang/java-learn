package mianshi.no0811;

import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/24
 */
public class Solution {
    public int waysToChange(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;

        for (int i = 1; i <= n; i++) {
            int temp = 0;
            if (i - 25 >= 0) {
                if (i == 25) {
                    temp =(temp + result[i - 25])%1000000007;
                } else {
                    temp = (temp + result[i - 25] - result[25] + 1)%1000000007;
                }
            }
            if (i - 10 >= 0) {
                if (i == 10) {
                    temp = (temp + result[i - 10])%1000000007;
                } else {
                    temp =(temp+ result[i - 10] - result[10] + 1)%1000000007;
                }
            }
            if (i - 5 >= 0) {
                if (i == 5) {
                    temp = (temp+ result[i - 5])%1000000007;
                } else {
                    temp = (temp+ result[i - 5] - result[5] + 1)%1000000007;
                }
            }
            if (i - 1 >= 0) {
                temp =(temp+ result[i - 1])%1000000007;
            }
            result[i] = temp;
        }
        return result[n];
    }

    @Test
    public void testOne() {
        System.out.println(waysToChange(1));
    }

    @Test
    public void testTwo() {
        System.out.println(waysToChange(2));
    }

    @Test
    public void testFive() {
        System.out.println(waysToChange(5));
    }

    @Test
    public void testTen() {
        System.out.println(waysToChange(25));
    }

    @Test
    public void test11(){
        System.out.println(waysToChange(61));
    }
}
