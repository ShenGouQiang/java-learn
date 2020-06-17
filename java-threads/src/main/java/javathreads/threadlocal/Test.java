package javathreads.threadlocal;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 验证 InheritableThreadLocal 与  线程池不能共用的问题
 *
 * @author shengouqiang
 * @date 2020/6/12
 */
public class Test {

   static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

   static class A implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            threadLocal.set("A");
            ExecutorService executorService = Executors.newFixedThreadPool(3);
            for (int i=0;i<100;i++){ori

                executorService.submit(new B());
            }
            executorService.shutdown();
            System.out.println(Thread.currentThread().getId() + "--->A--->"+ threadLocal.get());
            threadLocal.remove();
        }
    }


   static class B implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId() + "--->B--->"+ threadLocal.get());
            threadLocal.remove();
        }
    }

    public static void main(String[] args){
        for (int  i=0;i<1; i++){
            new Thread(new A(),"a1").start();
        }

    }

}




