package offer.no20;

import org.junit.Test;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean numFlag = false;
        boolean eFlag = false;
        boolean pointFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
            } else if (s.charAt(i) == '.') {
                if (pointFlag  || eFlag) {
                    return false;
                }
                pointFlag = true;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if(eFlag || !numFlag){
                    return false;
                }
                eFlag=true;
                numFlag=false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return numFlag;
    }

    public boolean isNumber1(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0;i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                numSeen = true;
            }else if(str[i] == '.'){
                //.之前不能出现.或者e
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e之前不能出现e，必须出现数
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(str[i] == '-' || str[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{//其他不合法字符
                return false;
            }
        }
        return numSeen;
    }

    @Test
    public void testOne() {
        System.out.println(isNumber("+100"));
        System.out.println(isNumber("5e2"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("3.1415926"));
        System.out.println(isNumber("0123"));
    }

    @Test
    public void testTwo() {
     //   System.out.println(isNumber("12e"));
     //   System.out.println(isNumber("1a3.14"));
     //   System.out.println(isNumber("1.2.3"));
   //     System.out.println(isNumber("+-5"));
        System.out.println(isNumber1("-1E-16"));
    //    System.out.println(isNumber("12e+5.4"));
    }
}
