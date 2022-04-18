package com.longluo.contest.weekly_contest_289;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2245. 转角路径的乘积中最多能有几个尾随零
 * <p>
 * 给你一个二维整数数组 grid ，大小为 m x n，其中每个单元格都含一个正整数。
 * 转角路径 定义为：包含至多一个弯的一组相邻单元。具体而言，路径应该完全 向水平方向 或者 向竖直方向 移动过弯（如果存在弯），
 * 而不能访问之前访问过的单元格。在过弯之后，路径应当完全朝 另一个 方向行进：如果之前是向水平方向，那么就应该变为向竖直方向；
 * 反之亦然。
 * 当然，同样不能访问之前已经访问过的单元格。
 * 一条路径的 乘积 定义为：路径上所有值的乘积。
 * 请你从 grid 中找出一条乘积中尾随零数目最多的转角路径，并返回该路径中尾随零的数目。
 * <p>
 * 注意：
 * 水平 移动是指向左或右移动。
 * 竖直 移动是指向上或下移动。
 * <p>
 * 示例 1：
 * 输入：grid = [[23,17,15,3,20],[8,1,20,27,11],[9,4,6,2,21],[40,9,1,10,6],[22,7,4,5,3]]
 * 输出：3
 * 解释：左侧的图展示了一条有效的转角路径。
 * 其乘积为 15 * 20 * 6 * 1 * 10 = 18000 ，共计 3 个尾随零。
 * 可以证明在这条转角路径的乘积中尾随零数目最多。
 * <p>
 * 中间的图不是一条有效的转角路径，因为它有不止一个弯。
 * 右侧的图也不是一条有效的转角路径，因为它需要重复访问已经访问过的单元格。
 * <p>
 * 示例 2：
 * 输入：grid = [[4,3,2],[7,6,1],[8,8,8]]
 * 输出：0
 * 解释：网格如上图所示。
 * 不存在乘积含尾随零的转角路径。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10^5
 * 1 <= m * n <= 10^5
 * 1 <= grid[i][j] <= 1000
 * <p>
 * https://leetcode-cn.com/problems/maximum-trailing-zeros-in-a-cornered-path/
 */
public class Problem2245_maximumTrailingZerosInACorneredPath {

    public static int maxTrailingZeros(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = grid[i][j];
                if (value % 2 != 0 && value % 5 != 0) {
                    grid[i][j] = 0;
                    continue;
                }

                if (grid[i][j] > 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int zeroNum = bfs(grid, new boolean[row][col], i, j, dir);
                        ans = Math.max(ans, zeroNum);
                    }
                }
            }
        }

        return ans;
    }

    public static int bfs(int[][] grid, boolean[][] visited, int x, int y, int direction) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // hori + verti
        int row = grid.length;
        int col = grid[0].length;
        int cntTwo = getFactor(grid[x][y], 2);
        int cntFive = getFactor(grid[x][y], 5);
        boolean isCorner = false;
        int ans = 0;
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int nextX = pos[0] + dirs[direction][0];
            int nextY = pos[1] + dirs[direction][1];
            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col
                    && !visited[nextX][nextY]) {
                queue.offer(new int[]{nextX, nextY});
                cntTwo += getFactor(grid[nextX][nextY], 2);
                cntFive += getFactor(grid[nextX][nextY], 5);
                ans += Math.min(cntTwo, cntFive);
                visited[nextX][nextY] = true;
            }
        }

        return ans;
    }

    public static int getFactor(int num, int factor) {
        int ans = 0;
        while (num > 0) {
            ans += num / factor;
            num /= factor;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
