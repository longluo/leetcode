package com.longluo.contest.weekly_contest_332;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-332
 */
public class Problem2 {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static long countFairPairs_bf(int[] nums, int lower, int upper) {
        int n = nums.length;

        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= lower && sum <= upper) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // HashMap time: O(n) space: O(n)
    public static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int x : nums) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        if (countMap.size() == 1 && nums[0] >= lower && nums[0] <= upper) {
            return (long) n * (n - 1) / 2;
        }

        long ans = 0;

        for (int x : countMap.keySet()) {
            int left = lower - x;
            int right = upper - x;

            for (int y : countMap.keySet()) {
                if (y >= left && y <= right) {
                    if (x == y) {
                        ans += (long) countMap.get(x) * (countMap.get(x) - 1) / 2;
                    } else {
                        ans += (long) countMap.get(x) * countMap.get(y);
                    }
                }
            }
        }

        return ans / 2;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + countFairPairs_bf(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));

        System.out.println("6 ?= " + countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
        System.out.println("15 ?= " + countFairPairs(new int[]{0, 0, 0, 0, 0, 0}, 0, 0));
        System.out.println("6 ?= " + countFairPairs(new int[]{-2, -6, 4, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -15, 15));
    }
}
