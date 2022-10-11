package com.longluo.algo200;

/**
 * 348. 设计井字棋
 * <p>
 * 请在 n × n 的棋盘上，实现一个判定井字棋（Tic-Tac-Toe）胜负的神器，判断每一次玩家落子后，是否有胜出的玩家。
 * <p>
 * 在这个井字棋游戏中，会有 2 名玩家，他们将轮流在棋盘上放置自己的棋子。
 * <p>
 * 在实现这个判定器的过程中，你可以假设以下这些规则一定成立：
 * <p>
 * 1. 每一步棋都是在棋盘内的，并且只能被放置在一个空的格子里；
 * <p>
 * 2. 一旦游戏中有一名玩家胜出的话，游戏将不能再继续；
 * <p>
 * 3. 一个玩家如果在同一行、同一列或者同一斜对角线上都放置了自己的棋子，那么他便获得胜利。
 * <p>
 * 示例:
 * <p>
 * 给定棋盘边长 n = 3, 玩家 1 的棋子符号是 "X"，玩家 2 的棋子符号是 "O"。
 * <p>
 * TicTacToe toe = new TicTacToe(3);
 * <p>
 * toe.move(0, 0, 1); -> 函数返回 0 (此时，暂时没有玩家赢得这场对决)
 * |X| | |
 * | | | |    // 玩家 1 在 (0, 0) 落子。
 * | | | |
 * <p>
 * toe.move(0, 2, 2); -> 函数返回 0 (暂时没有玩家赢得本场比赛)
 * |X| |O|
 * | | | |    // 玩家 2 在 (0, 2) 落子。
 * | | | |
 * <p>
 * toe.move(2, 2, 1); -> 函数返回 0 (暂时没有玩家赢得比赛)
 * |X| |O|
 * | | | |    // 玩家 1 在 (2, 2) 落子。
 * | | |X|
 * <p>
 * toe.move(1, 1, 2); -> 函数返回 0 (暂没有玩家赢得比赛)
 * |X| |O|
 * | |O| |    // 玩家 2 在 (1, 1) 落子。
 * | | |X|
 * <p>
 * toe.move(2, 0, 1); -> 函数返回 0 (暂无玩家赢得比赛)
 * |X| |O|
 * | |O| |    // 玩家 1 在 (2, 0) 落子。
 * |X| |X|
 * <p>
 * toe.move(1, 0, 2); -> 函数返回 0 (没有玩家赢得比赛)
 * |X| |O|
 * |O|O| |    // 玩家 2 在 (1, 0) 落子.
 * |X| |X|
 * <p>
 * toe.move(2, 1, 1); -> 函数返回 1 (此时，玩家 1 赢得了该场比赛)
 * |X| |O|
 * |O|O| |    // 玩家 1 在 (2, 1) 落子。
 * |X|X|X|
 * <p>
 * 进阶:
 * 您有没有可能将每一步的 move() 操作优化到比 O(n^2) 更快吗?
 * <p>
 * https://leetcode.cn/problems/design-tic-tac-toe/
 */
public class Problem348_designTicTacToe {

    // BF
    // AC
    static class TicTacToe {
        int[][] matrix;
        int n = 0;
        int cnt = 0;

        public TicTacToe(int n) {
            matrix = new int[n][n];
            this.n = n;
            cnt = 0;
        }

        public int move(int row, int col, int player) {
            cnt++;
            matrix[row][col] = player;
            if (cnt < 2 * n - 1) {
                return 0;
            }

            int playerId = 0;

            boolean flag = true;

            for (int i = 0; i < n; i++) {
                if (matrix[i][0] == 0) {
                    continue;
                }

                playerId = matrix[i][0];
                flag = true;
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] != playerId) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return playerId;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    continue;
                }

                playerId = matrix[0][j];
                flag = true;
                for (int i = 1; i < n; i++) {
                    if (matrix[i][j] != playerId) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return playerId;
                }
            }

            playerId = matrix[0][0];
            flag = true;
            for (int i = 1; i < n; i++) {
                if (matrix[i][i] != playerId) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return playerId;
            }

            playerId = matrix[0][n - 1];
            flag = true;
            for (int i = 1; i < n; i++) {
                if (matrix[i][n - 1 - i] != playerId) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return playerId;
            } else {
                return 0;
            }
        }
    }

    /**
     * Your TicTacToe object will be instantiated and called as such:
     * TicTacToe obj = new TicTacToe(n);
     * int param_1 = obj.move(row,col,player);
     */
    public static void main(String[] args) {
        TicTacToe tst1 = new TicTacToe(3);

        System.out.println(tst1.move(0, 0, 1));
        System.out.println(tst1.move(0, 2, 2));
        System.out.println(tst1.move(2, 2, 1));
        System.out.println(tst1.move(1, 1, 2));
        System.out.println(tst1.move(2, 0, 1));
        System.out.println(tst1.move(1, 0, 2));
        System.out.println(tst1.move(2, 1, 1));

        TicTacToe tst2 = new TicTacToe(2);

        System.out.println(tst2.move(0, 1, 2));
        System.out.println(tst2.move(1, 0, 1));
        System.out.println(tst2.move(1, 1, 2));
    }
}
