package leetcode.no22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 通过次数133,975提交次数177,490
 *
 * @author shengouqiang
 * @date 2020/6/8
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        help(0, 0, n, "", result);
        return result;
    }

    private void help(int left, int right, int count, String tmp, List<String> result) {
        if ((left + right) == 2 * count) {
            result.add(tmp);
            return;
        }
        if (left < count) {
            help(left + 1, right, count, tmp + "(", result);
        }
        if (right < count && right < left) {
            help(left, right + 1, count, tmp + ")", result);
        }

    }
}
