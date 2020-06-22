package offer.no16;

/**
 * @author shengouqiang
 * @date 2020/6/22
 */
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double result = 1;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * x;
            }
            x = x * x;
            b = b >>> 1;
        }
        return result;
    }
}
