package com.longluo.studyplan.programming_skills;

import java.util.Arrays;

/**
 * 566. 重塑矩阵
 * <p>
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，
 * 但保留其原始数据。
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * 示例 1：
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * <p>
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 * <p>
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 */
public class Problem566_reshapeTheMatrix {

    // BF time: O(m*n) space: O(m*n)
    public int[][] matrixReshape_bf(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return nums;
        }

        int oldRow = nums.length;
        int oldCol = nums[0].length;

        if (oldRow * oldCol != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];

        for (int i = 0; i < oldRow; i++) {
            for (int j = 0; j < oldCol; j++) {
                int idx = oldCol * i + j;
                res[idx / c][idx % c] = nums[i][j];
            }
        }

        return res;
    }

    // BF Opt time: O(m*n) space: O(m*n)
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int total = i * n + j;
                int rowIdx = total / c;
                int colIdx = total % c;
                res[rowIdx][colIdx] = mat[i][j];
            }
        }

        return res;
    }

    // Best time: O(m*n) space: O(m*n)
    public static int[][] matrixReshape_opt(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[[1,2,3,4]]  ?= " + Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println("[[1,2], [3,4]]  ?= " + Arrays.deepToString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
        System.out.println("[[1,2], [3,4]]  ?= " + Arrays.deepToString(matrixReshape(new int[][]{{1}, {2}, {3}, {4}}, 2, 2)));
    }
}
