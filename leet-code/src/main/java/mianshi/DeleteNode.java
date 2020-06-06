package mianshi;

import org.junit.Test;

/**
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * @author shengouqiang
 * @date 2020/5/26
 */
public class DeleteNode {

    @Test
    public void testOne(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        deleteNode(n3);
        ListNode head = n1;
        while (head != null){
            System.out.print(head.val + "\t");
            head=head.next;
        }
        System.out.println();
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        while (next != null){
            node.val=next.val;
            if(null != next.next){
                node = next;
            }
            next=next.next;
        }
        node.next=null;
    }
}
