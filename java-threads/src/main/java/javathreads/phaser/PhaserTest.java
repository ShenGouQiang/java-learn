package javathreads.phaser;

import lombok.AllArgsConstructor;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new MarryPhaser();
        phaser.bulkRegister(10);
        for(int i=0;i<8;i++){
            int finalI = i;
            new Thread( new Person("姓名" + finalI , phaser)).start();
        }
        new Thread(new Person("新郎" , phaser)).start();
        new Thread(new Person("新娘" , phaser)).start();
    }
}



class MarryPhaser extends Phaser{

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase){
            case 0:
                System.out.println("当前线程-->"+Thread.currentThread().getId() + " ,所有人员已经到达");
                return false;
            case 1:
                System.out.println("当前线程-->"+Thread.currentThread().getId() + " ,所有人员已经吃完");
                return false;
            case 2:
                System.out.println("当前线程-->"+Thread.currentThread().getId() + " ,所有人员已经拥抱");
                return true;
            default:
                System.out.println("当前线程-->"+Thread.currentThread().getId() + " ,所有人员都执行完了默认方法");
                return true;
        }
    }
}


@AllArgsConstructor
class Person implements Runnable{

    private String name;

    private Phaser phaser;


    private void millisSleep(Long millis){
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void randomSleep(){
     //   millisSleep(new Random(10000).nextInt() + 5000L);
    }

    private void show(String info){
        System.out.println("当前线程-->"+Thread.currentThread().getId() + "，姓名是：" +name + " "+ info);
    }

    private void arrive(){
        show("已经到达现场");
        randomSleep();
        phaser.arriveAndAwaitAdvance();
    }

    private void eat(){
        show("已经开始吃饭");
        randomSleep();
        phaser.arriveAndAwaitAdvance();
    }

    private void hug(){
        if("新郎".equals(name) || "新娘".equals(name)){
            show("已经开始洞房");
            randomSleep();
            phaser.arriveAndAwaitAdvance();
        }else{
            phaser.arriveAndDeregister();
        }
    }


    @Override
    public void run() {
        arrive();
        eat();
        hug();
    }
}
