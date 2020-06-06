package mianshi;

import org.junit.Test;

/**
 * 面试题 02.08. 环路检测
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * @author shengouqiang
 * @date 2020/5/9
 */
public class DetectSingleNodeCycle {

    @Test
    public void test() {
        /*
          1 -> 2 -> 3 -> 4
               ∧          |
               |          ∨
               7 <- 6 <- 5
         */

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n2;
        ListNode head = n1;
        ListNode cutPointNode = detectCycle(head);
        System.out.println(cutPointNode == null ? null : cutPointNode.val);
    }
    @Test
    public void testOne(){
        /*
           1 -> 2
           ∧    |
           | -- |
         */
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        ListNode head = n1;
        ListNode cutPointNode = detectCycle(head);
        System.out.println(cutPointNode == null ? null : cutPointNode.val);
    }


    public ListNode detectCycle(ListNode head) {
//        ListNode firstMeetNode;
//        int cutPointToHeadLength = 0;
//        int cutPointToFirstMeetNodeLength = 0;
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode == null) {
                return null;
            }
            fastNode = fastNode.next;
            if (slowNode == fastNode) {
//                firstMeetNode = fastNode;
                fastNode = head;
                while (slowNode != null) {
                    if (fastNode == slowNode) {
//                        System.out.println("cut point to head length is " + cutPointToHeadLength);
//                        while (slowNode != firstMeetNode) {
//                            slowNode = slowNode.next;
//                            cutPointToFirstMeetNodeLength++;
//                        }
//                        System.out.println("link node cycle list length  is " + ((cutPointToFirstMeetNodeLength + cutPointToHeadLength) == 0 ? 2 : (cutPointToFirstMeetNodeLength + cutPointToHeadLength)));
                        return fastNode;
                    }
                    fastNode = fastNode.next;
                    slowNode = slowNode.next;
//                    cutPointToHeadLength++;
                }
            }

        }
        return null;
    }
}
