package mianshi;

import java.util.ArrayList;
import java.util.List;

public class MianShi_02 {

    private volatile List<Integer> integerContainer = new ArrayList<>(16);

    public void add(Integer integer){
        integerContainer.add(integer);
    }

    public Integer size(){
        return integerContainer.size();
    }

    public static void main(String[] args) {
        MianShi_02 mianShi_02 = new MianShi_02();
        Object lock = new Object();

        Thread a = new Thread(()->{
            synchronized (lock){
                for (int i=0;i<10;i++){
                    System.out.println(i);
                    mianShi_02.add(i);
                    if(mianShi_02.size() == 5){
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread b = new Thread(()->{
            synchronized (lock){
                if(mianShi_02.size() != 5){
                    try {
                        lock.wait();
                        System.out.println("满了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        });

        b.start();
        a.start();
    }
}
