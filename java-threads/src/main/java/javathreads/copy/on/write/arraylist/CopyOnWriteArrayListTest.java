package javathreads.copy.on.write.arraylist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author shengouqiang
 * @date 2020/5/12
 */
public class CopyOnWriteArrayListTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person{
        private String name;
        private int age;
    }

    private List<Person> originPersonList = new CopyOnWriteArrayList<>();

    @Before
    public void prepare(){
        for (int i=0;i<3;i++){
            originPersonList.add(new Person(String.valueOf(new Random().nextInt(20) + 'a'),new Random().nextInt(100)));
        }
    }

    @Test
    public void testOne() throws InterruptedException {
        System.out.println("init data start .......................");
        System.out.println(originPersonList);
        System.out.println("init data end .......................");
        TimeUnit.SECONDS.sleep(2);


        Thread t1 = new Thread(()->{
            for (int i=0;i<100;i++){
                originPersonList.add(new Person(String.valueOf(new Random().nextInt(20) + 'a'),new Random().nextInt(100)));
                System.out.println("t1 --->" + originPersonList);
            }
        },"t1");

        Thread t2 = new Thread(()->{
            for (int i=0;i<100;i++){
                originPersonList.remove(0);
                System.out.println("t2 --->" + originPersonList);
            }
        },"t2");


        t1.start();
        t2.start();
    }
}


