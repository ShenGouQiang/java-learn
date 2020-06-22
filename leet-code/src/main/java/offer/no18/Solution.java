package offer.no18;

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


    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode prev = temp;
        ListNode next = head.next;
        while (head != null && head.val != val){
            prev= head;
            head = next;
            if(next != null){
                next = next.next;
            }
        }
        if(head == null || head.val != val){
            return temp.next;
        }
        prev.next = next;
        return temp.next;
    }

    @Test
    public void testOne(){
        ListNode l4 = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        l4.next=l1;
        l1.next=l2;
        l2.next=l5;
        ListNode returnNode = deleteNode(l4,4);
        System.out.println(returnNode);
    }


    @Test
    public void testTwo(){
        ListNode l4 = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        l4.next=l1;
        l1.next=l2;
        l2.next=l5;
        ListNode returnNode = deleteNode(l4,1);
        System.out.println(returnNode);
    }


    @Test
    public void testThree(){
        ListNode l4 = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        l4.next=l1;
        l1.next=l2;
        l2.next=l5;
        ListNode returnNode = deleteNode(l4,2);
        System.out.println(returnNode);
    }

    @Test
    public void testFoure(){
        ListNode l4 = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        l4.next=l1;
        l1.next=l2;
        l2.next=l5;
        ListNode returnNode = deleteNode(l4,5);
        System.out.println(returnNode);
    }


    @Test
    public void testFive(){
        ListNode l4 = new ListNode(4);
        ListNode returnNode = deleteNode(l4,4);
        System.out.println(returnNode);
    }


    @Test
    public void testSix(){
        ListNode l4 = new ListNode(4);
        ListNode returnNode = deleteNode(l4,5);
        System.out.println(returnNode);
    }


    @Test
    public void testSeven(){
        ListNode l4 = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        l4.next=l1;
        l1.next=l2;
        l2.next=l5;
        ListNode returnNode = deleteNode(l4,7);
        System.out.println(returnNode);
    }
}
