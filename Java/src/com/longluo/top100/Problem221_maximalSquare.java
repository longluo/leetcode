package com.longluo.top100;

/**
 * 221. 最大正方形
 * <p>
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 * <p>
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class Problem221_maximalSquare {

    // BF time: O(m^2 * n^2) space: O(1)
    // Timeout
    public static int maximalSquare_bf(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    for (int len = 1; i + len <= row && j + len <= col; len++) {
                        boolean isSquare = true;
                        for (int m = 0; m < len; m++) {
                            for (int n = 0; n < len; n++) {
                                if (matrix[i + m][j + n] == '0') {
                                    isSquare = false;
                                    break;
                                }
                            }
                        }

                        if (isSquare) {
                            ans = Math.max(ans, len * len);
                        }
                    }
                }
            }
        }

        return ans;
    }

    // BF Opt time: O(m * n * min(m, n)^3) space: O(1)
    // AC
    public static int maximalSquare_bf_opt(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    boolean isSquare = true;
                    for (int len = 1; i + len <= row && j + len <= col; len++) {
                        for (int k = 0; k < len; k++) {
                            if (matrix[i + len - 1][j + k] == '0') {
                                isSquare = false;
                                break;
                            }
                        }

                        if (!isSquare) {
                            break;
                        }

                        for (int k = 0; k < len; k++) {
                            if (matrix[i + k][j + len - 1] == '0') {
                                isSquare = false;
                                break;
                            }
                        }

                        if (isSquare) {
                            ans = Math.max(ans, len * len);
                        }
                    }
                }
            }
        }

        return ans;
    }

    // BF Opt V2 time: O(m * n * min(m, n)^2) space: O(1)
    // AC
    public static int maximalSquare_bf_v2(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int currMaxSide = Math.min(row - i, col - j);

                    for (int len = 1; len < currMaxSide; len++) {
                        boolean isSquare = true;

                        if (matrix[i + len][j + len] == '0') {
                            break;
                        }

                        for (int k = 0; k < len; k++) {
                            if (matrix[i + len][j + k] == '0' || matrix[i + k][j + len] == '0') {
                                isSquare = false;
                                break;
                            }
                        }

                        if (isSquare) {
                            maxSide = Math.max(maxSide, len + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return maxSide * maxSide;
    }

    // DP time: O(m * n) space: O(m * n)
    public static int maximalSquare_dp(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 1 && j > 1) {

                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + maximalSquare_bf(new char[][]{{'0'}}));
        System.out.println("1 ?= " + maximalSquare_bf(new char[][]{{'1'}}));
        System.out.println("1 ?= " + maximalSquare_bf(new char[][]{{'0', '1'}, {'1', '0'}}));
        System.out.println("4 ?= " + maximalSquare_bf(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));

        System.out.println("1 ?= " + maximalSquare_bf_opt(new char[][]{{'0', '1'}, {'1', '0'}}));
        System.out.println("4 ?= " + maximalSquare_bf_opt(new char[][]{{'1', '1'}, {'1', '1'}}));
        System.out.println("4 ?= " + maximalSquare_bf_opt(new char[][]{{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}}));

        System.out.println("4 ?= " + maximalSquare_bf_v2(new char[][]{{'1', '1'}, {'1', '1'}}));
        System.out.println("4 ?= " + maximalSquare_bf_v2(new char[][]{{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}}));

        System.out.println("1 ?= " + maximalSquare_dp(new char[][]{{'0', '1'}, {'1', '0'}}));
        System.out.println("4 ?= " + maximalSquare_dp(new char[][]{{'1', '1'}, {'1', '1'}}));
        System.out.println("4 ?= " + maximalSquare_dp(new char[][]{{'1', '0', '1', '0'}, {'1', '0', '1', '1'}, {'1', '0', '1', '1'}, {'1', '1', '1', '1'}}));
    }
}
