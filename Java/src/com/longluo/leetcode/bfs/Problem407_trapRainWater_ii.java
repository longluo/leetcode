package com.longluo.leetcode.bfs;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 407. 接雨水 II
 * <p>
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * <p>
 * 示例 1:
 * 输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
 * 输出: 4
 * 解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
 * <p>
 * 示例 2:
 * 输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
 * 输出: 10
 * <p>
 * 提示:
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 10^4
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/
 */
public class Problem407_trapRainWater_ii {

    // PriorityQueue time: O(MNlog(M+N)) space: O(MN)
    public static int trapRainWater_pq(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) {
            return 0;
        }

        int ans = 0;
        int row = heightMap.length;
        int col = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            for (int[] dir : dirs) {
                int nextX = curr[0] + dir[0];
                int nextY = curr[1] + dir[1];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY]) {
                    continue;
                }

                if (heightMap[nextX][nextY] < curr[2]) {
                    ans += curr[2] - heightMap[nextX][nextY];
                }

                visited[nextX][nextY] = true;
                pq.offer(new int[]{nextX, nextY, Math.max(heightMap[nextX][nextY], curr[2])});
            }
        }

        return ans;
    }

    // BFS time: O(M^2 * N^2) space: O(MN)
    public static int trapRainWater_bfs(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) {
            return 0;
        }

        int ans = 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        int maxHeight = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxHeight = Math.max(maxHeight, heightMap[i][j]);
            }
        }
        int[][] water = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                water[i][j] = maxHeight;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int nextX = curr[0] + dir[0];
                int nextY = curr[1] + dir[1];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }

                // 只有比当前水位高才会流出水，water[nextX][nextY] > heightMap[nextX][nextY]是为了保证不会重复遍历。
                if (water[curr[0]][curr[1]] < water[nextX][nextY] && water[nextX][nextY] > heightMap[nextX][nextY]) {
                    water[nextX][nextY] = Math.max(water[curr[0]][curr[1]], heightMap[nextX][nextY]);
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans += water[i][j] - heightMap[i][j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + trapRainWater_pq(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
        System.out.println("4 ?= " + trapRainWater_bfs(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
       System.out.println("10 ?= " + trapRainWater_pq(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
        System.out.println("10 ?= " + trapRainWater_bfs(new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
        System.out.println("3 ?= " + trapRainWater_bfs(new int[][]{{5, 5, 5, 1}, {5, 1, 1, 5}, {5, 1, 5, 5}, {5, 2, 5, 8}}));
        // System.out.println("3 ?= " + trapRainWater_bfs_marked(new int[][]{{5, 5, 5, 1}, {5, 1, 1, 5}, {5, 1, 5, 5}, {5, 2, 5, 8}}));
    }
}
