package datastructure.lru;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * LRU算法实现
 */
public class LruAlgorithm<T> {

    private Integer capacity;

    private Map<T, Node<T>> valueMap;

    private Node<T> head;

    public LruAlgorithm(Integer capacity) {
        this.capacity = capacity;
        this.valueMap = new HashMap<>();
        this.head = new Node<>();
    }

    public T getValue(T t) {
        if (Objects.isNull(valueMap) || Objects.isNull(valueMap.get(t))) {
            return null;
        }
        changeLocation(t);
        showLinkList();
        return t;
    }

    public Node<T> setValue(T t) {
        if (Objects.isNull(valueMap.get(t))) {
            if (capacity <= valueMap.size()) {
                replaceNode(t);
            } else {
                addNode(t);
            }
        } else {
            changeLocation(t);
        }
        showLinkList();
        return head;
    }

    public Node<T> lruOperate(T[] array) {
        if (Objects.isNull(array) || 0 == array.length) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            setValue(array[i]);
        }
        return head;
    }

    private void addNode(T value) {
        Node<T> tmp = new Node<>();
        tmp.setValue(value);
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) {
            head.setNext(tmp);
            head.setPrev(tmp);
            tmp.setPrev(head);
        } else {
            head.getPrev().setNext(tmp);
            tmp.setPrev(head.getPrev());
            head.setPrev(tmp);
        }
        valueMap.put(value, tmp);
    }

    private void replaceNode(T value) {
        Node<T> tmp = new Node<>();
        tmp.setValue(value);
        valueMap.remove(value);
        Node<T> firstNode = head.getNext();
        head.setNext(firstNode.getNext());
        firstNode.getNext().setPrev(head);
        addNode(value);
    }

    private void changeLocation(T value) {
        Node<T> queryNode = valueMap.get(value);
        if (head.getPrev().equals(queryNode)) {
            return;
        }
        valueMap.remove(value);
        queryNode.getPrev().setNext(queryNode.getNext());
        queryNode.getNext().setPrev(queryNode.getPrev());
        addNode(value);
    }

    public void showLinkList() {
        Node<T> tailNode = head.getPrev();
        while (!Objects.isNull(tailNode) && !Objects.isNull(tailNode.getValue())) {
            System.out.print(tailNode.getValue() + "\t");
            tailNode = tailNode.getPrev();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array = {10, 4, 6, 8, 7, 4, 10, 5};
        LruAlgorithm<Integer> lru = new LruAlgorithm<>(5);
        System.out.println("------------------start lru ------------------");
        lru.lruOperate(array);
        System.out.println("------------------end lru ------------------");
        System.out.println("------------------start get ------------------");
        Integer value = lru.getValue(1);
        System.out.println("value = " + value);
        lru.getValue(4);
        System.out.println("------------------end get ------------------");
        System.out.println("------------------start set ------------------");
        lru.setValue(1);
        System.out.println("----------------------------------------------");
        lru.setValue(10);
        System.out.println("------------------end set ------------------");
    }
}
