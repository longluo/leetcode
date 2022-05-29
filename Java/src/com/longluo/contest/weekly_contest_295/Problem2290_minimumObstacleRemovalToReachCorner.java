package com.longluo.contest.weekly_contest_295;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 6081. 到达角落需要移除障碍物的最小数目
 * <p>
 * 给你一个下标从 0 开始的二维整数数组 grid ，数组大小为 m x n 。每个单元格都是两个值之一：
 * <p>
 * 0 表示一个 空 单元格，
 * 1 表示一个可以移除的 障碍物 。
 * 你可以向上、下、左、右移动，从一个空单元格移动到另一个空单元格。
 * <p>
 * 现在你需要从左上角 (0, 0) 移动到右下角 (m - 1, n - 1) ，返回需要移除的障碍物的 最小 数目。
 * <p>
 * 示例 1：
 * 输入：grid = [[0,1,1],[1,1,0],[1,1,0]]
 * 输出：2
 * 解释：可以移除位于 (0, 1) 和 (0, 2) 的障碍物来创建从 (0, 0) 到 (2, 2) 的路径。
 * 可以证明我们至少需要移除两个障碍物，所以返回 2 。
 * 注意，可能存在其他方式来移除 2 个障碍物，创建出可行的路径。
 * <p>
 * 示例 2：
 * 输入：grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]
 * 输出：0
 * 解释：不移除任何障碍物就能从 (0, 0) 到 (2, 4) ，所以返回 0 。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10^5
 * 2 <= m * n <= 10^5
 * grid[i][j] 为 0 或 1
 * grid[0][0] == grid[m - 1][n - 1] == 0
 * <p>
 * https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner/
 */
public class Problem2290_minimumObstacleRemovalToReachCorner {

    // BFS time: O(mn) space: O(mn)
    public static int minimumObstacles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] dp = new int[row][col];

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> dp[o1[0]][o1[1]] - dp[o2[0]][o2[1]]);
        queue.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && !visited[nextX][nextY]) {
                        dp[nextX][nextY] = dp[x][y] + grid[nextX][nextY];
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minimumObstacles(new int[][]{{0, 1, 1}, {1, 1, 0}, {1, 1, 0}}));
    }
}
