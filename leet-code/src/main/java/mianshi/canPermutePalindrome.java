package mianshi;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * <p>
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * <p>
 * 回文串不一定是字典当中的单词。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author shengouqiang
 * @date 2020/5/14
 */
public class canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (null == charMap.get(s.charAt(i))) {
                charMap.put(s.charAt(i), 1);
            }else{
                charMap.remove(s.charAt(i));
            }
        }
        return charMap.values().stream().filter(i -> i%2 !=0).count() <= 1;
    }

    @Test
    public void testOne(){
        System.out.println(canPermutePalindrome("aab"));
        System.out.println(canPermutePalindrome("code"));

    }
}
