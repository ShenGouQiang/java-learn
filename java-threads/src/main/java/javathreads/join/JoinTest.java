package javathreads.join;

/**
 *  join的测试
 */
public class JoinTest {
    public static void main(String[] args) {
        testJoin();
    }

    private static void testJoin() {
        Thread t1 = new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.print("A" + i  + "\t");
                if((i+1)%20 == 0){
                    System.out.println();
                }
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0;i<100;i++){
                System.out.print("B" + i  + "\t");
                if((i+1)%20 == 0){
                    System.out.println();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
