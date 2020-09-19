package leetcode.no5;

import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * 通过次数289,105提交次数942,396
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shengouqiang
 * @date 2020/6/9
 */
public class Solution {

    @Test
    public void testOne() {
        System.out.println(resolveByForce("babad"));
    }

    @Test
    public void testTwo() {
        System.out.println(resolveByDp("bb"));
    }

    @Test
    public void testThree() {
        System.out.println(longestPalindrome("bb"));
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        boolean[][] dp = new boolean[array.length][array.length];
        int startIndex = 0;
        int maxLength = 1;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (array[i] == array[j]) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        print(dp);
        return s.substring(startIndex, startIndex + maxLength);
    }


    public String resolveByDp(String s) {
        int len = s.length();
        if (s.length() < 2) {
            return s;
        }
        int maxLen = 1;
        int startIndex = 0;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (i - j < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
                if (dp[i][j] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    startIndex = j;
                }
            }
        }
        print(dp);
        return s.substring(startIndex, startIndex + maxLen);
    }


    public void print(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] ? "T" : "F");
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println();
    }


    /**
     * 通过暴力破解的方式，来解决问题
     *
     * @param s
     * @return
     */
    public String resolveByForce(String s) {
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1 > maxLength && verificationPalindrome(s, i, j)) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }


    private boolean verificationPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }

}
