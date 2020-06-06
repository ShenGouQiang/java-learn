package mianshi;

import lombok.ToString;
import lombok.val;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author shengouqiang
 * @date 2020/5/11
 */
public class MinStack {


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


    private final ListNode head;
    private ListNode tail;
    private int listLength;
    private final ListNode minValHead;
    private ListNode minValTail;

    public MinStack() {
        head = new ListNode(Integer.MAX_VALUE);
        tail = head;
        listLength = 1;
        minValHead = new ListNode(Integer.MAX_VALUE);
        minValTail = minValHead;
    }

    public void push(int x) {
        ListNode tmp = new ListNode(x);
        if (tail.prev == null) {
            head.next = tmp;
            tmp.prev = head;
            tail = tmp;
            addMinValToLinkedList(x);
            listLength++;
            return;
        }
        tail.next = tmp;
        tmp.prev = tail;
        tail = tmp;
        listLength++;
        addMinValToLinkedList(x);
    }

    public boolean empty() {
        return listLength == 1 ? true : false;
    }

    public void pop() {
        if (listLength == 1) {
            throw new RuntimeException("stack not contains element");
        }
        ListNode tailNode = tail;
        tail = tail.prev;
        tail.next = null;
        listLength--;
        removeMinValToLinkedList(tailNode.val);
    }

    public int top() {
        if (listLength == 1) {
            throw new RuntimeException("stack not contains element");
        }
        return tail.val;
    }

    public int getMin() {
        if (listLength == 1) {
            throw new RuntimeException("stack not contains element");
        }
        return minValTail.val;
    }

    private void addMinValToLinkedList(int x) {
        ListNode tmpNode = minValHead;
        ListNode minValNode = new ListNode(x);
        if (minValTail == minValHead) {
            minValHead.next = minValNode;
            minValNode.prev = minValHead;
            minValTail = minValNode;
            return;
        }
        tmpNode = minValHead.next;
        while (tmpNode.val > x) {
            if (minValHead.val == x) {
                return;
            }
            if (tmpNode == minValTail) {
                minValTail.next = minValNode;
                minValNode.prev = minValTail;
                minValTail = minValNode;
                return;
            }
            tmpNode = tmpNode.next;
        }
        ListNode tmpNodePrev = tmpNode.prev;
        tmpNodePrev.next = minValNode;
        minValNode.prev = tmpNodePrev;
        tmpNode.prev = minValNode;
        minValNode.next = tmpNode;
    }

    private void removeMinValToLinkedList(int x) {
        if (minValTail == minValHead) {
            return;
        }
        ListNode tmpNode = minValHead.next;
        while (tmpNode != null) {
            if (tmpNode.val == x) {
                if (tmpNode == minValTail) {
                    minValTail = minValTail.prev;
                    minValTail.next = null;
                } else {
                    ListNode tmpNodePrev = tmpNode.prev;
                    ListNode tmpNodeNext = tmpNode.next;
                    tmpNodePrev.next = tmpNodeNext;
                    tmpNodeNext.prev = tmpNodePrev;
                }
                //help gc
                tmpNode.next = null;
                //help gc
                tmpNode.prev = null;

            }
            tmpNode = tmpNode.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int x) {
            val = x;
            next = null;
            prev = null;
        }
    }

}
