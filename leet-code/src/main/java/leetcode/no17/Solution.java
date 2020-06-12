package leetcode.no17;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 *
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @author shengouqiang
 * @date 2020/6/10
 */
public class Solution {



    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Integer,String>  map = new HashMap<>(8);
        map.put(0,"");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        dfs("",0,digits,result,map);
        return result;
    }

    public void dfs(String exited,int strIndex,String digits,List<String> result,Map<Integer,String> map){
        if(strIndex == digits.length() ){
            if(!"".equals(digits)){
                result.add(exited);
            }
            return;
        }
        int a = digits.charAt(strIndex) - '0';
        String charStr = map.get(a);
        if(charStr == null || "".equals(charStr)){
            return;
        }
        for (int i=0;i<charStr.length();i++){
            dfs(exited + charStr.charAt(i),strIndex+1,digits,result,map);
        }
    }

    @Test
    public void testOne(){
        System.out.println(letterCombinations(""));
    }
}
