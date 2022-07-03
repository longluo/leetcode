package com.longluo.offer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * <p>
 * https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Offer12_exist {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int len = word.length();
        int row = board.length;
        int col = board[0].length;
        if (row * col < len) {
            return false;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, String target, int level, int x, int y) {
        if (level > target.length()) {
            return false;
        }

        if (level == target.length()) {
            return true;
        }

        int row = board.length;
        int col = board[0].length;

        if (x < 0 || x >= row || y < 0 || y >= col) {
            return false;
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        if (target.charAt(level) != board[x][y]) {
            return false;
        }

        char temp = board[x][y];
        board[x][y] = '/';

        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];

            if (dfs(board, target, level + 1, nextX, nextY)) {
                return true;
            }
        }

        board[x][y] = temp;

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println("false ?= " + exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "abcd"));
        System.out.println("true ?= " + exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));
    }
}
