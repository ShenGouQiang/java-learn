package javathreads.reentrantlooks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author shengouqiang
 * @date 2020/4/27
 */
public class ReenTrantLockTest {
    public static void main(String[] args) {
        ReentrantLock c = new ReentrantLock(true);
        c.lock();
        try{
            System.out.println("hahahahaha ......");
        }finally {
            c.unlock();
        }

        ReadWriteLock rwc = new ReentrantReadWriteLock();
        Lock readLock = rwc.readLock();
        Lock writeLock = rwc.writeLock();

        new Thread(()->{
            c.lock();
        },"t1").start();
        new Thread(()->{
            c.lock();
        },"t2").start();
        new Thread(()->{
            c.lock();
        },"t3").start();
        new Thread(()->{
            c.lock();
        },"t4").start();
        new Thread(()->{
            c.lock();
        },"t5").start();
    }



}
