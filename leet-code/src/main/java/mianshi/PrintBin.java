package mianshi;

import org.junit.Test;

/**
 * @author shengouqiang
 * @date 2020/5/29
 */
public class PrintBin {


    @Test
    public void testOne() {
        System.out.println(printBin(0.625));
        System.out.println(printBin(0.1));
    }

    public String printBin(double num) {
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }
        StringBuffer buffer = new StringBuffer("0.");
        boolean errorFlag = true;
        for (int i = 0; i < 32; i++) {
            num = num * 2;
            int a = (int) (num / 1);
            num = num > 1 ? num - 1 : num;
            buffer.append(a);
            if (num == 1) {
                errorFlag = false;
                break;
            }
        }
        if (errorFlag) {
            return "ERROR";
        }
        return buffer.toString();
    }
}
