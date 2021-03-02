package com.longluo.leetcode.dp;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * <p>
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 * 示例:
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * 说明:
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 */
public class Problem304_NumMatrix {

    static class NumMatrix {
        int[][] newMatrix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            newMatrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, col);
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    sum += newMatrix[i][j];
                }
            }

            return sum;
        }
    }

    static class NumMatrix_1 {
        int[][] sums;

        public NumMatrix_1(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            sums = new int[row][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                ans += (sums[i][col2 + 1] - sums[i][col1]);
            }

            return ans;
        }
    }

    static class NumMatrix_2 {
        int[][] sum;

        public NumMatrix_2(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            sum = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
    public static void main(String[] args) {
        int[][] testMatrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        Problem304_NumMatrix.NumMatrix numMatrix = new Problem304_NumMatrix.NumMatrix(testMatrix);
        System.out.println("8 ?= " + numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println("11 ?= " + numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println("12 ?= " + numMatrix.sumRegion(1, 2, 2, 4));

        Problem304_NumMatrix.NumMatrix_1 numMatrix_1 = new Problem304_NumMatrix.NumMatrix_1(testMatrix);
        System.out.println("8 ?= " + numMatrix_1.sumRegion(2, 1, 4, 3));
        System.out.println("11 ?= " + numMatrix_1.sumRegion(1, 1, 2, 2));
        System.out.println("12 ?= " + numMatrix_1.sumRegion(1, 2, 2, 4));

        Problem304_NumMatrix.NumMatrix_2 numMatrix_2 = new Problem304_NumMatrix.NumMatrix_2(testMatrix);
        System.out.println("8 ?= " + numMatrix_2.sumRegion(2, 1, 4, 3));
        System.out.println("11 ?= " + numMatrix_2.sumRegion(1, 1, 2, 2));
        System.out.println("12 ?= " + numMatrix_2.sumRegion(1, 2, 2, 4));
    }
}
