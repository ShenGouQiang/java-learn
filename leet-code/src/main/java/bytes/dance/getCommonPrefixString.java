package bytes.dance;

import java.util.Objects;

/**
 * @author shengouqiang
 * @date 2020/5/6
 */
public class getCommonPrefixString {
    public static void main(String[] args) {
       // String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String maxPrefix = "";
        if(Objects.isNull(strs) || 0 ==  strs.length){
            return "";
        }
        if(1 == strs.length){
            return strs[0];
        }
        maxPrefix = getMaxPrefixStr(strs[0],strs[1]);
        for(int i=2;i<strs.length;i++){
            maxPrefix = getMaxPrefixStr(maxPrefix,strs[i]);
            if( "".equals(maxPrefix)){
                break;
            }
        }
        return maxPrefix;
    }

    public static String getMaxPrefixStr(String comPrefix,String s1){
        char[] comArray = comPrefix.toCharArray();
        char[] s1Array = s1.toCharArray();
        int maxCommonIndex = -1;
        for(int i=0;i<Math.min(comArray.length,s1Array.length);i++){
            if(comArray[i] == s1Array[i]){
                maxCommonIndex++;
                continue;
            }
            break;
        }
        return -1 == maxCommonIndex ? "" : comPrefix.substring(0,maxCommonIndex +1);
    }
}
