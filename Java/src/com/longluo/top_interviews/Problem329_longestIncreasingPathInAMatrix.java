package com.longluo.top_interviews;

import java.util.*;

/**
 * 329. 矩阵中的最长递增路径
 * <p>
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 * <p>
 * 示例 1：
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 * <p>
 * 示例 2：
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：1
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 2^31 - 1
 * <p>
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class Problem329_longestIncreasingPathInAMatrix {

    // BFS time: O(m^2n^2) space: O(mn)
    // TLE
    public static int longestIncreasingPath_bfs(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, bfs(matrix, i, j));
            }
        }

        return max;
    }

    public static int bfs(int[][] matrix, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                        continue;
                    }

                    if (matrix[nextX][nextY] <= matrix[curPos[0]][curPos[1]]) {
                        continue;
                    }

                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return ans;
    }

    // BFS Opt time: O(m^2n^2) space: O(mn)
    public static int longestIncreasingPath_bfs_opt(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int ans = 1;
        int[][] maxLen = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maxLen[i][j] == 0) {
                    ans = Math.max(ans, bfs_opt(matrix, maxLen, i, j));
                }
            }
        }

        return ans;
    }

    public static int bfs_opt(int[][] matrix, int[][] maxLen, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = curPos[0] + dir[0];
                    int nextY = curPos[1] + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                        continue;
                    }

                    if (matrix[nextX][nextY] <= matrix[curPos[0]][curPos[1]]) {
                        continue;
                    }

                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        maxLen[x][y] = ans;
        return ans;
    }

    // Memory + DFS time: O(mn) space: O(mn)
    public static int longestIncreasingPath_memo(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int max = 0;
        int[][] memo = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (memo[i][j] == 0) {
                    max = Math.max(max, dfs(matrix, memo, i, j));
                }
            }
        }

        return max;
    }

    public static int dfs(int[][] matrix, int[][] memo, int x, int y) {
        if (memo[x][y] > 0) {
            return memo[x][y];
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int ans = 1;

        int row = matrix.length;
        int col = matrix[0].length;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                continue;
            }

            if (matrix[nextX][nextY] <= matrix[x][y]) {
                continue;
            }

            ans = Math.max(ans, dfs(matrix, memo, nextX, nextY) + 1);
        }

        memo[x][y] = ans;
        return ans;
    }

    // DP time: O(mnlog(mn)) space: O(mn)
    public static int longestIncreasingPath_dp(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int max = 1;

        List<int[]> numList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                numList.add(new int[]{matrix[i][j], i, j});
            }
        }

        Collections.sort(numList, (o1, o2) -> o2[0] - o1[0]);

        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], 1);
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] item : numList) {
            int x = item[1];
            int y = item[2];

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || matrix[nextX][nextY] <= matrix[x][y]) {
                    continue;
                }

                // 没有越界且相邻的节点值比当前节点大，就可以从它转移而来
                dp[x][y] = Math.max(dp[x][y], dp[nextX][nextY] + 1);
            }

            max = Math.max(max, dp[x][y]);
        }

        return max;
    }

    // Topo Sorting time: O(mnlog(mn)) space: O(mn)
    public static int longestIncreasingPath_toposort(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] outDegrees = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int[] dir : dirs) {
                    int nextX = i + dir[0];
                    int nextY = j + dir[1];

                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || matrix[nextX][nextY] <= matrix[i][j]) {
                        continue;
                    }

                    // 只要旁边节点的值比它大，它的出度就加1
                    outDegrees[i][j]++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (outDegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int max = 0;
        while (!queue.isEmpty()) {
            max++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                int x = curPos[0];
                int y = curPos[1];
                for (int[] dir : dirs) {
                    int prevX = x + dir[0];
                    int prevY = y + dir[1];

                    if (prevX < 0 || prevX >= row || prevY < 0 || prevY >= col) {
                        continue;
                    }

                    if (matrix[prevX][prevY] >= matrix[x][y]) {
                        continue;
                    }

                    if (--outDegrees[prevX][prevY] == 0) {
                        queue.offer(new int[]{prevX, prevY});
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + longestIncreasingPath_bfs(new int[][]{{1}}));
        System.out.println("4 ?= " + longestIncreasingPath_bfs(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println("4 ?= " + longestIncreasingPath_bfs(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
        System.out.println("6 ?= " + longestIncreasingPath_bfs(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}));

        System.out.println("6 ?= " + longestIncreasingPath_bfs_opt(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}));

        System.out.println("4 ?= " + longestIncreasingPath_memo(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println("6 ?= " + longestIncreasingPath_memo(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}));

        System.out.println("4 ?= " + longestIncreasingPath_dp(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println("6 ?= " + longestIncreasingPath_dp(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}));

        System.out.println("4 ?= " + longestIncreasingPath_toposort(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println("6 ?= " + longestIncreasingPath_toposort(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}));
    }
}

/*
7 8 9
9 7 6
7 2 3
*/
