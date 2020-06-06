package javathreads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author shengouqiang
 * @date 2020/4/22
 */
public class CycliBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(20,()->System.out.println("满20个，开始发车"));

        for (int i=0;i<103;i++){
            int finalI = i;
            new Thread(()-> {
                System.out.println("this thread name is thread-" + finalI);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"thread-"+i).start();
        }
    }
}
