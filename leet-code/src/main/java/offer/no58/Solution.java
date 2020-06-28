package offer.no58;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/28
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String temp = s.trim();
        if ("".equals(s)) {
            return s;
        }
        String[] array = temp.split(" ");
        StringBuffer buffer = new StringBuffer("");
        for (int i = array.length - 1; i >= 0; i--) {
            if (!"".equals(array[i].trim())) {
                buffer.append(array[i]);
                if (i != 0) {
                    buffer.append(" ");
                }
            }
        }
        return buffer.toString();
    }

    @Test
    public void testOne() {
        Assert.assertTrue("blue is sky the".equals(reverseWords("the sky is blue")));
    }

    @Test
    public void testTwo() {
        Assert.assertTrue("world! hello".equals(reverseWords("  hello world!  ")));
    }

    @Test
    public void testThree() {
        Assert.assertTrue("student. a am I".equals(reverseWords("I am a student. ")));
    }

    @Test
    public void testFour() {
        Assert.assertTrue("example good a".equals(reverseWords("a good   example")));
    }


    public String reverseLeftWords(String s, int n) {
        char[] array = s.toCharArray();
        int length = s.length();
        int realIndex = n % length;
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[realIndex % length];
            realIndex++;
        }
        return new String(result);
    }

    @Test
    public void testFive(){
        Assert.assertTrue("cdefgab".equals(reverseLeftWords("abcdefg",2)));
    }

    @Test
    public void testSix(){
        Assert.assertTrue("umghlrlose".equals(reverseLeftWords("lrloseumgh",6)));
    }
}
