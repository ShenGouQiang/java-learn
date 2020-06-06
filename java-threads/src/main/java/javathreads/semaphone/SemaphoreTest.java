package javathreads.semaphone;

import java.util.concurrent.Semaphore;

/**
 * @author shengouqiang
 * @date 2020/4/23
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        try{
            System.out.println(semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
          //  semaphore.acquire();
          //  System.out.println(semaphore.availablePermits());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
