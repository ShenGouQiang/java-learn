package mianshi;

import org.junit.Test;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 *  
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shengouqiang
 * @date 2020/5/8
 */
public class NodeisPalindrome {

    @Test
    public void testOne(){
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(1);
        n2.next = n3;
        System.out.println(isPalindrome(head));
    }

    @Test
    public void testTwo(){
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        System.out.println(isPalindrome(head));
    }



    private void print(ListNode head){
        ListNode tmp = head;
        while(tmp != null){
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null ){
            return true;
        }
        ListNode reverserHead = reverseNode(getNewListNode(head));
        while(head != null){
            if(head.val != reverserHead.val){
                return false;
            }
            head = head.next;
            reverserHead = reverserHead.next;
        }
        return true;
    }

    /**
     * 复制新的链表
     * @param head
     * @return
     */
    public ListNode getNewListNode(ListNode head){
        if(head == null){
            return null;
        }
        ListNode reverseNode = new ListNode(head.val);
        ListNode reverseTmp = reverseNode;
        head = head.next;
        while(head != null){
            ListNode tmpNode = new ListNode(head.val);
            reverseTmp.next = tmpNode;
            reverseTmp = reverseTmp.next;
            head = head.next;
        }
        return reverseNode;

    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head){
        ListNode oldHead = head;
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        while(next != null){
            ListNode tmp = next;
            next=next.next;
            tmp.next = head;
            head = tmp;
        }
        oldHead.next=null;
        return head;
    }


}