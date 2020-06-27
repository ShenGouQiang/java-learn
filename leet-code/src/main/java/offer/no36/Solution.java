package offer.no36;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    @Test
    public void testOne() {
        Node n4 = new Node(4);
        Node n2 = new Node(2);
        Node n5 = new Node(5);
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        n4.left=n2;
        n4.right=n5;
        n2.left=n1;
        n2.right=n3;
        Node temp = treeToDoublyList(n4);
        System.out.println(temp);
    }


    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return result;
    }

    Node prev = null;
    Node result = null;
    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if(prev != null){
            prev.right= root;
        }else{
            result= root;
        }
        root.left = prev;
        prev= root;
        dfs(root.right);
    }


}
