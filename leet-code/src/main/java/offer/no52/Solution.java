package offer.no52;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengouqiang
 * @date 2020/6/28
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode tempA = headA;
        while (tempA != null) {
            map.put(tempA.val, tempA);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            if (map.get(tempB.val) != null && map.get(tempB.val) == tempB) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
