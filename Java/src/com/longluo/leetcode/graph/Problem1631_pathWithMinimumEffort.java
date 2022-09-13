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
 * https://leetcode.cn/problems/path-with-minimum-effort/
 */
public class Problem1631_pathWithMinimumEffort {

    // Navie BFS
    public static int minimumEffortPath_naiveBFS(int[][] heights) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int minCost = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                        continue;
                    }

                    minCost = Math.max(minCost, Math.abs(heights[nextX][nextY] - heights[cur[0]][cur[1]]));

                    if (nextX == m - 1 && nextY == n - 1) {
                        break;
                    }

                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return minCost;
    }

    // Cost BFS time: O(m^2n^2) space: O(mn)
    public static int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = heights.length;
        int n = heights[0].length;

        int[][] costs = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        costs[0][0] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                int x = cur[0];
                int y = cur[1];

                int curCost = costs[x][y];

                for (int[] dir : dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];

                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }

                    int newCost = Math.max(curCost, Math.abs(heights[nextX][nextY] - heights[x][y]));
                    if (newCost < costs[nextX][nextY]) {
                        costs[nextX][nextY] = newCost;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return costs[m - 1][n - 1];
    }

    // BFS(Dijkstra) time: O(mnlog(mn)) space: O(mn)
    public static int minimumEffortPath_bfs(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int rows = heights.length;
        int cols = heights[0].length;

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

    // Union Find time: O(mnlog(mn)) space: O(mn)
    public static int minimumEffortPath_uf(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                if (i > 0) {
                    edges.add(new int[]{index - cols, index, Math.abs(heights[i][j] - heights[i - 1][j])});
                }

                if (j > 0) {
                    edges.add(new int[]{index - 1, index, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }

        Collections.sort(edges, (edge1, edge2) -> edge1[2] - edge2[2]);

        UnionFind uf = new UnionFind(rows * cols);
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int d = edge[2];
            uf.union(x, y);
            if (uf.isConnected(0, rows * cols - 1)) {
                ans = d;
                break;
            }
        }

        return ans;
    }

    static class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }

            count--;
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumEffortPath_naiveBFS(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));

        System.out.println("9 ?= " + minimumEffortPath(new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}}));
        System.out.println("1 ?= " + minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));

        System.out.println("1 ?= " + minimumEffortPath_bfs(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        System.out.println("2 ?= " + minimumEffortPath_bfs(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));

        System.out.println("2 ?= " + minimumEffortPath_bs(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));

        System.out.println("2 ?= " + minimumEffortPath_uf(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }
}
