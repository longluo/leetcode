package com.longluo.leetcode.graph;

import java.util.*;

/**
 * 1631. 最小体力消耗路径
 * <p>
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 示例 1：
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * <p>
 * 示例 2：
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * <p>
 * 示例 3：
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * 提示：
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10^6
 * <p>
 * https://leetcode.com/problems/path-with-minimum-effort/
 */
public class Problem1631_pathWithMinimumEffort {

    // BFS(Dijkstra) time: O() space: O(mn)
    public static int minimumEffortPath_bfs(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((edge1, edge2) -> edge1[2] - edge2[2]);

        pq.offer(new int[]{0, 0, 0});

        int[] dist = new int[rows * cols];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        boolean[][] vis = new boolean[rows][cols];

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            int x = edge[0];
            int y = edge[1];
            int d = edge[2];

            if (vis[x][y]) {
                continue;
            }

            if (x == rows - 1 && y == cols - 1) {
                break;
            }

            vis[x][y] = true;
            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols
                        && Math.max(d, Math.abs(heights[nextX][nextY] - heights[x][y])) < dist[nextX * cols + nextY]) {
                    dist[nextX * cols + nextY] = Math.max(d, Math.abs(heights[nextX][nextY] - heights[x][y]));
                    pq.offer(new int[]{nextX, nextY, dist[nextX * cols + nextY]});
                }
            }
        }

        return dist[rows * cols - 1];
    }

    // BinarySearch time: O(mnlogC) space: O(mn)
    public static int minimumEffortPath_bs(int[][] heights) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int rows = heights.length;
        int cols = heights[0].length;

        int left = 0;
        int right = 1_000_000 - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            boolean[][] visited = new boolean[rows][cols];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            visited[0][0] = true;

            while (!queue.isEmpty()) {
                int[] curPos = queue.poll();
                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !visited[nextX][nextY]
                            && Math.abs(heights[nextX][nextY] - heights[curPos[0]][curPos[1]]) <= mid) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }

            if (visited[rows - 1][cols - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumEffortPath_bfs(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        System.out.println("2 ?= " + minimumEffortPath_bfs(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));

        System.out.println("2 ?= " + minimumEffortPath_bs(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }
}
