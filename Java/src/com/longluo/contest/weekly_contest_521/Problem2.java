package com.longluo.contest.weekly_contest_521;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-521
 */
public class Problem2 {

    public static int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;

        Map<Long, Integer> pairCntMap = new HashMap<>();

        int base = 0;

        for (int i = 0; i < n - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];

            if (a == b) {
                base++;
            } else {
                int x = Math.min(a, b);
                int y = Math.max(a, b);

                long key = ((long) x << 32) ^ (y & 0xffffffffL);

                pairCntMap.merge(key, 1, Integer::sum);
            }
        }

        Map<Integer, Integer> best = new HashMap<>();

        for (Map.Entry<Long, Integer> entry : pairCntMap.entrySet()) {
            long key = entry.getKey();
            int value = entry.getValue();

            int x = (int) (key >> 32);
            int y = (int) key;

            best.merge(x, value, Math::max);
            best.merge(y, value, Math::max);
        }

        int exchangeGain = 0;
        for (int value : best.values()) {
            exchangeGain = Math.max(exchangeGain, value);
        }

        return base + exchangeGain;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maxEqualAdjacentPairs(new int[]{1, 2, 3, 2}));
        System.out.println("4 ?= " + maxEqualAdjacentPairs(new int[]{1, 2, 1, 2, 1}));
        System.out.println("2 ?= " + maxEqualAdjacentPairs(new int[]{1, 1, 1}));
    }
}
