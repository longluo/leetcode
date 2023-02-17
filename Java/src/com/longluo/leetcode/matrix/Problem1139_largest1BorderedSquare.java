package com.longluo.leetcode.matrix;

/**
 * 1139. 最大的以 1 为边界的正方形
 * <p>
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。
 * 如果不存在，则返回 0。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,1,1}, {1,0,1}, {1,1,1]]
 * 输出：9
 * <p>
 * 示例 2：
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * https://leetcode.cn/problems/largest-1-bordered-square/
 */
public class Problem1139_largest1BorderedSquare {

    // BF time: O(m^2n^2) space: O(1)
    public static int largest1BorderedSquare_bf(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                int len = 1;

                for (int l = 2; l <= m - i && l <= n - j; l++) {
                    boolean flag = true;

                    for (int k = 0; k < l; k++) {
                        if (grid[i][j + k] == 0 || grid[i + l - 1][j + k] == 0) {
                            flag = false;
                            break;
                        }
                    }

                    if (!flag) {
                        continue;
                    }

                    for (int k = 0; k < l; k++) {
                        if (grid[i + k][j] == 0 || grid[i + k][j + l - 1] == 0) {
                            flag = false;
                            break;
                        }
                    }

                    if (!flag) {
                        continue;
                    }

                    if (flag) {
                        len = l;
                    }
                }

                ans = Math.max(ans, len * len);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + largest1BorderedSquare_bf(new int[][]{{1, 1, 0, 0}}));
        System.out.println("9 ?= " + largest1BorderedSquare_bf(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}
