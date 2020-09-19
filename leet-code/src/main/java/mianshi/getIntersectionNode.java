package mianshi;

import org.junit.Test;

/**
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shengouqiang
 * @date 2020/5/9
 */
public class getIntersectionNode {

    @Test
    public void testOne() {
        ListNode headA = new ListNode(0);
        ListNode n1 = new ListNode(9);
        headA.next = n1;
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode n3 = new ListNode(2);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;

        ListNode headB = new ListNode(3);
        ListNode n11 = new ListNode(2);
        headB.next = n11;
        n11.next = n4;

        System.out.println(getIntersectionNode(headA, headB));


    }


    @Test
    public void testTwo() {
        ListNode headA = new ListNode(4);
        ListNode n1 = new ListNode(1);
        headA.next = n1;
        ListNode n2 = new ListNode(8);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;
        ListNode n4 = new ListNode(5);
        n3.next = n4;

        ListNode headB = new ListNode(5);
        ListNode n11 = new ListNode(0);
        headB.next = n11;
        ListNode n12 = new ListNode(1);
        n11.next = n12;
        n12.next = n2;

        System.out.println(getIntersectionNode(headA, headB));


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //做法一 ： 利用hash
//        Set<ListNode> alist = new HashSet<>();
//        while (headA != null) {
//            alist.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (alist.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
        //做法二：嵌套查询
//        while(headA != null){
//            ListNode tmp = headB;
//            while (tmp != null){
//                if(tmp == headA){
//                    return tmp;
//                }
//                tmp = tmp.next;
//            }
//            headA = headA.next;
//        }
//        return null;

        //做法三：利用a + b = b + a ，实现链表补齐，这样可以实现 比对
        if(headA == null || headB == null ){
            return null;
        }
        ListNode p1 =headA;
        ListNode p2 = headB;
        while (p1 != p2){
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
//        return null;
    }



}
