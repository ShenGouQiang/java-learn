package leetcode.no61;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        new Solution().testOne();
    }

    public void testOne(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        rotateRight(n1,2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int length = 0;
        ListNode originTail = head;
        ListNode originHead = head;

        while (originHead != null) {
            length++;
            originTail = originHead;
            originHead = originHead.next;
        }
        originTail.next = head;
        ListNode newTail = head;
        for (int i=0;i<length - k % length -1;i++){
            newTail = newTail.next;

        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
