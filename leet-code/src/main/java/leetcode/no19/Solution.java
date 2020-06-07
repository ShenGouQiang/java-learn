package leetcode.no19;

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
          new Solution().testTwo();
           new Solution().testThree();
    }


    public void testTwo() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        show(removeNthFromEnd(n1, 1));
    }

    public void testThree() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        show(removeNthFromEnd(n1, 2));
    }

    public void testOne() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        show(removeNthFromEnd(n1, 2));
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode prevHead = new ListNode(-1);
        ListNode prevTemp = prevHead;
        prevHead.next = head;
        int index=1;
        while (head.next != null){
            if(index >= n){
                prevTemp= prevTemp.next;
            }
            head = head.next;
            index++;
        }
        prevTemp.next = prevTemp.next.next;
        return prevHead.next;
    }
}

