package leetcode.no1143;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] array = new int[text1.length() + 1][text2.length() + 1];
        char[] str1Array = text1.toCharArray();
        char[] str2Array = text2.toCharArray();
        for (int i = 1; i <= str1Array.length; i++) {
            for (int j = 1; j <= str2Array.length; j++) {
                if (str1Array[i - 1] == str2Array[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
  //      print(array);
        return array[text1.length()][text2.length()];
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(3, longestCommonSubsequence("abc", "abc"));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(0, longestCommonSubsequence("abc", "def"));
    }

    @Test
    public void testFour() {
        Assert.assertEquals(1, longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    @Test
    public void testFive() {
        Assert.assertEquals(2, longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
    }


    private void print(int[][] array) {
        for (int[] tmp : array) {
            for (int t : tmp) {
                System.out.print(t + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
