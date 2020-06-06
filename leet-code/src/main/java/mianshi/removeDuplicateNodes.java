package mianshi;

import lombok.ToString;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * 提示：
 * <p>
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 * <p>
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * @author shengouqiang
 * @date 2020/5/8
 */
public class removeDuplicateNodes {

    @Test
    public void testOne(){
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        ListNode n5 = new ListNode(1);
        n4.next = n5;
        removeDuplicateNodes(head);
        print(head);
    }

    @Test
    public void testTwo(){
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(1);
        head.next = n1;
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode n3 = new ListNode(1);
        n2.next= n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        removeDuplicateNodes(head);
        print(head);
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode tmp = head;
        ListNode prev= head;
        while(null != tmp){
            if(!set.contains(tmp.val)){
                set.add(tmp.val);
                prev = tmp;
                tmp =tmp.next;
                continue;
            }
            prev.next = tmp.next;
            ListNode delNode = tmp;
            tmp =  tmp.next;
            delNode.next = null;

        }
        return head;
    }

    private void print(ListNode head){
        ListNode tmp = head;
        while(tmp != null){
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }
}

@ToString
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}