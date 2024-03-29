package com.longluo.leetcode.matrix;

import com.longluo.datastructure.ArrayUtils;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * 给你一个正整数n，生成一个包含1到n^2所有元素，且元素按顺时针顺序螺旋排列的n x n正方形矩阵matrix。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 * <p>
 * https://leetcode.cn/problems/spiral-matrix-ii/
 */
public class Problem59_spiralMatrix_ii {

    // BF time: O(n^2) space: O(1)
    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int count = 1;

        for (int cycle = 0; cycle <= n / 2; cycle++) {
            // Right
            for (int i = cycle; i < n - cycle; i++) {
                ans[cycle][i] = count++;
                if (count > n * n) {
                    return ans;
                }
            }

            // Down
            for (int j = cycle + 1; j < n - cycle; j++) {
                ans[j][n - cycle - 1] = count++;
                if (count > n * n) {
                    return ans;
                }
            }

            // Left
            for (int k = n - cycle - 2; k >= cycle; k--) {
                ans[n - cycle - 1][k] = count++;
                if (count > n * n) {
                    return ans;
                }
            }

            // Up
            for (int l = n - cycle - 2; l > cycle; l--) {
                ans[l][cycle] = count++;
                if (count > n * n) {
                    return ans;
                }
            }
        }

        return ans;
    }

    // Better time: O(n^2) space: O(1)
    public static int[][] generateMatrix_opt(int n) {
        int[][] res = new int[n][n];

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] visited = new boolean[n][n];

        int row = 0;
        int col = 0;

        int dirIdx = 0;

        for (int i = 1; i <= n * n; i++) {
            res[row][col] = i;

            visited[row][col] = true;

            int nextRow = row + dirs[dirIdx][0];
            int nextCol = col + dirs[dirIdx][1];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                dirIdx = (dirIdx + 1) % 4;
            }

            row = row + dirs[dirIdx][0];
            col = col + dirs[dirIdx][1];
        }

        return res;
    }

    // 按层模拟 time: O(n^2) space: O(1)
    public static int[][] generateMatrix_3(int n) {
        int[][] res = new int[n][n];

        int count = 1;

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[top][i] = count;
                count++;
            }

            for (int i = top + 1; i <= bottom; i++) {
                res[i][right] = count;
                count++;
            }

            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    res[bottom][i] = count;
                    count++;
                }

                for (int i = bottom - 1; i > top; i--) {
                    res[i][left] = count;
                    count++;
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }

    // Best Code time: O(n^2) space: O(1)
    public static int[][] generateMatrix_best(int n) {
        int[][] matrix = new int[n][n];

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        int k = 1;

        while (k <= n * n) {
            for (int c = left; c <= right; c++, k++) {
                matrix[top][c] = k;
            }
            top++;

            for (int r = top; r <= bottom; r++, k++) {
                matrix[r][right] = k;
            }
            right--;

            for (int c = right; c >= left; c--, k++) {
                matrix[bottom][c] = k;
            }
            bottom--;

            for (int r = bottom; r >= top; r--, k++) {
                matrix[r][left] = k;
            }
            left++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(" Method 1:");
        System.out.println("[[1, 2, 3],[8, 9, 4],[7, 6, 5]] ?= " + ArrayUtils.print2DArray(generateMatrix(3)));
        System.out.println("[[1]] ?= " + ArrayUtils.print2DArray(generateMatrix(1)));

        System.out.println(" Method 2:");
        System.out.println("[[1, 2, 3],[8, 9, 4],[7, 6, 5]] ?= " + ArrayUtils.print2DArray(generateMatrix_opt(3)));
        System.out.println("[[1]] ?= " + ArrayUtils.print2DArray(generateMatrix_opt(1)));

        System.out.println(" Method 3:");
        System.out.println("[[1, 2, 3],[8, 9, 4],[7, 6, 5]] ?= " + ArrayUtils.print2DArray(generateMatrix_3(3)));
        System.out.println("[[1]] ?= " + ArrayUtils.print2DArray(generateMatrix_3(1)));

        System.out.println("[[1, 2, 3],[8, 9, 4],[7, 6, 5]] ?= " + ArrayUtils.print2DArray(generateMatrix_best(3)));
    }
}
