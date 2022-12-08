package com.longluo.leetcode.math;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * <p>
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * <p>
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * <p>
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 * <p>
 * 示例 1：
 * 输入：coordinates = "a1"
 * 输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 * <p>
 * 示例 2：
 * 输入：coordinates = "h3"
 * 输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 * <p>
 * 示例 3：
 * 输入：coordinates = "c7"
 * 输出：false
 * <p>
 * 提示：
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 * <p>
 * https://leetcode.cn/problems/determine-color-of-a-chessboard-square/
 */
public class Problem1812_squareIsWhite {

    // Math time: O(C) space: O(C)
    public static boolean squareIsWhite(String coordinates) {
        int[][] board = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    board[i][j] += j % 2 == 0 ? 1 : 0;
                } else {
                    board[i][j] += j % 2 == 1 ? 1 : 0;
                }
            }
        }

        return board[7 - (coordinates.charAt(0) - 'a')][coordinates.charAt(1) - '1'] > 0;
    }

    // Math time: O(1) space: O(1)
    public static boolean squareIsWhite_opt(String coordinates) {
        int row = coordinates.charAt(1) - '1';
        int col = coordinates.charAt(0) - 'a';

        if (row % 2 == 0) {
            return col % 2 != 0;
        } else {
            return col % 2 == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + squareIsWhite("a1"));
        System.out.println("true ?= " + squareIsWhite("h3"));
        System.out.println("false ?= " + squareIsWhite("c7"));
        System.out.println("false ?= " + squareIsWhite_opt("c7"));
    }
}
