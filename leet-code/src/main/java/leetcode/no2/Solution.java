package leetcode.no2;

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            boolean mark = false;
            ListNode returnNode = null;
            ListNode tmpNode = returnNode;
            while (l1 != null && l2 != null){
                int result = l1.val + l2.val + ( mark ? 1: 0);
                l1=l1.next;
                l2=l2.next;
                if(result >= 10){
                    mark=true;
                }else{
                    mark=false;
                }
                ListNode tmp = new ListNode( result % 10);
                if(returnNode == null){
                    returnNode = tmp;
                    tmpNode= tmp;
                }else{
                    tmpNode.next = tmp;
                    tmpNode = tmp;
                }
            }
            while (l1 != null){
                int result = l1.val + ( mark ? 1: 0);
                l1=l1.next;
                if(result >= 10){
                    mark=true;
                }else{
                    mark=false;
                }
                ListNode tmp = new ListNode( result % 10);
                if(returnNode == null){
                    returnNode = tmp;
                    tmpNode= tmp;
                }else{
                    tmpNode.next = tmp;
                    tmpNode = tmp;
                }
            }

            while (l2 != null){
                int result = l2.val + ( mark ? 1: 0);
                l2=l2.next;
                if(result >= 10){
                    mark=true;
                }else{
                    mark=false;
                }
                ListNode tmp = new ListNode( result % 10);
                if(returnNode == null){
                    returnNode = tmp;
                    tmpNode= tmp;
                }else{
                    tmpNode.next = tmp;
                    tmpNode = tmp;
                }
            }
            if(mark){
                ListNode tmp = new ListNode( 1);
                tmpNode.next= tmp;
                tmpNode = tmp;
            }
            return  returnNode;
        }
    }
}
