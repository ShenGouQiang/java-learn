package offer.no06;

import org.junit.Test;

import java.util.Stack;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int size = 0;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
            size++;
        }
        int[] result = new int[size];
        int index=0;
        while (!stack.empty()){
            result[index++] = stack.pop();
        }
        return result;
    }

    public int[] reversePrint2(ListNode head){
        if(head == null){
            return new int[0];
        }
        if(head.next == null){
            return new int[]{head.val};
        }
        ListNode prev = null;
        ListNode next = head.next;
        int size =1;
        while (head != null){
            head.next=prev;
            prev=head;
            head=next;
            if(head != null){
                size++;
            }
            if(next != null){
                next=next.next;
            }
        }
        head=prev;
        int[] result = new int[size];
        int index=0;
        while (head!= null){
            result[index++] = head.val;
            head= head.next;
        }
        return result;
    }

    @Test
    public void testOne(){
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l1.next=l3;
        l3.next=l2;
        reversePrint2(l1);
    }
}
