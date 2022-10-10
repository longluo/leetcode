package com.longluo.algo200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 490. 迷宫
 * <p>
 * 由空地（用 0 表示）和墙（用 1 表示）组成的迷宫 maze 中有一个球。球可以途经空地向 上、下、左、右 四个方向滚动，
 * 且在遇到墙壁前不会停止滚动。当球停下时，可以选择向下一个方向滚动。
 * 给你一个大小为 m x n 的迷宫 maze ，以及球的初始位置 start 和目的地 destination ，
 * 其中 start = [startrow, startcol] 且 destination = [destinationrow, destinationcol] 。
 * 请你判断球能否在目的地停下：如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 你可以 假定迷宫的边缘都是墙壁（参考示例）。
 * <p>
 * 示例 1：
 * 输入：maze = [[0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0]], start = [0,4], destination = [4,4]
 * 输出：true
 * 解释：一种可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
 * <p>
 * 示例 2：
 * 输入：maze = [[0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0]], start = [0,4], destination = [3,2]
 * 输出：false
 * 解释：不存在能够使球停在目的地的路径。注意，球可以经过目的地，但无法在那里停驻。
 * <p>
 * 示例 3：
 * 输入：maze = [[0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0]], start = [4,3], destination = [0,1]
 * 输出：false
 * <p>
 * 提示：
 * m == maze.length
 * n == maze[i].length
 * 1 <= m, n <= 100
 * maze[i][j] is 0 or 1.
 * start.length == 2
 * destination.length == 2
 * 0 <= startrow, destinationrow <= m
 * 0 <= startcol, destinationcol <= n
 * 球和目的地都在空地上，且初始时它们不在同一位置
 * 迷宫 至少包括 2 块空地
 * <p>
 * https://leetcode.cn/problems/the-maze/
 */
public class Problem490_theMaze {

    // BFS time: O(mn) space: O(mn)
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        int m = maze.length;
        int n = maze[0].length;

        if (m * n <= 2) {
            return true;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            int x = curPos[0];
            int y = curPos[1];

            if (x == destination[0] && y == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maze[nextX][nextY] == 0) {
                    nextX += dir[0];
                    nextY += dir[1];
                }

                if (!visited[nextX - dir[0]][nextY - dir[1]]) {
                    visited[nextX - dir[0]][nextY - dir[1]] = true;
                    queue.offer(new int[]{nextX - dir[0], nextY - dir[1]});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4}));
        System.out.println("false ?= " + hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{3, 2}));
    }
}
