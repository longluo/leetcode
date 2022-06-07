package com.longluo.top100;

import com.longluo.datastructure.ArrayUtils;

/**
 * 48. 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * <p>
 * 示例 4：
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 * <p>
 * https://leetcode.com/problems/rotate-image/
 */
public class Problem48_rotateImage {

    // BF time: O(n^2) space: O(n^2)
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;
        
        int[][] newMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    public static void rotate_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void rotate_3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] tst1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotate(tst1);
//        rotate_2(tst1);
        rotate_3(tst1);
        System.out.println("[[7, 4, 1],[8, 5, 2],[9, 6, 3]] ?= " + ArrayUtils.print2DArray(tst1));

        int[][] tst2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        rotate(tst2);
//        rotate_2(tst2);
        rotate_3(tst2);
        System.out.println("[[15, 13, 2, 5],[14, 3, 4, 1],[12, 6, 8, 9],[16, 7, 10, 11]] ?= " + ArrayUtils.print2DArray(tst2));

        int[][] tst3 = new int[][]{{1}};
//        rotate(tst3);
//        rotate_2(tst3);
        rotate_3(tst3);
        System.out.println("[[1]] ?= " + ArrayUtils.print2DArray(tst3));

        int[][] tst4 = new int[][]{{1, 2}, {3, 4}};
//        rotate(tst4);
//        rotate_2(tst4);
        rotate_3(tst4);
        System.out.println("[[3, 1],[4, 2]] ?= " + ArrayUtils.print2DArray(tst4));
    }
}
