package com.longluo.leetcode.array;

import com.longluo.datastructure.ArrayUtils;

/**
 * 73. 矩阵置零
 * <p>
 * 给定一个m x n的矩阵，如果一个元素为0，则将其所在行和列的所有元素都设为0。请使用 原地 算法。
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class Problem73_setMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rowFlg = new boolean[row];
        boolean[] colFlg = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowFlg[i] = true;
                    colFlg[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowFlg[i] || colFlg[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag_col0 = false, flag_row0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag_col0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flag_row0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flag_col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flag_row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        setZeroes(test1);
        setZeroes_2(test1);
        System.out.println("[[1, 0, 1],[0, 0, 0],[1, 0, 1]] ?= " + ArrayUtils.print2DArray(test1));

        int[][] test2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//        setZeroes(test2);
        setZeroes_2(test2);
        System.out.println("[[0,0,0,0],[0,4,5,0],[0,3,1,0]] ?= " + ArrayUtils.print2DArray(test2));
    }
}
