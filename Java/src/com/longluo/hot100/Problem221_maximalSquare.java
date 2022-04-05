package com.longluo.hot100;

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

    // BF
    public static int maximalSquare_bf(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for (int i = 0; i < row; ) {
            for (int j = 0; j < col; ) {
                if (matrix[i][j] == 0) {
                    j++;
                    continue;
                } else {
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
