package leetcode.no9;


/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution {
    public boolean isPalindrome(int x) {
        return methodOne(x);
    }

    public boolean methodTwo(int x){
        int origin =x;
        if(x < 0){
            return false;
        }
        int a = 0;
        while (origin !=0){
            int tmp = origin %10;
            a= a * 10 + tmp;
            origin = origin/10;
        }
        if(x == a){
            return true;
        }
        return false;
    }

    public boolean methodOne(int x){
        char[] array = String.valueOf(x).toCharArray();
        int len = array.length;
        for(int i=0;i<len/2;i++){
            if(array[i] != array[len-i-1]){
                return false;
            }
        }
        return true;
    }
}
