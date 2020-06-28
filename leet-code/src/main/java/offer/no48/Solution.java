package offer.no48;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengouqiang
 * @date 2020/6/28
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charToIndexMap = new HashMap<>(s.length());
        char[] array = s.toCharArray();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charToIndexMap.containsKey(array[i])) {
                int index = charToIndexMap.get(array[i]);
                start = start > index ? start : index + 1;
            }
            charToIndexMap.put(array[i], i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    @Test
    public void testOne() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void testFour() {
        Assert.assertEquals(5, lengthOfLongestSubstring("tmmzuxt"));
    }
}
