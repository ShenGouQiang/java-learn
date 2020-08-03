package mianshi.no1625;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        Node prev;
        int val;
        int key;
        Node next;
    }

    static class HeadNode extends Node {
        Node next;
        Node tail;
    }

    static class DoubleLinkedList {
        HeadNode head;

        public DoubleLinkedList() {
            head = new HeadNode();
        }

        public void addToHead(Node node) {
            if (head.next == null) {
                head.next = node;
                head.tail = node;
                node.prev = head;
            } else {
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
                node.prev = head;
            }
        }

        public void moveToHead(Node node) {
            if (node.prev == head) {
                return;
            }
            if (node == head.tail) {
                head.tail = node.prev;
                node.next = null;
                node.prev = null;
                addToHead(node);
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                addToHead(node);
            }
        }

        public Node getTailNode() {
            if (head.tail == null) {
                return null;
            }
            return head.tail;
        }

        public void removeToTail() {
            if (head.next == null) {
                return;
            }
            if (head.next == head.tail) {
                head.next = null;
                head.tail = null;
                return;
            }
            Node temp = head.tail.prev;
            head.tail.prev = null;
            head.tail = temp;
            head.tail.next = null;
        }
    }

    Map<Integer, Node> map;
    DoubleLinkedList head;
    int count;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cap = capacity;
        count = 0;
        head = new DoubleLinkedList();
    }

    public int get(int key) {
        Node temp = map.get(key);
        if (temp == null) {
            return -1;
        }
        int returnVal = temp.val;
        head.moveToHead(temp);
        return returnVal;
    }

    public void put(int key, int value) {
        if (map.get(key) == null) {
            Node node = new Node();
            node.key = key;
            node.val = value;
            if (count == cap) {
                Node removedNode = head.getTailNode();
                if (removedNode != null) {
                    map.remove(removedNode.key);
                }
                head.removeToTail();
                count--;
            }
            head.addToHead(node);
            map.put(key, node);
            count++;
        } else {
            Node node = map.get(key);
            node.val = value;
            head.moveToHead(node);
        }
    }


    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
    }

    private static void testThree() {
        LRUCache lruCache = new LRUCache(2);
        Assert.assertEquals(-1, lruCache.get(2));
        lruCache.put(2, 6);
        Assert.assertEquals(-1, lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        Assert.assertEquals(2, lruCache.get(1));
        Assert.assertEquals(6, lruCache.get(2));
    }


    private static void testTwo() {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        Assert.assertEquals(1, lruCache.get(2));
        lruCache.put(3, 2);
        Assert.assertEquals(-1, lruCache.get(2));
        Assert.assertEquals(2, lruCache.get(3));
    }

    private static void testOne() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        Assert.assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        Assert.assertEquals(-1, lruCache.get(2));
        lruCache.put(4, 4);
        Assert.assertEquals(-1, lruCache.get(1));
        Assert.assertEquals(3, lruCache.get(3));
        Assert.assertEquals(4, lruCache.get(4));
    }
}
