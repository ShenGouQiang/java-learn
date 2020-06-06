package mianshi.alternately.print.charandnumber;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 *   交替打印 A 1 B 2 。。。。
 *
 *   采用synchronized + wait + notify 解法
 *
 *
 * @author shengouqiang
 * @date 2020/4/29
 */
public class MianShi_05 {

    public static final List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);

    public static final List<String> characterList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        new Thread(()->{
            for(Integer i : numberList){
                synchronized (lock){
                    System.out.print(i + "\t");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },"t1").start();

        TimeUnit.SECONDS.sleep(4);

        new Thread(()->{
            for(String c : characterList){
                synchronized (lock){
                    System.out.println(c);
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },"t2").start();
    }
}
