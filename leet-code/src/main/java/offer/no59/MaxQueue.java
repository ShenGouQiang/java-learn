package offer.no59;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Deque<Integer> queue;
    private Deque<Integer> help;

    public MaxQueue() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public int max_value() {
        if (help.isEmpty()) {
            return -1;
        }
        return help.getLast();
    }

    public void push_back(int value) {
        queue.offerLast(value);
        if (!help.isEmpty() && help.peek() >= value) {
            help.offerLast(help.getLast());
        } else {
            help.offerLast(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        help.pollFirst();
        return queue.pollFirst();
    }

    public static void main(String[] args) {
        testOne();
        testTwo();
    }

    private static void testOne() {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        Assert.assertEquals(2, maxQueue.max_value());
        Assert.assertEquals(1, maxQueue.pop_front());
        Assert.assertEquals(2, maxQueue.max_value());
    }

    private static void testTwo() {
        MaxQueue maxQueue = new MaxQueue();
        Assert.assertEquals(-1, maxQueue.pop_front());
        Assert.assertEquals(-1, maxQueue.max_value());
    }
}
