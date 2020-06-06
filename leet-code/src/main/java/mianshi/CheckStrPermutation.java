package mianshi;

import org.junit.Test;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 *
 * @author shengouqiang
 * @date 2020/5/8
 */
public class CheckStrPermutation {

    @Test
    public void testOne(){
        System.out.println(CheckPermutation("abc","bca"));
        System.out.println(CheckPermutation("abc","bad"));
    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        for (int i=0;i<s1.length();i++){
            s1Array[s1.charAt(i)-'a']++;
            s2Array[s2.charAt(i)-'a']++;
        }
        return checkTwoArrayEqual(s1Array,s2Array);
    }

    private boolean checkTwoArrayEqual(int[] arr1,int[] arr2){
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
