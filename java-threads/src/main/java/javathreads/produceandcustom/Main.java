package javathreads.produceandcustom;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author shengouqiang
 * @date 2020/6/2
 */
public class Main {

    @Test
    public void testOne(){
        List<Integer> container = new ArrayList<>();
        int count =3;
        Thread p1 = new Thread(()->{
            while (true){
                synchronized (container){
                    if(container.size() < count){
                        container.add(new Random().nextInt(100));
                        container.notify();
                    }
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"p1");
        Thread c1 = new Thread(()->{
            while (true){
                synchronized (container){
                    if(container.size() > 0){
                        System.out.println(container.size());
                        System.out.println(container.size() >= 4);
                        container.remove(0);
                        container.notify();
                    }
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"c1");

        p1.start();
        c1.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
