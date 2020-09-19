package mianshi.alternately.print.charandnumber;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * 交替打印 A 1 B 2 。。。。
 *
 * 采用LockSupport解法
 *
 * @author shengouqiang
 * @date 2020/4/28
 */
public class MianShi_04 {

    public static final List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);

    public static final List<String> characterList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) throws InterruptedException {

        t1 = new Thread(()->{
            for (Integer i : numberList){
                System.out.print(i + "\t");
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(()->{
            int count =0;
            for (String c : characterList){

                System.out.println(c);
                count++;
                LockSupport.unpark(t1);
                if(count < characterList.size()){
                    LockSupport.park();
                }
            }
        });

        t1.start();
        TimeUnit.SECONDS.sleep(5);
        t2.start();
    }
}
