package com.longluo.leetcode.dp;

/**
 * 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * 提示：
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * <p>
 * https://leetcode.cn/problems/unique-paths-ii/
 */
public class Problem63_uniquePaths_ii {

    // DP time: O(mn) space: O(mn)
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }


        int[][] dp = new int[row][col];

        dp[0][0] = 1;

        for (int i = 1; i < row; i++) {
            dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i - 1][0] : 0;
        }

        for (int j = 1; j < col; j++) {
            dp[0][j] = obstacleGrid[0][j] == 0 ? dp[0][j - 1] : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    // DP Opt time: O(n^2) space: O(n)
    public static int uniquePathsWithObstacles_opt(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }

        int[] dp = new int[col];
        dp[0] = 1;

        for (int i = 1; i < col; i++) {
            dp[i] = obstacleGrid[0][i] == 0 ? dp[i - 1] : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[j] = j == 0 ? dp[j] : dp[j - 1] + dp[j];
                } else {
                    dp[j] = 0;
                }
            }
        }

        return dp[col - 1];
    }

    public static void main(String[] args) {
        System.out.println("1  ?= " + uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println("0  ?= " + uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 1}, {0, 0}}));
        System.out.println("2  ?= " + uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

        System.out.println("2  ?= " + uniquePathsWithObstacles_opt(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
