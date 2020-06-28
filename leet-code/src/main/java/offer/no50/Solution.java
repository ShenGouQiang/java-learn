package offer.no50;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shengouqiang
 * @date 2020/6/28
 */
public class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Set<Character> set = new HashSet<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                continue;
            }
            if (i == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i);
            }
            set.add(s.charAt(i));
        }
        return ' ';
    }

    @Test
    public void testOne() {
        Assert.assertEquals('b', firstUniqChar("abaccdeff"));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(' ', firstUniqChar(""));
    }
}
