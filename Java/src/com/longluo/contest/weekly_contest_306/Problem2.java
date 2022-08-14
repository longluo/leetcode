package com.longluo.contest.weekly_contest_306;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

    public static int edgeScore(int[] edges) {
        int n = edges.length;

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0L);
            }

            map.put(edges[i], map.getOrDefault(edges[i], 0L) + i);
        }

        int ans = n + 1;
        long maxScore = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            int nodeIdx = entry.getKey();
            long score = entry.getValue();
            if (score == maxScore) {
                ans = Math.min(ans, nodeIdx);
            } else if (score > maxScore) {
                maxScore = score;
                ans = nodeIdx;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
        System.out.println("0 ?= " + edgeScore(new int[]{2, 0, 0, 2}));
    }
}

