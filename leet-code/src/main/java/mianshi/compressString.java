package mianshi;

import org.junit.Test;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 *
 * @author shengouqiang
 * @date 2020/5/8
 */
public class compressString {

    @Test
    public void testOne(){
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abbccd"));
    }

    public String compressString(String S) {
        if(S.length() == 0 || S.length() ==1){
            return S;
        }
        StringBuffer sb = new StringBuffer("");
        int start=0,end=0;
        for(int i=0;i<S.length();i++,end++){
            if(S.charAt(start) != S.charAt(i)){
                sb.append(S.charAt(start)).append(i -start);
                start=i;
            }
        }
        sb.append(S.charAt(start)).append(end-start);
        String result = sb.toString();

        return result.length() > S.length() ? S : result;
    }
}
