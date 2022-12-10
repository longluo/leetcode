package com.longluo.contest.biweekly_contest_93;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-93
 */

public class Problem2 {

    public static int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;

        int max = Arrays.stream(vals).max().getAsInt();

        if (k == 0) {
            return max;
        }

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = graph[i];

            Collections.sort(neighbors, (a, b) -> vals[b] - vals[a]);

            int sum = vals[i];
            for (int j = 0; j < neighbors.size() && j < k; j++) {
                sum += vals[neighbors.get(j)];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println("-5 ?= " + maxStarSum(new int[]{-5}, new int[][]{{}}, 0));
        System.out.println("0 ?= " + maxStarSum(new int[]{-1, 0}, new int[][]{}, 1));
        System.out.println("16 ?= " + maxStarSum(new int[]{1, 2, 3, 4, 10, -10, -20}, new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}, {3, 5}, {3, 6}}, 2));
    }
}
