package com.longluo.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 417. 太平洋大西洋水流问题
 * <p>
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * <p>
 * 示例 1：
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * <p>
 * 示例 2：
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * <p>
 * 提示：
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 10^5
 * <p>
 * https://leetcode.cn/problems/pacific-atlantic-water-flow/
 */
public class Problem417_pacificAtlanticWaterFlow {

    // BFS time: O(m^2 * n^2) space: O(mn)
    public static List<List<Integer>> pacificAtlantic_bfs(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(heights, i, j)) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }

        return ans;
    }

    private static boolean bfs(int[][] grid, int r, int c) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        boolean[][] visited = new boolean[m][n];
        visited[r][c] = true;

        boolean pacific = false;
        boolean atlantic = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 || nextY < 0) {
                    pacific = true;
                }

                if (nextX >= m || nextY >= n) {
                    atlantic = true;
                }

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !visited[nextX][nextY] && grid[nextX][nextY] <= grid[x][y]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return pacific && atlantic;
    }

    // BFS Opt time: O((m+n)mn) space: O(mn)
    public static List<List<Integer>> pacificAtlantic_bfs_opt(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            pacificQueue.offer(new int[]{i, 0});

            atlantic[i][n - 1] = true;
            atlanticQueue.offer(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            pacificQueue.offer(new int[]{0, j});

            atlantic[m - 1][j] = true;
            atlanticQueue.offer(new int[]{m - 1, j});
        }

        bfs(heights, pacific, pacificQueue);
        bfs(heights, atlantic, atlanticQueue);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }

        return ans;
    }

    private static void bfs(int[][] grid, boolean[][] visited, Queue<int[]> queue) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && !visited[nextX][nextY] && grid[nextX][nextY] >= grid[x][y]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
    }

    // DFS time: O((m+n)*mn) space: O(mn)
    public static List<List<Integer>> pacificAtlantic_dfs_opt(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            dfs(heights, pacific, i, 0);

            atlantic[i][n - 1] = true;
            dfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            dfs(heights, pacific, 0, j);

            atlantic[m - 1][j] = true;
            dfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }

        return ans;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }

            if (visited[nextX][nextY] || grid[nextX][nextY] < grid[x][y]) {
                continue;
            }

            dfs(grid, visited, nextX, nextY);
        }
    }

    public static void main(String[] args) {
        System.out.println("[[0,0],[0,1],[1,0],[1,1]] ?= " + pacificAtlantic_bfs(new int[][]{{2, 1}, {1, 2}}).toString());
        System.out.println("[[0,0],[0,1],[1,0],[1,1]] ?= " + pacificAtlantic_bfs_opt(new int[][]{{2, 1}, {1, 2}}).toString());

        System.out.println("[[0,0],[0,1],[1,0],[1,1]] ?= " + pacificAtlantic_dfs_opt(new int[][]{{2, 1}, {1, 2}}).toString());
    }
}
