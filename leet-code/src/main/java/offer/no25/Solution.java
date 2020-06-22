package offer.no25;

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


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-99);
        ListNode temp = newHead;
        while (l1 !=null && l2!= null){
            if(l1.val >= l2.val){
                ListNode p = new ListNode(l2.val);
                temp.next=p;
                temp=p;
                l2=l2.next;
            }else{
                ListNode p = new ListNode(l1.val);
                temp.next=p;
                temp=p;
                l1=l1.next;
            }
        }
        while (l1 != null){
            ListNode p = new ListNode(l1.val);
            temp.next=p;
            temp=p;
            l1=l1.next;
        }
        while (l2 != null){
            ListNode p = new ListNode(l2.val);
            temp.next=p;
            temp=p;
            l2=l2.next;
        }
        return newHead.next;
    }
}
