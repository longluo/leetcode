package com.longluo.algo200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 505. 迷宫 II
 * <p>
 * 由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。
 * <p>
 * 给定球的起始位置，目的地和迷宫，找出让球停在目的地的最短距离。距离的定义是球从起始位置（不包括）到目的地（包括）经过的空地个数。
 * 如果球无法停在目的地，返回 -1。
 * <p>
 * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
 * <p>
 * 示例 1:
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
 * 输入 3: 目的地坐标 (rowDest, colDest) = (4, 4)
 * <p>
 * 输出: 12
 * <p>
 * 解析: 一条最短路径 : left -> down -> left -> down -> right -> down -> right。
 * 总距离为 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12。
 * <p>
 * 示例 2:
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
 * 输入 3: 目的地坐标 (rowDest, colDest) = (3, 2)
 * <p>
 * 输出: -1
 * <p>
 * 解析: 没有能够使球停在目的地的路径。
 * <p>
 * 注意:
 * 迷宫中只有一个球和一个目的地。
 * 球和目的地都在空地上，且初始时它们不在同一位置。
 * 给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。
 * 迷宫至少包括2块空地，行数和列数均不超过100。
 * <p>
 * https://leetcode.cn/problems/the-maze-ii/
 */
public class Problem505_theMaze_ii {

    // BFS time: O(mn) space: O(mn)
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        int m = maze.length;
        int n = maze[0].length;

        if (m * n <= 2) {
            return 1;
        }

        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            int x = curPos[0];
            int y = curPos[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                int stepCnt = 0;

                while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maze[nextX][nextY] == 0) {
                    nextX += dir[0];
                    nextY += dir[1];
                    stepCnt++;
                }

                if (distance[nextX - dir[0]][nextY - dir[1]] > distance[x][y] + stepCnt) {
                    distance[nextX - dir[0]][nextY - dir[1]] = distance[x][y] + stepCnt;
                    queue.offer(new int[]{nextX - dir[0], nextY - dir[1]});
                }
            }
        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    // DFS time: O(mn) space: O(mn)
    public static int shortestDistance_dfs(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        if (m * n <= 2) {
            return 1;
        }

        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;
        dfs(maze, distance, start);

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private static void dfs(int[][] maze, int[][] distance, int[] start) {
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        int m = maze.length;
        int n = maze[0].length;

        for (int[] dir : dirs) {
            int nextX = start[0] + dir[0];
            int nextY = start[1] + dir[1];
            int steps = 0;

            while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maze[nextX][nextY] == 0) {
                nextX += dir[0];
                nextY += dir[1];
                steps++;
            }

            nextX -= dir[0];
            nextY -= dir[1];

            if (distance[nextX][nextY] > distance[start[0]][start[1]] + steps) {
                distance[nextX][nextY] = distance[start[0]][start[1]] + steps;
                dfs(maze, distance, new int[]{nextX, nextY});
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + shortestDistance(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4}));
        System.out.println("-1 ?= " + shortestDistance(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{3, 2}));

        System.out.println("12 ?= " + shortestDistance_dfs(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4}));
        System.out.println("-1 ?= " + shortestDistance_dfs(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{3, 2}));
    }
}
