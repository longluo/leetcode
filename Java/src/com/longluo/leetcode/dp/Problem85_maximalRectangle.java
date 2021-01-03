package com.longluo.leetcode.dp;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * <p>
 * 示例 2：
 * 输入：matrix = []
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：matrix = [["1"]]
 * 输出：1
 * <p>
 * 示例 5：
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * <p>
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 */
public class Problem85_maximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        if (matrix[0][0] == '1') {
            dp[0][0] = 1;
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == '1') {
                if (matrix[i - 1][0] == '1') {
                    dp[i][0] = Math.max(dp[i - 1][0] + 1, 1);
                } else {
                    dp[i][0] = Math.max(dp[i - 1][0], 1);
                }
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], 0);
            }
        }

        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == '1') {
                if (matrix[0][i - 1] == '1') {
                    dp[0][i] = Math.max(dp[0][i - 1] + 1, 1);
                } else {
                    dp[0][i] = Math.max(dp[0][i - 1], 1);
                }
            } else {
                dp[0][i] = Math.max(dp[0][i - 1], 0);
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1') {
                        dp[i][j] = Math.max(dp[i - 1][j] + 2, dp[i - 1][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        if (dp[i][j] < 1 ){
                            dp[i][j] = 1;
                        }
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + maximalRectangle(new char[][]{{}}));
        System.out.println("0 ?= " + maximalRectangle(new char[][]{{'0'}}));
        System.out.println("0 ?= " + maximalRectangle(new char[][]{{'0', '0'}}));
        System.out.println("1 ?= " + maximalRectangle(new char[][]{{'1'}}));
        System.out.println("6 ?= " + maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
