package leetcode.no92;

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
        show(reverseBetween(n1, 2, 4));
    }

    public void testTwo() {
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        n3.next = n5;
        show(reverseBetween(n3, 1, 1));
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tmpNode = head;
        ListNode prev = null;
        int index = 1;
        while (tmpNode != null && index != m) {
            prev = tmpNode;
            tmpNode = tmpNode.next;
            index++;
        }
        if(null != prev){
            prev.next = null;
        }
        ListNode newNode = new ListNode(1);
        ListNode newNodeTail = tmpNode;
        while (tmpNode != null && index <= n) {
            ListNode nextOne = tmpNode.next;
            tmpNode.next=null;
            if (newNode.next == null) {
                newNode.next = tmpNode;
            } else {
                tmpNode.next = newNode.next;
                newNode.next = tmpNode;
            }
            tmpNode = nextOne;
            index++;
        }
        if(null != prev){
            prev.next = newNode.next;
        }else{
            head= newNode.next;
        }
        newNodeTail.next = tmpNode;
        newNode.next = null;
        return head;
    }
}

