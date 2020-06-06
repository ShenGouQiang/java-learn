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
        Object obj = new Object();
        List<Integer> container = new ArrayList<>();
        int count =3;
        Thread p1 = new Thread(()->{
            while (true){
                synchronized (obj){
                    if(container.size() < count){
                        container.add(new Random().nextInt(100));
                        obj.notify();
                    }
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"p1");
        Thread c1 = new Thread(()->{
            while (true){
                synchronized (obj){
                    if(container.size() > 0){
                        System.out.println(container.get(0));
                        container.remove(0);
                        obj.notify();
                    }
                    try {
                        obj.wait();
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
