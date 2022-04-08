package com.longluo.studyplan.programming_skills;

/**
 * 1572. 矩阵对角线元素的和
 * <p>
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * 示例  1：
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * <p>
 * 示例  2：
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * <p>
 * 示例 3：
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * 提示：
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 * <p>
 * https://leetcode-cn.com/problems/matrix-diagonal-sum/
 */
public class Problem1572_MatrixDiagonalSum {

    // BF time: O(n^2) space: O(1)
    public static int diagonalSum_bf(int[][] mat) {
        int row = mat.length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (i == j || i + j == row - 1) {
                    sum += mat[i][j];
                }
            }
        }

        return sum;
    }

    // time: O(n) space: O(1)
    public static int diagonalSum_opt(int[][] mat) {
        int row = mat.length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += mat[i][i];
            sum += mat[i][row - 1 - i];
        }

        return row % 2 == 0 ? sum : sum - mat[row / 2][row / 2];
    }

    // time: O(n) space: O(1)
    public static int diagonalSum_on(int[][] mat) {
        int row = mat.length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += mat[i][i] + mat[i][row - 1 - i];
        }

        return sum - mat[row / 2][row / 2] * (row & 1);
    }

    public static void main(String[] args) {

    }
}
