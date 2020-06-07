package leetcode.no8;

import org.junit.Test;


public class Solution {

    @Test
    public void testOne(){
        System.out.println(myAtoi("42"));
    //    System.out.println(myAtoi("       -42"));
    //    System.out.println(myAtoi("       4093 asdfasdfasdfas"));
    }

    public int myAtoi(String str) {
        if(str == null || str.trim() == ""){
            return 0;
        }
        str = str.trim();
        char[] array = str.toCharArray();
        int index =0;
        boolean nagative = false;
        if(array[index] == '-'){
            nagative =true;
            index++;
        }else if (array[index] == '+'){
            index++;
        }else{
            if(!Character.isDigit(array[index])){
                return 0;
            }
        }
        int ans = 0;
        while (index < array.length && Character.isDigit(array[index])){
            int idx = array[index] -'0';
            if(ans > (Integer.MAX_VALUE -idx) /10){
                return nagative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans =ans * 10 + idx;
            index ++;
        }
        return nagative ? -ans : ans;
    }
}
