package offer.no15;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
