package javathreads.volatiles;

public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        VolatileTest v = new VolatileTest();
        new Thread(v::running,"t1").start();
        Thread.sleep(5000);
        v.flag=false;
        v.s = 1;
    }


    boolean flag = true;

   volatile  int s = 0;

    public void running(){
        System.out.println("running start");
        while(s <1){
        }
        System.out.println("running end");
    }
}
