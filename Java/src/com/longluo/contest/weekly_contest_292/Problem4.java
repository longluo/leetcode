package com.longluo.contest.weekly_contest_292;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem4 {

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
