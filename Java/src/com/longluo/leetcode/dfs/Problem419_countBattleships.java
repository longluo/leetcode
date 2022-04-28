package com.longluo.leetcode.dfs;

/**
 * 419. 甲板上的战舰
 * <p>
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 * <p>
 * 示例 1：
 * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：board = [["."]]
 * 输出：0
 * <p>
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 是 '.' 或 'X'
 * <p>
 * https://leetcode-cn.com/problems/battleships-in-a-board/
 */
public class Problem419_countBattleships {

    // BF time: O(m * n * max(m, n) space: O(m * n)
    public static int countBattleships(char[][] board) {
        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    visited[i][j] = true;
                    ans++;

                    for (int k = i + 1; k < m && board[k][j] == 'X'; k++) {
                        visited[k][j] = true;
                    }

                    for (int k = j + 1; k < n && board[i][k] == 'X'; k++) {
                        visited[i][k] = true;
                    }
                }
            }
        }

        return ans;
    }

    // BF time: O(m * n * max(m, n)) space: O(1)
    public static int countBattleships_better(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    board[i][j] = '.';
                    for (int k = i + 1; k < m && board[k][j] == 'X'; k++) {
                        board[k][j] = '.';
                    }
                    for (int k = j + 1; k < n && board[i][k] == 'X'; k++) {
                        board[i][k] = '.';
                    }
                }
            }
        }

        return ans;
    }

    // BF time: O(m * n) space: O(1)
    public static int countBattleships_best(char[][] board) {
        int ans = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }

                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                }
            }
        }

        return ans;
    }

    public static int countBattleships_dfs(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    dfs(board, i, j);
                }
            }
        }

        return ans;
    }

    public static void dfs(char[][] board, int x, int y) {
        int[] dx = {0, 1};
        int[] dy = {1, 0};

        board[x][y] = '.';

        for (int dir = 0; dir < 2; dir++) {
            int nX = x + dx[dir];
            int nY = y + dy[dir];

            if (nX >= 0 && nX < board.length && nY >= 0 && nY < board[0].length && board[nX][nY] == 'X') {
                dfs(board, nX, nY);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {
                '.', '.', '.', 'X'}}));
        System.out.println("2 ?= " + countBattleships_better(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {
                '.', '.', '.', 'X'}}));
        System.out.println("0 ?= " + countBattleships(new char[][]{{'.'}}));
        System.out.println("0 ?= " + countBattleships_better(new char[][]{{'.'}}));
        System.out.println("5 ?= " + countBattleships_better(new char[][]{{'.', 'X', '.', '.', 'X'}, {'.', 'X', '.', '.', 'X'},
                {'.', '.', '.', '.', 'X'}, {'X', '.', 'X', 'X', '.'}, {'X', '.', '.', '.', 'X'}}));
    }
}
