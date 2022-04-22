package com.longluo.top100;

/**
 * 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * <p>
 * https://leetcode-cn.com/problems/word-search/
 */
public class Problem79_wordSearch {

    static boolean isOk = false;

    // Backtrack time: O(m*n) space: O(m*n)
    public static boolean exist(char[][] board, String word) {
        isOk = false;
        int row = board.length;
        int col = board[0].length;
        // boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backtrack(board, new boolean[row][col], i, j, 0, word);
                    if (isOk) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void backtrack(char[][] board, boolean[][] visited, int x, int y, int idx, String word) {
        if (idx == word.length() - 1 && board[x][y] == word.charAt(idx)) {
            isOk = true;
            return;
        }

        if (board[x][y] != word.charAt(idx)) {
            return;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            visited[nextX][nextY] = true;
            backtrack(board, visited, nextX, nextY, idx + 1, word);
            visited[nextX][nextY] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println("true ?= " + exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println("false ?= " + exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
