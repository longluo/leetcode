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

    public static int countBattleships(char[][] board) {
        if (board == null || board[0].length == 0) {
            return 0;
        }

        int ans = 0;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (board[i][j] == '.') {
                        continue;
                    } else if (board[i][j] == 'X') {
                        ans++;
                        int k = i;
                        while (k + 1 < m && board[k + 1][j] == 'X') {
                            visited[k + 1][j] = true;
                            k++;
                        }
                        k = j;
                        while (k + 1 < n && board[i][k + 1] == 'X') {
                            visited[i][k + 1] = true;
                            k++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void dfs(char[][] board, char[][] visited, int m, int n) {

    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {
                '.', '.', '.', 'X'}}));
        System.out.println("0 ?= " + countBattleships(new char[][]{{'.'}}));
    }
}
