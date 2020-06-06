package mianshi;

import org.junit.Test;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shengouqiang
 * @date 2020/5/26
 */
public class AddTwoNumbers {

    @Test
    public void testOne() {
        ListNode n17 = new ListNode(7) ;
        ListNode n11 = new ListNode(1) ;
        ListNode n16 = new ListNode(6) ;
        n17.next=n11;
        n11.next=n16;

        ListNode n25 = new ListNode(5) ;
        ListNode n29 = new ListNode(9) ;
        ListNode n22 = new ListNode(2) ;
        n25.next=n29;
        n29.next=n22;

        ListNode result = addTwoNumbers(n17,n25);
        while (result != null){
            System.out.print(result.val + "\t");
            result=result.next;
        }
        System.out.println();
    }

    @Test
    public void testTwo(){
        ListNode n17 = new ListNode(7) ;
        ListNode n11 = new ListNode(1) ;
        ListNode n16 = new ListNode(6) ;
        n17.next=n11;
        n11.next=n16;

        ListNode result = reverse(n17);
        while (result != null){
            System.out.print(result.val + "\t");
            result=result.next;
        }
        System.out.println();
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 链表翻转
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode prev = null;
        while (next != null){
            next = head.next;
            head.next=prev;
            prev = head;
            if(null != next){
                head = next;
            }
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode head = null;
        int mark = 0;
        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            int current = (a + b + mark) % 10;
            mark = (a + b + mark) / 10;
            if (null == head) {
                result = new ListNode(current);
                head = result;
            } else {
                ListNode tmp = new ListNode(current);
                result.next = tmp;
                result = tmp;
            }
            l1=l1.next;
            l2=l2.next;
        }
        while (l1 != null) {
            int a = l1.val;
            int current = (a + mark) % 10;
            mark = (a + mark) / 10;
            if (null == result) {
                result = new ListNode(current);
                head = result;
            } else {
                ListNode tmp = new ListNode(current);
                result.next = tmp;
                result = tmp;
            }
            l1=l1.next;
        }

        while (l2 != null) {
            int a = l2.val;
            int current = (a + mark) % 10;
            mark = (a + mark) / 10;
            if (null == result) {
                result = new ListNode(current);
                head = result;
            } else {
                ListNode tmp = new ListNode(current);
                result.next = tmp;
                result = tmp;
            }
            l2=l2.next;
        }
        if (mark > 0) {
            ListNode tmp = new ListNode(mark);
            result.next = tmp;
        }
        return head;
    }
}
