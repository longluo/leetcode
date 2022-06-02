package com.longluo.leetcode.array;

import com.longluo.datastructure.ArrayUtils;

/**
 * 867. 转置矩阵
 * <p>
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 10^5
 * -10^9 <= matrix[i][j] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/transpose-matrix/
 */
public class Problem867_transposeMatrix {

    // Simulate time: O(mn) space: O(1)
    public static int[][] transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] res = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[[1,4,7],[2,5,8],[3,6,9]] ?= " + ArrayUtils.print2DArray(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println("[[1,4],[2,5],[3,6]] ?= " + ArrayUtils.print2DArray(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }
}
