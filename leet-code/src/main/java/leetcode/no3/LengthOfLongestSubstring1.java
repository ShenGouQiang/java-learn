package leetcode.no3;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring1 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> indexMap = new HashMap<>();
        int start = -1;
        int max = 0;
        for (int i=0;i<s.length();i++){

            if(null != indexMap.get(s.charAt(i))){
                start = indexMap.get(s.charAt(i));
            }
            indexMap.put(s.charAt(i),i);
            max = Math.max(max,i -start);
        }
        return max;
    }
}
