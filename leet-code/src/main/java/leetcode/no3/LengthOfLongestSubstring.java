package leetcode.no3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author shengouqiang
 * @date 2020/4/2
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s= "abba";
        int max = cal(s);
        System.out.println(max);
    }

    public static int cal(String s){
        int max=0;
        if(Objects.isNull(s)){
            return max;
        }
        Map<Character,Integer> charMap = new HashMap<>(s.length());
        char[] charArray = s.toCharArray();
        int start = 0;
        for(int i=0;i< charArray.length;i++){
            if(Objects.nonNull(charMap.get(charArray[i]))){
                start = Math.max(charMap.get(charArray[i]),start);
            }
            charMap.put(charArray[i],i+1);
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
