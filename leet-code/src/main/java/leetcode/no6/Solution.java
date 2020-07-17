package leetcode.no6;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertEquals("LCIRETOESIIGEDHN", convert("LEETCODEISHIRING", 3));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals("LDREOEIIECIHNTSG", convert("LEETCODEISHIRING", 4));
    }

    @Test
    public void testThree() {
        Assert.assertEquals("A", convert("A", 1));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        char[] sArray = s.toCharArray();
        int length = sArray.length;
        char[] result = new char[length];
        int index = 0;
        int firstRowIndex = 0;
        while (firstRowIndex < length) {
            result[index++] = sArray[firstRowIndex];
            firstRowIndex = firstRowIndex + ((numRows - 1) << 1);
        }
        for (int i = 1; i < numRows - 1; i++) {
            int j = i;
            boolean flag = false;
            while (j < length) {
                result[index++] = sArray[j];
                if (!flag) {
                    j = j + ((numRows - 1 - i) << 1);
                    flag = true;
                } else {
                    j = j + (i << 1);
                    flag = false;
                }
            }
        }
        int lastRowIndex = numRows - 1;
        while (lastRowIndex < length) {
            result[index++] = sArray[lastRowIndex];
            lastRowIndex = lastRowIndex + ((numRows - 1) << 1);
        }
        return new String(result);
    }
}
