package com.longluo.leetcode.dp;

import java.util.Arrays;

/**
 * 764. 最大加号标志
 * <p>
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。
 * mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * <p>
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * <p>
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
 * 由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * <p>
 * 示例 1：
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * <p>
 * 示例 2：
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 * <p>
 * 提示：
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi < n
 * 每一对 (xi, yi) 都 不重复
 * <p>
 * https://leetcode.cn/problems/largest-plus-sign/
 */
public class Problem764_largestPlusSign {

    // BF time: O(n^4) space: O(n^2)
    // TLE
    public static int orderOfLargestPlusSign_bf(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 1);
        }

        for (int[] pos : mines) {
            matrix[pos[0]][pos[1]] = 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                int max = 1;
                for (int k = 2; k <= (n + 1) / 2; k++) {
                    boolean flag = true;
                    for (int p = 1; p < k; p++) {
                        if (i - p < 0 || i + p >= n || j - p < 0 || j + p >= n
                                || matrix[i - p][j] == 0 || matrix[i + p][j] == 0 || matrix[i][j - p] == 0 || matrix[i][j + p] == 0) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        max = k;
                    }
                }

                ans = Math.max(ans, max);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + orderOfLargestPlusSign_bf(1, new int[][]{{0, 0}}));
        System.out.println("2 ?= " + orderOfLargestPlusSign_bf(5, new int[][]{{4, 2}}));
    }
}
