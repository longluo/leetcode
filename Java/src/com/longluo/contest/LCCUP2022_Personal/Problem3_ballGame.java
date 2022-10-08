package com.longluo.contest.LCCUP2022_Personal;

import java.util.*;

/**
 * LCP 63. 弹珠游戏
 * <p>
 * 欢迎各位来到「力扣嘉年华」，接下来将为各位介绍在活动中广受好评的弹珠游戏。
 * <p>
 * N*M 大小的弹珠盘的初始状态信息记录于一维字符串型数组 plate 中，数组中的每个元素为仅由 "O"、"W"、"E"、"." 组成的字符串。
 * <p>
 * 其中：
 * "O" 表示弹珠洞（弹珠到达后会落入洞中，并停止前进）；
 * "W" 表示逆时针转向器（弹珠经过时方向将逆时针旋转 90 度）；
 * "E" 表示顺时针转向器（弹珠经过时方向将顺时针旋转 90 度）；
 * "." 表示空白区域（弹珠可通行）。
 * <p>
 * 游戏规则要求仅能在边缘位置的 空白区域 处（弹珠盘的四角除外）沿 与边缘垂直 的方向打入弹珠，并且打入后的每颗弹珠最多能 前进 num 步。请返回符合上述要求且可以使弹珠最终入洞的所有打入位置。你可以 按任意顺序 返回答案。
 * <p>
 * 注意：
 * 若弹珠已到达弹珠盘边缘并且仍沿着出界方向继续前进，则将直接出界。
 * <p>
 * 示例 1：
 * 输入：
 * num = 4
 * plate = ["..E.",".EOW","..W."]
 * <p>
 * 输出：[[2,1]]
 * <p>
 * 解释：
 * 在 [2,1] 处打入弹珠，弹珠前进 1 步后遇到转向器，前进方向顺时针旋转 90 度，再前进 1 步进入洞中。
 * <p>
 * 示例 2：
 * 输入：
 * num = 5
 * plate = [".....","..E..",".WO..","....."]
 * <p>
 * 输出：[[0,1],[1,0],[2,4],[3,2]]
 * <p>
 * 解释：
 * 在 [0,1] 处打入弹珠，弹珠前进 2 步，遇到转向器后前进方向逆时针旋转 90 度，再前进 1 步进入洞中。
 * 在 [1,0] 处打入弹珠，弹珠前进 2 步，遇到转向器后前进方向顺时针旋转 90 度，再前进 1 步进入洞中。
 * 在 [2,4] 处打入弹珠，弹珠前进 2 步后进入洞中。
 * 在 [3,2] 处打入弹珠，弹珠前进 1 步后进入洞中。
 * <p>
 * 示例 3：
 * 输入：
 * num = 3
 * plate = [".....","....O","....O","....."]
 * 输出：[]
 * <p>
 * 解释：
 * 由于弹珠被击中后只能前进 3 步，且不能在弹珠洞和弹珠盘四角打入弹珠，故不存在能让弹珠入洞的打入位置。
 * <p>
 * 提示：
 * 1 <= num <= 10^6
 * 1 <= plate.length, plate[i].length <= 1000
 * plate[i][j] 仅包含 "O"、"W"、"E"、"."
 * <p>
 * https://leetcode.cn/problems/EXvqDp/
 */
public class Problem3_ballGame {

    // BFS time: O(m^2n^2) space: O(mn)
    public static int[][] ballGame(int num, String[] plate) {
        int rows = plate.length;
        int cols = plate[0].length();

        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = plate[i].charAt(j);
            }
        }

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == cols - 1)
                        || (i == rows - 1 && j == 0) || (i == rows - 1 && j == cols - 1)) {
                    continue;
                }

                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (grid[i][j] == '.' && bfs(grid, i, j, num)) {
                        ans.add(new int[]{i, j});
                    }
                }
            }
        }

        if (ans.size() == 0) {
            return new int[][]{};
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private static boolean bfs(char[][] grid, int x, int y, int maxSteps) {
        int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        int m = grid.length;
        int n = grid[0].length;

        int dir = -1;

        if (x == 0) {
            dir = 3;
        } else if (x == m - 1) {
            dir = 1;
        } else if (y == 0) {
            dir = 0;
        } else {
            dir = 2;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, dir});

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (step > maxSteps) {
                break;
            }

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                if (grid[curPos[0]][curPos[1]] == 'O') {
                    return true;
                }

                dir = curPos[2];

                int nextX = curPos[0] + directions[dir][0];
                int nextY = curPos[1] + directions[dir][1];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }

                if (grid[nextX][nextY] == 'W') {
                    dir = (dir + 1) % 4;
                } else if (grid[nextX][nextY] == 'E') {
                    dir = (dir - 1 + 4) % 4;
                }

                queue.offer(new int[]{nextX, nextY, dir});
            }

            step++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("[[2, 1]] ?= " + Arrays.deepToString(ballGame(4, new String[]{"..E.", ".EOW", "..W."})));
        System.out.println("[[0, 1], [1, 0], [2, 4], [3, 2]] ?= " + Arrays.deepToString(ballGame(5, new String[]{".....", "..E..", ".WO..", "....."})));
    }
}
