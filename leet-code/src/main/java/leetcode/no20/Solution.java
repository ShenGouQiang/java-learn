package leetcode.no20;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    @Test
    public void testOne() {
        Assert.assertTrue(isValid("()"));
    }

    @Test
    public void testTwo() {
        Assert.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void testThree() {
        Assert.assertFalse(isValid("(]"));
    }

    @Test
    public void testFour() {
        Assert.assertFalse(isValid("([)]"));
    }

    @Test
    public void testFive() {
        Assert.assertTrue(isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>(6);
        map.put('(', 1);
        map.put(')', 2);
        map.put('{', 3);
        map.put('}', 4);
        map.put('[', 5);
        map.put(']', 6);
        char[] array = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            int temp = map.get(array[i]);
            if ((temp & 1) == 0) {
                if (stack.empty() || stack.peek() != temp - 1) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(temp);
            }
        }
        return stack.empty();
    }
}
