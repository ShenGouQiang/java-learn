package bytes.dance;

import org.junit.Test;

/**
 *给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 *
 * @author shengouqiang
 * @date 2020/5/7
 */
public class StringMultiplication {

    @Test
    public void test(){
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1,num2));
    }

    public static final String ZERO_NUM_STR="0";

    public String multiply(String num1, String num2) {
        if(ZERO_NUM_STR.equals(num1) || ZERO_NUM_STR.equals(num2)){
            return ZERO_NUM_STR;
        }
        int[] array = new int[num1.length() + num2.length()];
        for (int i=num1.length() - 1;i>=0;i--){
            for (int j=num2.length() - 1;j >=0 ;j--){
                int realIndex = i + j +1;
                int n1 =num1.charAt(i) -'0';
                int n2 =  num2.charAt(j) -'0';
                int result = n1 * n2;
                arrayAddNum(array,result,realIndex);
            }
        }
        StringBuffer buffer = new StringBuffer("");
        for(int i = 0;i<array.length;i++){
            buffer.append(array[i]);
        }
        return buffer.toString().replaceAll("^(0*)([1-9]*)","$2");
    }

    public void arrayAddNum(int[] array,int result,int realIndex){
        while (true){
            int realValue = array[realIndex];
            int dev = (realValue + result) /10;
            int mo = (realValue + result) %10;
            if(dev > 0){
                array[realIndex]= mo;
                result = dev;
                realIndex --;
            }else{
                array[realIndex]= mo;
                break;
            }
        }
    }


}
