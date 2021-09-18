package com.longluo.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标[0, 0] 到坐标[m-1, n-1]。一个机器人从坐标[0, 0]的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37]，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class Offer13_movingCount {

    public static int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                for (int j = 0; j < dirs.length; j++) {
                    int nextX = currPos[0] + dirs[j][0];
                    int nextY = currPos[1] + dirs[j][1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }
                    if (getSum(nextX, nextY) <= k && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public static int getSum(int x, int y) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }

        while (y > 0) {
            ans += y % 10;
            y /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + getSum(11, 12));
        System.out.println("3 ?= " + movingCount(2, 3, 1));
        System.out.println("1 ?= " + movingCount(3, 1, 0));
    }
}
