package javathreads.blockingqueue;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author shengouqiang
 * @date 2020/6/8
 */
public class LinkedBlockingQueueTest {

    @Test
    public void testOne(){
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
    }
}
