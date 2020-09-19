package offer.no46;

import org.junit.Test;

public class Solution {

    @Test
    public void testOne() {
        System.out.println(translateNum(12258));
    }

    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        String str = String.valueOf(num);
        char[] strArray = str.toCharArray();
        int[] array = new int[str.length() + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= strArray.length; i++) {
            int val = (strArray[i - 1 - 1] - '0') * 10 + (strArray[i - 1] - '0');
            if (val >= 10 && val < 26) {
                array[i] = array[i - 1 - 1] + array[i - 1];
            } else {
                array[i] = array[i - 1];
            }
        }
        return array[array.length - 1];
    }
}
