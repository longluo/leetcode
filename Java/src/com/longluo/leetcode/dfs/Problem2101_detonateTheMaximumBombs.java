package com.longluo.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2101. 引爆最多的炸弹
 * <p>
 * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
 * <p>
 * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。
 * xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
 * <p>
 * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，
 * 这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
 * <p>
 * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
 * <p>
 * 示例 1：
 * 输入：bombs = [[2,1,3}, {6,1,4]]
 * 输出：2
 * 解释：
 * 上图展示了 2 个炸弹的位置和爆炸范围。
 * 如果我们引爆左边的炸弹，右边的炸弹不会被影响。
 * 但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
 * 所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
 * <p>
 * 示例 2：
 * 输入：bombs = [[1,1,5}, {10,10,5]]
 * 输出：1
 * 解释：
 * 引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
 * <p>
 * 示例 3：
 * 输入：bombs = [[1,2,3}, {2,3,1}, {3,4,2}, {4,5,3}, {5,6,4]]
 * 输出：5
 * 解释：
 * 最佳引爆炸弹为炸弹 0 ，因为：
 * - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
 * - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
 * - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
 * 所以总共有 5 个炸弹被引爆。
 * <p>
 * 提示：
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 105
 * <p>
 * https://leetcode.cn/problems/detonate-the-maximum-bombs/
 */
public class Problem2101_detonateTheMaximumBombs {

    // BFS time: O(n^3) space: O(n)
    public static int maximumDetonation(int[][] bombs) {
        int max = 1;

        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, bfs(bombs, i));
        }

        return max;
    }

    private static int bfs(int[][] bombs, int detonateBomb) {
        int n = bombs.length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(bombs[detonateBomb]);

        boolean[] visited = new boolean[n];
        visited[detonateBomb] = true;

        int ans = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curBomb = queue.poll();

                int x = curBomb[0];
                int y = curBomb[1];
                int r = curBomb[2];

                for (int j = 0; j < n; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    int nextX = bombs[j][0];
                    int nextY = bombs[j][1];

                    long dist = (long) (x - nextX) * (x - nextX) + (long) (y - nextY) * (y - nextY);

                    if (dist <= (long) r * r) {
                        ans++;
                        visited[j] = true;
                        queue.offer(bombs[j]);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maximumDetonation(new int[][]{{2, 1, 3}, {6, 1, 4}}));
        System.out.println("1 ?= " + maximumDetonation(new int[][]{{1, 1, 100000}, {100000, 100000, 1}}));
        System.out.println("1 ?= " + maximumDetonation(new int[][]{{1, 1, 5}, {10, 10, 5}}));
        System.out.println("5 ?= " + maximumDetonation(new int[][]{{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}}));
        System.out.println("3 ?= " + maximumDetonation(new int[][]{{38496, 37528, 4845}, {46272, 98187, 1365}, {70550, 7578, 3223}, {77200, 18005, 7272}, {7648, 58155, 7628}, {95708, 33470, 1889}, {20157, 92266, 9823}, {52803, 2765, 6751}, {50429, 63049, 3002}, {72582, 69729, 2281}, {49317, 35327, 1922}, {715, 8902, 9620}, {21154, 58349, 8544}, {43935, 46296, 6868}, {7881, 24144, 2372}, {95258, 97730, 6554}, {5525, 56971, 9191}, {95762, 81415, 2027}, {62518, 75469, 1330}, {83660, 4341, 6817}, {30268, 38781, 8309}, {97922, 20474, 4047}, {39466, 40057, 2061}, {91983, 24242, 5451}, {92380, 31509, 8446}, {12436, 8897, 5279}, {28386, 8556, 4702}, {54672, 88180, 1106}, {17843, 95337, 4420}, {21956, 49924, 1839}}));
    }
}
