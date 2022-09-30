package com.longluo.lcci;

/**
 * 面试题 01.08. 零矩阵
 * <p>
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * 示例 1：
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * <p>
 * 示例 2：
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * <p>
 * https://leetcode.cn/problems/zero-matrix-lcci/
 */
public class Lcci_01_08_zeroMatrix {

    // BF time: O(m^2n^2) space: O(mn)
    public static void setZeroes_bf(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] copyMat = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, copyMat[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        copyMat[k][j] = 0;
                    }

                    for (int k = 0; k < n; k++) {
                        copyMat[i][k] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.arraycopy(copyMat[i], 0, matrix[i], 0, n);
        }
    }

    public static void main(String[] args) {
        setZeroes_bf(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }
}