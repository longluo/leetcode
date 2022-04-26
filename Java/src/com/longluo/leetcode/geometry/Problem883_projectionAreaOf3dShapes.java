package com.longluo.leetcode.geometry;

/**
 * 883. 三维形体投影面积
 * <p>
 * 在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
 * 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回 所有三个投影的总面积 。
 * <p>
 * 示例 1：
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 * <p>
 * 示例 2:
 * 输入：grid = [[2]]
 * 输出：5
 * <p>
 * 示例 3：
 * 输入：[[1,0],[0,2]]
 * 输出：8
 * <p>
 * 提示：
 * n == grid.length == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 * <p>
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 */
public class Problem883_projectionAreaOf3dShapes {

    // Simulate time: O(n^2) space: O(1)
    public static int projectionArea(int[][] grid) {
        int len = grid.length;

        int sumXY = 0;
        int sumXZ = 0;
        int sumYZ = 0;

        for (int i = 0; i < len; i++) {
            int xzHeight = 0;
            int yzHeight = 0;
            for (int j = 0; j < len; j++) {
                sumXY += grid[i][j] > 0 ? 1 : 0;
                xzHeight = Math.max(xzHeight, grid[j][i]);
                yzHeight = Math.max(yzHeight, grid[i][j]);
            }

            sumXZ += xzHeight;
            sumYZ += yzHeight;
        }

        return sumXY + sumXZ + sumYZ;
    }

    // Math time: O(n^2) space: O(1)
    public static int projectionArea_math(int[][] grid) {
        int n = grid.length;
        int xyArea = 0;
        int yzArea = 0;
        int zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0;
            int zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }

            yzArea += yzHeight;
            zxArea += zxHeight;
        }

        return xyArea + yzArea + zxArea;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + projectionArea(new int[][]{{2}}));
        System.out.println("8 ?= " + projectionArea(new int[][]{{1, 0}, {0, 2}}));
        System.out.println("17 ?= " + projectionArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println("17 ?= " + projectionArea_math(new int[][]{{1, 2}, {3, 4}}));
    }
}
