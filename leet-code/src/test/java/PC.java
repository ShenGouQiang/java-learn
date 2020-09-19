import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PC {

    AtomicInteger count = new AtomicInteger();

    public void produce() {
       int size =0;
        while (size < 10){
            if(count.get() % 2 ==0){
                System.out.println(Thread.currentThread().getName() + "---->" +count.get());
                count.incrementAndGet();
                size++;
            }
        }
    }


    public void consume(){
        int size =0;
        while (size < 10){
            if(count.get() % 2 ==1){
                System.out.println(Thread.currentThread().getName() + "---->" +count.get());
                count.incrementAndGet();
                size++;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
       PC p = new PC();

       Thread t1 = new Thread(()->{
          p.produce();
       },"t1");


        Thread t2 = new Thread(()->{
           p.consume();
        },"t2");

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
