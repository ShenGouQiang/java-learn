package offer.no22;

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


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        ListNode prev = temp;
        temp.next = head;
        int index = 1;
        while (head != null) {
            if (index > k) {
                prev = prev.next;
            }
            head = head.next;
            index++;
        }
        return prev.next;
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
        ListNode result = getKthFromEnd(l1,2);
        System.out.println(result);
    }
}
