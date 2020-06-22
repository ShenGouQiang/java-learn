package offer.no24;

import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode next = head.next;
        while (head != null){
            head.next = prev;
            prev = head;
            head = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }

    @Test
    public void testOne(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode result = reverseList(l1);
        System.out.println(result);
    }
}
