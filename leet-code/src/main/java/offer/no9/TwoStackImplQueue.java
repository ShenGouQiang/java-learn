package offer.no9;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @author shengouqiang
 * @date 2020/4/30
 */
public class TwoStackImplQueue {


    private Stack<Integer> stack;

    private Stack<Integer> help;

    public TwoStackImplQueue() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    public void appendTail(int value) {
        while (!help.empty()) {
            stack.push(help.pop());
        }
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.empty() && help.empty()) {
            return -1;
        }
        if (!help.empty()) {
            return help.pop();
        }
        while (!stack.empty()) {
            help.push(stack.pop());
        }
        return help.pop();
    }
}
