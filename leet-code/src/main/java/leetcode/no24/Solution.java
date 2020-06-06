package leetcode.no24;

import org.junit.Test;

class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        //   new Solution().testOne();
        //    new Solution().testTwo();
        //    new Solution().testThree();
        //    new Solution().testFour();
        new Solution().testFive();
    }

    @Test
    public void testOne() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        show(swapPairs(n1));
    }

    @Test
    public void testTwo() {
        ListNode n1 = new ListNode(1);
        show(swapPairs(n1));
    }

    @Test
    public void testThree() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        show(swapPairs(n1));
    }

    @Test
    public void testFour() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        show(swapPairs(n1));
    }

    @Test
    public void testFive() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        show(swapPairs(n1));
    }


    private void show(ListNode head) {
        int index = 0;
        while (head != null) {
            if (index > 0 && index % 5 == 0) {
                System.out.println();
            }
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = null;
        ListNode current = head;
        ListNode nextOne = current.next;
        ListNode nextTwo = nextOne.next;
        ListNode returnNode = nextOne;
        while (nextOne != null) {
            nextOne.next = current;
            if (null != lastNode) {
                lastNode.next = nextOne;
            }
            current.next = nextTwo;
            lastNode = current;
            current = nextTwo;
            if (current == null) {
                nextOne = null;
                continue;
            }
            nextOne = current.next;
            if (nextOne == null) {
                nextTwo = null;
                continue;
            }
            nextTwo = nextOne.next;
        }
        return returnNode;
    }


}