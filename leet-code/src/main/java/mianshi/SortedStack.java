package mianshi;

import java.util.Stack;

/**
 * 面试题 03.05. 栈排序
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
 * 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。
 * 当栈为空时，peek 返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * 示例2:
 * <p>
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * 说明:
 * <p>
 * 栈中的元素数目在[0, 5000]范围内。
 * <p>
 * <p>
 * <p>
 * <p>
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 *
 * @author shengouqiang
 * @date 2020/5/12
 */
public class SortedStack {

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        stack.pop();

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.push(40);
        stack.pop();

        stack.push(19);
        System.out.println(stack.peek());
        stack.push(44);
        System.out.println(stack.peek());
        stack.pop();

        stack.pop();
        stack.push(42);
        System.out.println(stack.isEmpty());
        stack.push(8);

        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push(29);
        System.out.println(stack.peek());

        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push(25);
        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.peek());

        stack.pop();
        stack.push(52);
        stack.push(63);
        System.out.println(stack.isEmpty());

        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.push(47);

        stack.pop();
        stack.push(45);
        stack.push(52);
        System.out.println(stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.push(17);
        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());
        stack.pop();
        System.out.println(stack.peek());
        stack.push(6);

        stack.push(30);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isEmpty());

        System.out.println(stack.isEmpty());
        System.out.println(stack.isEmpty());
        System.out.println(stack.isEmpty());
        stack.push(51);

        stack.push(46);
        stack.push(2);
        stack.push(56);
        stack.push(39);

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.push(38);
    }

    private Stack<Integer> stack;
    private Stack<Integer> helpStack;

    public SortedStack() {
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int val) {
        //解法一
//        while (!stack.empty() && stack.peek() < val){
//            helpStack.push(stack.pop());
//        }
//        stack.push(val);
//        while (!helpStack.empty()){
//            stack.push(helpStack.pop());
//        }
        //解法二
        if (stack.empty() && helpStack.empty()) {
            stack.push(val);
            return;
        }
        if (stack.empty() && !helpStack.empty()) {
            while (helpStack.peek() > val) {
                stack.push(helpStack.pop());
            }
            stack.push(val);
            return;
        }
        if (!stack.empty() && helpStack.empty()) {
            while (!stack.empty() && stack.peek() < val) {
                helpStack.push(stack.pop());
            }
            stack.push(val);
            return;
        }
        if (!stack.empty() && !helpStack.empty()) {
            if (stack.peek() > val && val >= helpStack.peek()) {
                stack.push(val);
                return;
            }
            if (val >= stack.peek() && val >= helpStack.peek()) {
                while (!stack.empty() && stack.peek() < val) {
                    helpStack.push(stack.pop());
                }
                stack.push(val);
                return;
            }
            if (val < helpStack.peek() && val < stack.peek()) {
                while (!helpStack.empty() && helpStack.peek() > val) {
                    stack.push(helpStack.pop());
                }
                stack.push(val);
                return;
            }
        }
    }

    public void pop() {
        //解法一
//        if (!stack.empty()) {
//            stack.pop();
//        }
        //解法二
        peek();
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        //解法一
//       int val = stack.empty() ? -1 : stack.peek();
//       return val;
        while (!helpStack.empty()) {
            stack.push(helpStack.pop());
        }
        return stack.empty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        //解法一
        //      return stack.empty();
        return stack.empty() && helpStack.empty();
    }
}
