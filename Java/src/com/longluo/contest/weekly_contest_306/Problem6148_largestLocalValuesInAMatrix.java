package com.longluo.contest.weekly_contest_306;

import java.util.Arrays;

/**
 * 6148. 矩阵中的局部最大值
 * <p>
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 * 返回生成的矩阵。
 * <p>
 * 示例 1：
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 * <p>
 * 示例 2：
 * 输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * 输出：[[2,2,2],[2,2,2],[2,2,2]]
 * 解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 * <p>
 * 提示：
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 * <p>
 * https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 */
public class Problem6148_largestLocalValuesInAMatrix {

    // Simulate time: O(8*n^2) space: O(1)
    public static int[][] largestLocal(int[][] grid) {
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int max = grid[i][j];
                for (int[] dir : dirs) {
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];
                    max = Math.max(max, grid[nextX][nextY]);
                }

                ans[i - 1][j - 1] = max;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(" ?= " + Arrays.deepToString(largestLocal(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}})));
    }
}
