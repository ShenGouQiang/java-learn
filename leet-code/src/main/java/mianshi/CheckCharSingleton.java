package mianshi;

import org.junit.Test;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author shengouqiang
 * @date 2020/5/8
 */
public class CheckCharSingleton {

    @Test
    public void tesetOne() {
        System.out.println("leetcode ---> " + isUnique("leetcode"));
        System.out.println("abc ---> " + isUnique("abc"));
    }

    public boolean isUnique(String astr) {
        if (astr.length() == 0 || astr.length() == 1) {
            return true;
        }
        for (int i = 0; i < astr.length(); i++) {
            if (i != astr.lastIndexOf(astr.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
