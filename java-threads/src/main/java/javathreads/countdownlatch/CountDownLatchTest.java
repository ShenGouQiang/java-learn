package javathreads.countdownlatch;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author shengouqiang
 * @date 2020/4/21
 */

public class CountDownLatchTest {

    @Test
    public void testOne() {
        System.out.println("main cout down latch start");
        Thread[] threadArray = new Thread[100];
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new Thread(() -> {
                int sleepSecond = new Random().nextInt(10) * 1000;
                try {
                    System.out.println(Thread.currentThread().getId() + " --- " + sleepSecond);
                    Thread.sleep(sleepSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println(Thread.currentThread().getId() + " --- " + sleepSecond + " ---- " + latch.getCount());
            });
        }
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i].start();
            try {
                int sleepSecond = new Random().nextInt(10) * 1000;
                System.out.println(Thread.currentThread().getId() + " --- " + sleepSecond);
                Thread.sleep(sleepSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main cout down latch end");
    }
}


