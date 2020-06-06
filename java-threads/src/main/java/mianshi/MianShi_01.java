package mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 实现一个容器，提供两个方法  add size
 * 写两个线程
 * 线程1：往容器添加10个元素
 * 线程2: 监控容器，当容器的个数为5时，提示，并结束
 */
public class MianShi_01 {

    static Thread a = null;
    static Thread b = null;


    private List<Integer> integerContainer = new ArrayList<>(16);

    public void add(Integer integer){
        integerContainer.add(integer);
    }

    public Integer size(){
        return integerContainer.size();
    }

    public static void main(String[] args) {
        MianShi_01 mianShi_01 = new MianShi_01();
        a = new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(i);
                mianShi_01.add(i);
                if(mianShi_01.size() == 5){
                    System.out.println(b);
                    LockSupport.unpark(b);
                    LockSupport.park();
                }
            }
        });

        b = new Thread(()->{
            if(mianShi_01.size() != 5){
                LockSupport.park();
            }
            LockSupport.unpark(a);
        });

        b.start();
        a.start();
    }
}
