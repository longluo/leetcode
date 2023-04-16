package com.longluo.contest.weekly_contest_341;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-341
 */
public class Problem2 {

    public static int maxDivScore(int[] nums, int[] divisors) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int x : divisors) {
            set.add(x);
        }

        int ans = Arrays.stream(divisors).max().getAsInt();

        int score = 0;

        for (int x : set) {
            int cnt = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (key % x == 0) {
                    cnt += value;
                }
            }

            if (cnt > score) {
                score = cnt;
                ans = x;
            } else if (cnt == score) {
                ans = Math.min(ans, x);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxDivScore(new int[]{4, 7, 9, 3, 9}, new int[]{5, 2, 3}));
        System.out.println("5 ?= " + maxDivScore(new int[]{20, 14, 21, 10}, new int[]{5, 7, 5}));
        System.out.println("10000000 ?= " + maxDivScore(new int[]{1}, new int[]{10000000}));
    }
}
