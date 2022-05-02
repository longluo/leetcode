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
                       for (int m = 0; i + m < row && m < len; m++) {
                           for (int n = 0; j + n < col && n < len; n++) {
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

    public static void main(String[] args) {
        System.out.println("0 ?= " + maximalSquare_bf(new char[][]{{'0'}}));
        System.out.println("1 ?= " + maximalSquare_bf(new char[][]{{'1'}}));
        System.out.println("1 ?= " + maximalSquare_bf(new char[][]{{'0', '1'}, {'1', '0'}}));
        System.out.println("4 ?= " + maximalSquare_bf(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
