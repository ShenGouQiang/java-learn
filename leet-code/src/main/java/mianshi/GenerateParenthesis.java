package mianshi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 面试题 08.09. 括号
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author shengouqiang
 * @date 2020/5/27
 */
public class GenerateParenthesis {

    @Test
    public void testOne() {
      //  generateParenthesis(0);
      //  generateParenthesis(1);
        System.out.println(generateParenthesis(4));
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        help(n, result, 0, 0, "");
        return result;
    }

    private void help(int n, List<String> result, int left, int right, String str) {
        if (left + right == 2 * n) {
            result.add(str);
        }
        if (left < n) {
            help(n, result, left + 1, right, str + "(");
        }
        if (right < left && right < n) {
            help(n, result, left, right + 1, str + ")");
        }
    }
}
