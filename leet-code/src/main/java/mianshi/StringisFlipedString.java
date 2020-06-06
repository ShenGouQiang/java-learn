package mianshi;

import org.junit.Test;

/**
 *
 *
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 *
 * @author shengouqiang
 * @date 2020/5/8
 */
public class StringisFlipedString {

    @Test
    public void testTwo(){
        String s1= "rxOpSEXvfIuoRJfjwgwuomevMMBOfeSMvYSPBaovrZBSgmCrSLDirNnILhARNShOYIFBHIRiFKHtfxWHjawaLRAEYPIZokUKgiqyZpvcOHdfPpRqHADKAXzEfzhxdXXb";
        String s2="";
        s1+=s1;
        System.out.println(s1.contains(s2) && !"".equals(s2));
    }

    @Test
    public void testOne(){
        System.out.println(isFlipedString("waterbottle","erbottlewat"));
        System.out.println(isFlipedString("aa","aba"));
    }

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int[] s1Array = new int[58];
        int[] s2Array = new int[58];
        for(int i=0;i<s1.length();i++){
            s1Array[s1.charAt(i)-'A']++;
            s2Array[s2.charAt(i)-'A']++;
        }
        for (int i=0;i<s1Array.length;i++){
            if(s2Array[i] != s1Array[i]){
                return false;
            }
        }
        return true;
    }
}
