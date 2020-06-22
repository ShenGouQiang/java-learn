package offer.no30;

import java.util.Stack;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }

    }

    public void pop() {
        if (!stack.empty()) {
            min.pop();
            stack.pop();
        }
    }

    public int top() {

        return stack.empty() ? -1 : stack.peek();
    }

    public int min() {
        return min.empty() ? -1 : min.peek();
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}
