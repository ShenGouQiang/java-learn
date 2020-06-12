package leetcode.no64;

import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/10
 */
public class Solution {

    @Test
    public void testOne(){
        System.out.println(sumNums(9));
    }

    @Test
    public void testTwo(){
        System.out.println(sumNums(3));
    }

    int result =0;
    public int sumNums(int n) {
        boolean x = n >1 && sumNums(n-1) >0;
        result +=n;
        return result;
    }
}
