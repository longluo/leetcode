package com.longluo.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 * <p>
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，
 * 这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。
 * 也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 * 示例 1：
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * <p>
 * 示例 2：
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 * <p>
 * 提示：
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 10^4
 * 0 <= apples[i], days[i] <= 2 * 10^4
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-eaten-apples/
 */
public class Problem1705_eatenApples {

    // TODO: 2022/7/3
    // Failed Not AC
    public static int eatenApples_bf(int[] apples, int[] days) {
        int len = apples.length;
        int ans = 0;
        int[][] sorted = new int[len][2];
        for (int i = 0; i < len; i++) {
            sorted[i][0] = apples[i];
            sorted[i][1] = i + days[i];
        }

        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > 0 && o2[0] > 0) {
                    return o1[1] - o2[1];
                }

                return o1[0] - o2[0];
            }
        });

        int time = 0;
        int idx = 0;
        while (idx < len) {
            while (idx < len && (sorted[idx][0] <= 0 || sorted[idx][1] <= time)) {
                idx++;
            }

            if (idx < len && sorted[idx][1] > time) {
                sorted[idx][0]--;
                ans++;
            }

            time++;
        }

        return ans;
    }

    // Greedy + PriorityQueue time: O(nlogn) space: O(n)
    public static int eatenApples(int[] apples, int[] days) {
        if (apples == null || apples.length == 0 || days == null || days.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int len = apples.length;
        int ans = 0;
        int time = 0;
        while (time < len || !pq.isEmpty()) {
            if (time < len && apples[time] > 0) {
                pq.offer(new int[]{apples[time], days[time] + time});
            }

            while (!pq.isEmpty() && pq.peek()[1] <= time) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                curr[0]--;
                ans++;
                if (curr[0] > 0 && curr[1] > time) {
                    pq.offer(curr);
                }
            }

            time++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + eatenApples_bf(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println("8 ?= " + eatenApples_bf(new int[]{2, 1, 1, 4, 5}, new int[]{10, 10, 6, 4, 2}));
        System.out.println("7 ?= " + eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println("5 ?= " + eatenApples_bf(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
        System.out.println("5 ?= " + eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
    }
}
