package javathreads.threadlocals;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author shengouqiang
 * @date 2020/4/28
 */
public class ThreadLocalTest {

    public static ThreadLocal<Person> threadLocal = new ThreadLocal<>();

    public static ThreadLocal<Person> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            CarInfo car = new CarInfo();
            car.setSkuId("11");
            car.setColor("red");
            Person person = new Person();
            person.setCarInfo(car);
            person.setName("shen");
            inheritableThreadLocal.set(person);
            System.out.println(inheritableThreadLocal);
            System.out.println(threadLocal);
            Person person1 = new Person();
            person1.setName("wang");
            person1.setCarInfo(car);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(()->{
                System.out.println("hash--i--->" + inheritableThreadLocal);
                System.out.println("hash--t--->" + threadLocal);
                System.out.println("i1-->"+inheritableThreadLocal.get());
                System.out.println("t1-->"+threadLocal.get());
            }).start();

            inheritableThreadLocal.remove();
            threadLocal.remove();
        },"t1").start();

    }
}


@Data
class Person {
    private String name;

    private CarInfo carInfo;
}

@Data
class CarInfo{
    private String skuId;

    private String color;
}
