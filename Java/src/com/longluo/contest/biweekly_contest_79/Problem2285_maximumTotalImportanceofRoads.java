package com.longluo.contest.biweekly_contest_79;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 6085. 道路的最大总重要性
 * <p>
 * 给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
 * <p>
 * 给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 之间有一条 双向 道路。
 * <p>
 * 你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
 * <p>
 * 请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
 * <p>
 * 示例 1：
 * 输入：n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
 * 输出：43
 * 解释：上图展示了国家图和每个城市被安排的值 [2,4,5,3,1] 。
 * - 道路 (0,1) 重要性为 2 + 4 = 6 。
 * - 道路 (1,2) 重要性为 4 + 5 = 9 。
 * - 道路 (2,3) 重要性为 5 + 3 = 8 。
 * - 道路 (0,2) 重要性为 2 + 5 = 7 。
 * - 道路 (1,3) 重要性为 4 + 3 = 7 。
 * - 道路 (2,4) 重要性为 5 + 1 = 6 。
 * 所有道路重要性之和为 6 + 9 + 8 + 7 + 7 + 6 = 43 。
 * 可以证明，重要性之和不可能超过 43 。
 * <p>
 * 示例 2：
 * 输入：n = 5, roads = [[0,3],[2,4],[1,3]]
 * 输出：20
 * 解释：上图展示了国家图和每个城市被安排的值 [4,3,2,5,1] 。
 * - 道路 (0,3) 重要性为 4 + 5 = 9 。
 * - 道路 (2,4) 重要性为 2 + 1 = 3 。
 * - 道路 (1,3) 重要性为 3 + 5 = 8 。
 * 所有道路重要性之和为 9 + 3 + 8 = 20 。
 * 可以证明，重要性之和不可能超过 20 。
 * <p>
 * 提示：
 * 2 <= n <= 5 * 10^4
 * 1 <= roads.length <= 5 * 10^4
 * roads[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 没有重复道路。
 * <p>
 * https://leetcode.cn/problems/maximum-total-importance-of-roads/
 */
public class Problem2285_maximumTotalImportanceofRoads {

    // HashMap + Sort time: O(nlogn) space: O(n)
    public static long maximumImportance(int n, int[][] roads) {
        int[][] cityOrders = new int[n][2];

        for (int i = 0; i < n; i++) {
            cityOrders[i][0] = i;
        }

        for (int[] road : roads) {
            cityOrders[road[0]][1]++;
            cityOrders[road[1]][1]++;
        }

        Arrays.sort(cityOrders, (o1, o2) -> o2[1] - o1[1]);

        Map<Integer, Integer> cityMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cityMap.put(cityOrders[i][0], n - i);
        }

        long max = 0;
        for (int[] road : roads) {
            max += (cityMap.get(road[0]) + cityMap.get(road[1]));
        }

        return max;
    }

    // Greedy time: O(nlogn) space: O(n)
    public static long maximumImportance_greedy(int n, int[][] roads) {
        long[] cities = new long[n];

        for (int[] road : roads) {
            cities[road[0]]++;
            cities[road[1]]++;
        }

        Arrays.sort(cities);

        long ans = 0;
        int value = 1;
        for (int i = 0; i < n; i++) {
            ans += cities[i] * value;
            value++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("43 ?= " + maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
        System.out.println("43 ?= " + maximumImportance_greedy(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
    }
}
