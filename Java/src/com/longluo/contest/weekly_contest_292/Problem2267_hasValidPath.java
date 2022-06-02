package com.longluo.contest.weekly_contest_292;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2267. 检查是否有合法括号字符串路径
 * <p>
 * 一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。
 * <p>
 * 字符串是 () 。
 * 字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。
 * 字符串可以表示为 (A) ，其中 A 是合法括号序列。
 * 给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径：
 * <p>
 * 路径开始于左上角格子 (0, 0) 。
 * 路径结束于右下角格子 (m - 1, n - 1) 。
 * 路径每次只会向 下 或者向 右 移动。
 * 路径经过的格子组成的括号字符串是 合法 的。
 * 如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
 * 输出：true
 * 解释：上图展示了两条路径，它们都是合法括号字符串路径。
 * 第一条路径得到的合法字符串是 "()(())" 。
 * 第二条路径得到的合法字符串是 "((()))" 。
 * 注意可能有其他的合法括号字符串路径。
 * <p>
 * 示例 2：
 * 输入：grid = [[")",")"],["(","("]]
 * 输出：false
 * 解释：两条可行路径分别得到 "))(" 和 ")((" 。由于它们都不是合法括号字符串，我们返回 false 。
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 要么是 '(' ，要么是 ')' 。
 * <p>
 * https://leetcode.cn/problems/check-if-there-is-a-valid-parentheses-string-path/
 */
public class Problem2267_hasValidPath {

    // TODO: 2022/6/2
    public boolean hasValidPath(char[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return false;
        }

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int[][] dirs = {{1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        StringBuilder sb = new StringBuilder();
        sb.append(grid[0][0]);
        Queue<StringBuilder> strQueue = new LinkedList<>();
        strQueue.offer(sb);
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            StringBuilder curStr = strQueue.poll();
            for (int[] dir : dirs) {
                int nextX = pos[0] + dir[0];
                int nextY = pos[1] + dir[1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length
                        && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return false;
    }

    public static boolean check(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        int len = str.length();
        if (len % 2 == 1) {
            return false;
        }

        int cnt = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }

        return cnt == 0;
    }

    public static void main(String[] args) {

    }
}
