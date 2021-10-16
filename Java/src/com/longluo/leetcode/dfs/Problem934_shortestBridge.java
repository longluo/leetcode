package com.longluo.leetcode.dfs;

/**
 * 934. 最短的桥
 * <p>
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * <p>
 * 示例 1：
 * 输入：[[0,1],[1,0]]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 或 A[i][j] == 1
 * <p>
 * https://leetcode-cn.com/problems/shortest-bridge/
 */
public class Problem934_shortestBridge {

    public static int shortestBridge(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 2;
                }
            }
        }

        boolean[][] visited = new boolean[row][col];


        return 0;
    }

    public static int dfs(int[][] A, boolean[][] visited, int x, int y, int step) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = A.length;
        int col = A[0].length;

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + shortestBridge(new int[][]{{0, 1}, {1, 0}}));
        System.out.println("2 ?= " + shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println("1 ?= " + shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}}));
    }
}
