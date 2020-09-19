package offer.no31;

import org.junit.Test;

import java.util.Stack;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.empty() && stack.peek() == popped[popIndex++]) {
                stack.pop();
            }
        }
        return stack.empty();
    }

    @Test
    public void testOne() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

    @Test
    public void testTwo() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 1, 2};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
