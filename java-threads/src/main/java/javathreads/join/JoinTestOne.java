package javathreads.join;

import lombok.Setter;
import lombok.SneakyThrows;

/**
 * @author shengouqiang
 * @date 2020/4/15
 */
public class JoinTestOne {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB  b = new ThreadB();
        a.setThreadB(b);
        b.setThreadA(a);
        a.start();
        b.start();

    }
}

@Setter
class ThreadA extends Thread{

    ThreadB threadB;

    @SneakyThrows
    @Override
    public void run(){
        try{
            threadB.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


@Setter
class ThreadB extends Thread{

    ThreadA threadA;

    @Override
    public void run(){
        try{
            threadA.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
