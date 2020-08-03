package leetcode.no415;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertTrue("579".equals(addStrings("123", "456")));
        Assert.assertTrue("1997".equals(addStrings("998", "999")));
        Assert.assertTrue("2997".equals(addStrings("1998", "999")));
        Assert.assertTrue("2997".equals(addStrings("999", "1998")));
        Assert.assertTrue("1468".equals(addStrings("234", "1234")));
    }


    public String addStrings(String num1, String num2) {
        boolean carry = false;
        char[] n1Array = num1.toCharArray();
        char[] n2Array = num2.toCharArray();
        if (n1Array.length < n2Array.length) {
            char[] temp = n1Array;
            n1Array = n2Array;
            n2Array = temp;
        }
        int n1Index = n1Array.length - 1;
        int n2Index = n2Array.length - 1;
        while (n2Index >= 0) {
            int n1Temp = n1Array[n1Index] - '0';
            int n2Temp = n2Array[n2Index] - '0';
            int result = carry ? n1Temp + n2Temp + 1 : n1Temp + n2Temp;
            if (result >= 10) {
                n1Array[n1Index] = (char) (result - 10 + '0');
                carry = true;
            } else {
                n1Array[n1Index] = (char) (result + '0');
                carry = false;
            }
            n1Index--;
            n2Index--;
        }
        while (n1Index >= 0 && carry) {
            int n1Temp = n1Array[n1Index] - '0';
            int result = carry ? n1Temp + 1 : n1Temp;
            if (result >= 10) {
                n1Array[n1Index] = (char) (result - 10 + '0');
                carry = true;
            } else {
                n1Array[n1Index] = (char) (result + '0');
                carry = false;
            }
            n1Index--;
        }
        return carry ? "1" + new String(n1Array) : new String(n1Array);
    }
}
