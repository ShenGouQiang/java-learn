package javathreads.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author shengouqiang
 * @date 2020/4/23
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            System.out.println("A1 start ....");
            String str=null;
            try {
                str = exchanger.exchange("A1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("exchanger value:" + str);
            System.out.println("A1 end");
        }).start();

        new Thread(()->{
            System.out.println("B1 start ....");
            String str=null;
            try {
                str = exchanger.exchange("B1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("exchanger value:" + str);
            System.out.println("B1 end");
        }).start();
    }
}
