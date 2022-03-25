package com.longluo.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. Two City Scheduling
 * <p>
 * Medium
 * <p>
 * A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti],
 * the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
 * Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
 * <p>
 * Example 1:
 * Input: costs = [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * <p>
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * <p>
 * Example 2:
 * Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * Output: 1859
 * <p>
 * Example 3:
 * Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * Output: 3086
 * <p>
 * Constraints:
 * 2 * n == costs.length
 * 2 <= costs.length <= 100
 * costs.length is even.
 * 1 <= aCosti, bCosti <= 1000
 * <p>
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class Problem1029_twoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int[][] diff = new int[len][2];
        for (int i = 0; i < len; i++) {
            diff[i][0] = i;
            diff[i][1] = costs[i][0] - costs[i][1];
        }

        Arrays.sort(diff, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int ans = 0;
        for (int i = 0; i < len / 2; i++) {
            ans += costs[diff[i][0]][0];
        }

        for (int i = len / 2; i < len; i++) {
            ans += costs[diff[i][0]][1];
        }

        return ans;
    }

    public static int twoCitySchedCost_opt(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int len = costs.length;
        int n = len / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += costs[i][0] + costs[i + n][1];
        }

        return sum;
    }

    public static int twoCitySchedCost_dp(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
            dp[0][i] = dp[0][i - 1] + costs[i - 1][1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }

        return dp[n][n];
    }

    public static int twoCitySchedCost_rec(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[2 * n][2 * n];
        return helper(dp, costs, 0, 0);
    }

    public static int helper(int[][] dp, int[][] costs, int idx, int cityA) {
        if (idx == costs.length) {
            return 0;
        }

        if (dp[idx][cityA] > 0) {
            return dp[idx][cityA];
        }

        int n = costs.length / 2;
        // n persons arrived to second city
        if (idx - cityA == n) {
            return dp[idx][cityA] = costs[idx][0] + helper(dp, costs, idx + 1, cityA + 1);
        } else if (cityA == n) { // n persons arrived to first city
            return dp[idx][cityA] = costs[idx][1] + helper(dp, costs, idx + 1, cityA);
        } else {
            return dp[idx][cityA] = Math.min(costs[idx][1] + helper(dp, costs, idx + 1, cityA), costs[idx][0] + helper(dp, costs, idx + 1, cityA + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("110 ?= " + twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
        System.out.println("110 ?= " + twoCitySchedCost_opt(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
        System.out.println("110 ?= " + twoCitySchedCost_dp(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
        System.out.println("110 ?= " + twoCitySchedCost_rec(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }
}
