package datastructure.others;

/**
 * @author shengouqiang
 * @date 2020/5/25
 */
public class TestOne {

    public static void main(String[] args) {
        //int[] array = {7, 7, 9, 4, 4, 9, 9, 12, 5, 6, 6, 6, 5, 12};
       // int[] result = singleNumbers(array);
       // System.out.println(result[0]);
       // System.out.println(result[1]);
        int[] array = {3,4,3,3};
        System.out.println(singleNumber(array));
    }

    public static int singleNumber(int[] nums) {
        int sum = 0;
        int k = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] & k) == k ? 1 : 0;
            }
            sum = sum | ((count % 3) << i);
            k = k << 1;
        }
        return sum;
    }


    public static int[] singleNumbers(int[] nums) {
        int err = 0;
        for (int i = 0; i < nums.length; i++) {
            err = err ^ nums[i];
        }
        int err1 = err & (~err + 1);
        int err2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & err1) == 0) {
                err2 = err2 ^ nums[i];
            }
        }
        int[] result = {err2, err ^ err2};
        return result;
    }
}
