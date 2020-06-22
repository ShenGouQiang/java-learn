package offer.no12;

import org.junit.Test;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; i < col; j++) {
                if ( board[i][j] == words[0] && dfs(board, words, flag, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, boolean[][] flag, int i, int j, int depth) {
        if (i < 0 || i >= board.length || j >= board[0].length || j < 0 || board[i][j] != words[depth] || flag[i][j]) {
            return false;
        }
        if (depth ==words.length - 1) {
            return true;
        }
        flag[i][j] = true;
        boolean result = dfs(board, words, flag, i + 1, j, depth + 1)
                || dfs(board, words, flag, i - 1, j, depth + 1)
                || dfs(board, words, flag, i, j + 1, depth + 1)
                || dfs(board, words, flag, i, j - 1, depth + 1);
        flag[i][j] = false;
        return result;
    }

    @Test
    public void testOne(){
        System.out.println(exist(new char[][]{{'a'}},"ab"));
    }

}
