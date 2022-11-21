package com.longluo.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. 迷宫中离入口最近的出口
 * <p>
 * 给你一个 m x n 的迷宫矩阵 maze（下标从 0 开始），矩阵中有空格子（用'.'表示）和墙（用'+'表示）。同时给你迷宫的入口 entrance，
 * 用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 * <p>
 * 每一步操作，你可以往 上，下，左 或者 右移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。
 * 你的目标是找到离 entrance 最近的出口。出口的含义是 maze 边界上的空格子。entrance 格子不算出口。
 * <p>
 * 请你返回从 entrance到最近出口的最短路径的 步数，如果不存在这样的路径，请你返回 -1。
 * <p>
 * 示例 1：
 * 输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * 输出：1
 * 解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
 * 一开始，你在入口格子 (1,2) 处。
 * - 你可以往左移动 2 步到达 (1,0) 。
 * - 你可以往上移动 1 步到达 (0,2) 。
 * 从入口处没法到达 (2,3) 。
 * 所以，最近的出口是 (0,2) ，距离为 1 步。
 * <p>
 * 示例 2：
 * 输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * 输出：2
 * 解释：迷宫中只有 1 个出口，在 (1,2) 处。
 * (1,0) 不算出口，因为它是入口格子。
 * 初始时，你在入口与格子 (1,0) 处。
 * - 你可以往右移动 2 步到达 (1,2) 处。
 * 所以，最近的出口为 (1,2) ，距离为 2 步。
 * <p>
 * 示例 3：
 * 输入：maze = [[".","+"]], entrance = [0,0]
 * 输出：-1
 * 解释：这个迷宫中没有出口。
 * <p>
 * 提示：
 * maze.length == m
 * maze[i].length == n
 * 1 <= m, n <= 100
 * maze[i][j] 要么是'.'，要么是'+'。
 * entrance.length == 2
 * 0 <= entrancerow < m
 * 0 <= entrancecol < n
 * entrance一定是空格子。
 * <p>
 * https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/
 */
public class Problem1926_nearestExitFromEntranceInMaze {

    // BFS time: O(mn) space: O(mn)
    public static int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = maze.length;
        int n = maze[0].length;

        boolean[] visited = new boolean[m * n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        visited[entrance[0] * n + entrance[1]] = true;

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                int x = curPos[0];
                int y = curPos[1];

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        if (x != entrance[0] || y != entrance[1]) {
                            return step;
                        }

                        continue;
                    }

                    if (maze[nextX][nextY] == '+') {
                        continue;
                    }

                    if (visited[nextX * n + nextY]) {
                        continue;
                    }

                    visited[nextX * n + nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }

            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}));
        System.out.println("2 ?= " + nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}));
    }
}
