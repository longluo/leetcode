package com.longluo.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 909. 蛇梯棋
 * <p>
 * N x N 的棋盘 board 上，按从 1 到 N*N 的数字给方格编号，编号 从左下角开始，每一行交替方向。
 * 例如，一块 6 x 6 大小的棋盘，编号如下：
 * <p>
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
 * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
 * 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
 * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
 * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 * <p>
 * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
 * <p>
 * 示例：
 * 输入：[
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * 输出：4
 * 解释：
 * 首先，从方格 1 [第 5 行，第 0 列] 开始。
 * 你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
 * 然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
 * 然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
 * 然后你决定移动到方格 36, 游戏结束。
 * 可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
 * <p>
 * 提示：
 * n == board.length == board[i].length
 * 2 <= n <= 20
 * grid[i][j] 的值是 -1 或在范围 [1, n^2] 内
 * 编号为 1 和 n^2 的方格上没有蛇或梯子
 * <p>
 * https://leetcode-cn.com/problems/snakes-and-ladders/
 */
public class Problem909_snakesAndLadders {

    // BFS time: O(n^2) space: O(n^2)
    public static int snakesAndLadders(int[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return 0;
        }

        int n = board.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n - 1, 0});

        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;

        int[] target = getPosByIndex(board, n * n);

        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();

                if (curPos[0] == target[0] && curPos[1] == target[1]) {
                    return steps - 1;
                }

                int index = getIndexByPos(board, curPos);

                for (int j = 1; j <= 6; j++) {
                    if (index + j > n * n) {
                        continue;
                    }

                    int[] next = getPosByIndex(board, index + j);

                    if (board[next[0]][next[1]] > 0) {
                        next = getPosByIndex(board, board[next[0]][next[1]]);
                    }

                    if (visited[next[0]][next[1]]) {
                        continue;
                    }

                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    public static int getIndexByPos(int[][] board, int[] pos) {
        int n = board.length;

        int x = pos[0];
        int y = pos[1];

        if (board[x][y] > 0) {
            return board[x][y] + 1;
        }

        int row = n - 1 - pos[0];
        int col = pos[1];
        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        return row * n + col + 1;
    }

    public static int[] getPosByIndex(int[][] board, int index) {
        int n = board.length;

        int[] ans = new int[2];

        int row = (index - 1) / n;
        int col = (index - 1) % n;

        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        ans[0] = n - 1 - row;
        ans[1] = col;

        return ans;
    }

    //
    public static int snakesAndLadders_bfs(int[][] board) {
        int n = board.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});

        boolean[] visited = new boolean[n * n + 1];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 1; i <= 6; ++i) {
                int next = cur[0] + i;

                if (next > n * n) {
                    break;
                }

                int[] rc = id2rc(next, n);

                if (board[rc[0]][rc[1]] > 0) {
                    next = board[rc[0]][rc[1]];
                }

                if (next == n * n) {
                    return cur[1] + 1;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cur[1] + 1});
                }
            }
        }

        return -1;
    }

    public static int[] id2rc(int id, int n) {
        int r = (id - 1) / n;
        int c = (id - 1) % n;

        if (r % 2 == 1) {
            c = n - 1 - c;
        }

        return new int[]{n - 1 - r, c};
    }

    public static int snakesAndLadders_3(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }

        int n = board.length;
        int[] nums = new int[n * n + 1];
        boolean isRight = false;
        int idx = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (!isRight) {
                for (int j = 0; j < n; j++) {
                    nums[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    nums[idx++] = board[i][j];
                }
            }

            isRight = !isRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        queue.offer(1);
        visited[1] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int j = 1; j <= 6; j++) {
                    int next = current + j;
                    if (next > n * n) {
                        break;
                    }

                    if (nums[next] > 0) {
                        next = nums[next];
                    }

                    if (next == n * n) {
                        return step;
                    }

                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
        System.out.println("4 ?= " + snakesAndLadders_bfs(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
        System.out.println("4 ?= " + snakesAndLadders_3(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
        System.out.println("2 ?= " + snakesAndLadders(new int[][]{{-1, 4, -1}, {6, 2, 6}, {-1, 3, -1}}));
        System.out.println("2 ?= " + snakesAndLadders_bfs(new int[][]{{-1, 4, -1}, {6, 2, 6}, {-1, 3, -1}}));
        System.out.println("2 ?= " + snakesAndLadders_3(new int[][]{{-1, 4, -1}, {6, 2, 6}, {-1, 3, -1}}));
        System.out.println("2 ?= " + snakesAndLadders(new int[][]{{-1, -1, 2, 21, -1}, {16, -1, 24, -1, 4}, {2, 3, -1, -1, -1}, {-1, 11, 23, 18, -1}, {-1, -1, -1, 23, -1}}));
        System.out.println("1 ?= " + snakesAndLadders_3(new int[][]{{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}}));

    }
}
