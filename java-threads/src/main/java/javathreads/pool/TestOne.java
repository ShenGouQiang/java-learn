package javathreads.pool;

/**
 *
 *
 * @author shengouqiang
 * @date 2020/4/23
 */
public class TestOne {
    public static void main(String[] args) {
//        Executors.newSingleThreadExecutor();
//        Executors.newFixedThreadPool(10);
//        Executors.newCachedThreadPool();
        System.out.println(Integer.MAX_VALUE);
        int num = (int) (Math.pow(2,31) -1);
        System.out.println(num);


        System.out.println(Integer.SIZE);
    }
}
