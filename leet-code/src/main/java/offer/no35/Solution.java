package offer.no35;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node tempHead = head;
        Map<Node, Node> map = new HashMap<>();
        while (tempHead != null) {
            map.put(tempHead, new Node(tempHead.val));
            tempHead = tempHead.next;
        }
        Node returnNode = map.get(head);
        Node tempReturn = returnNode;
        tempHead = head;
        while (tempHead != null) {
            tempReturn.next = map.get(tempHead.next);
            tempReturn.random = map.get(tempHead.random);
            tempHead = tempHead.next;
            tempReturn = tempReturn.next;
        }
        return returnNode;
    }


}
