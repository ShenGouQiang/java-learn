package datastructure.linklist.operate;

import datastructure.linklist.node.SingletonNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * using singleton link list to achive a LRU algorithm
 *
 * @author shengouqiang
 * @date 2020/3/25
 */
public class LRUBySingletonLinkList {

    /**
     * Randomly generate a list connection with listSize,
     * and minNum is the mininum value of the list and must be greater than zero,
     * and maxNum is the maxnum value of the list and must be greater than zero
     *
     * @param listSize the size of the list connection
     * @param minNum   the mininum value of the list connection
     * @param maxNum   the maxnum value of the list connection
     * @return
     */
    public static List<Integer> randomIntegerList(Integer listSize, Integer minNum, Integer maxNum) {
        if (listSize <= 0) {
            throw new RuntimeException("the size of the list connection must be greater than zero");
        }
        if (minNum < 0) {
            throw new RuntimeException("the mininum of the list connection must be greater than zero");
        }
        if (maxNum < 0) {
            throw new RuntimeException("the maxnum of the list connection must be greater than zero");
        }
        if (maxNum < minNum) {
            throw new RuntimeException("the maxNum must be greater than minNum");
        }
        int sub = maxNum - minNum;
        List<Integer> result = new ArrayList<>(realListCapacity(listSize));
        for (int i = 0; i < listSize; i++) {
            result.add(new Random().nextInt(sub + 1) + minNum);
        }
        return result;
    }

    /**
     * Returns a power of two size for the given target capacity.
     *
     * @param originCapacity
     * @return
     */
    public static Integer realListCapacity(Integer originCapacity) {
        int n = originCapacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }

    /**
     * achive the LRU algorithm
     *
     * @param readList    random List
     * @param LRUCacheNum LRU CacheNum
     * @return
     */
    public static SingletonNode<Integer> getLinkListByLRU(List<Integer> readList, Integer LRUCacheNum) {
        SingletonNode<Integer> head = new SingletonNode<>();
        readList.forEach(i -> {
            if (checkValueIsContainedByLinkList(head, i)) {
                swapTheValueToHead(head, i);
            } else {
                if (getLinkListSize(head) >= LRUCacheNum) {
                    deleteLastNode(head);
                    swapTheValueToHead(head, i);
                } else {
                    swapTheValueToHead(head, i);
                }
            }
            showList(head);
        });
        return head;
    }

    /**
     * get the size of the link connection
     *
     * @param head
     * @return
     */
    private static Integer getLinkListSize(SingletonNode<Integer> head) {
        SingletonNode<Integer> tmp = head;
        int size = 0;
        while (!Objects.isNull(tmp)) {
            size++;
            tmp = tmp.getNext();
        }
        return size;
    }

    /**
     * Determines whether this value exists in the current collection
     *
     * @return
     */
    private static Boolean checkValueIsContainedByLinkList(SingletonNode<Integer> head, Integer value) {
        SingletonNode<Integer> tmp = head;
        while (!Objects.isNull(tmp)) {
            if (Objects.equals(tmp.getData(), value)) {
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    /**
     * delete the last one of the list value
     *
     * @param head
     */
    private static void deleteLastNode(SingletonNode<Integer> head) {
        SingletonNode<Integer> tmp = head;
        SingletonNode<Integer> tmpPrev = null;
        while (!Objects.isNull(tmp.getNext())) {
            tmpPrev = tmp;
            tmp = tmp.getNext();
        }
        tmpPrev.setNext(null);
    }


    /**
     * change the target value to the head
     *
     * @param head
     * @param value
     */
    private static void swapTheValueToHead(SingletonNode<Integer> head, Integer value) {
        SingletonNode<Integer> tmpValue = new SingletonNode<>();
        tmpValue.setData(value);
        SingletonNode<Integer> tmp = head;
        tmpValue.setNext(tmp.getNext());
        tmp.setNext(tmpValue);
        tmp = tmpValue.getNext();
        SingletonNode<Integer> tmpPrev = tmpValue;
        while (!Objects.isNull(tmp)) {
            if (Objects.equals(tmp.getData(), value)) {
                tmpPrev.setNext(tmp.getNext());
                return;
            }
            tmpPrev = tmp;
            tmp = tmp.getNext();
        }
    }

    /**
     * print the link list
     *
     * @param head
     */
    private static void showList(SingletonNode<Integer> head) {
        SingletonNode<Integer> tmp = head;
        while (!Objects.isNull(tmp)) {
            if (Objects.isNull(tmp.getData())) {
                tmp = tmp.getNext();
                continue;
            }
            System.out.print(tmp.getData() + "\t");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> randomReadList = randomIntegerList(20, 1, 10);
        System.out.println(randomReadList);
        SingletonNode<Integer> head = getLinkListByLRU(randomReadList, 4);

    }
}
