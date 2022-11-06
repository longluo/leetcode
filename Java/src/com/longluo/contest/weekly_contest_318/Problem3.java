package com.longluo.contest.weekly_contest_318;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/total-cost-to-hire-k-workers/
 */
public class Problem3 {

    // Simulate time: O(km) space: O(n)
    // TLE
    public static long totalCost(int[] costs, int k, int candidates) {
        List<Integer> list = new ArrayList<>();
        for (int x : costs) {
            list.add(x);
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            int len = list.size();

            int min = list.get(0);
            int idx = 0;

            for (int j = 0; j < candidates && j < len; j++) {
                if (list.get(j) < min) {
                    min = list.get(j);
                    idx = j;
                } else if (list.get(j) == min) {
                    idx = Math.min(idx, j);
                }
            }

            for (int j = len - 1; j >= len - candidates && j >= 0; j--) {
                if (list.get(j) < min) {
                    min = list.get(j);
                    idx = j;
                } else if (list.get(j) == min) {
                    idx = Math.min(idx, j);
                }
            }

            ans += min;
            list.remove(idx);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("11 ?= " + totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println("4 ?= " + totalCost(new int[]{1, 2, 4, 1}, 3, 3));
    }
}
