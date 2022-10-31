package com.longluo.contest.biweekly_contest_84;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/count-number-of-bad-pairs/
 */
public class Problem2 {

    // TLE
    public static long countBadPairs(int[] nums) {
        int len = nums.length;
        long ans = 0L;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i != nums[j] - nums[i]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static long countBadPairs_opt(int[] nums) {
        int len = nums.length;

        long sum = (long) len * (len - 1) / 2;

        long goodPair = 0L;

        Map<Integer, Integer> goodMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int diff = nums[i] - i;
            goodMap.put(diff, goodMap.getOrDefault(diff, 0) + 1);
        }

        for (int value : goodMap.values()) {
            if (value > 1) {
                goodPair += (long) (value - 1) * value / 2;
            }
        }

        return sum - goodPair;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + countBadPairs(new int[]{4, 1, 3, 3}));
        System.out.println("0 ?= " + countBadPairs(new int[]{1, 2, 3, 4, 5}));
        System.out.println("0 ?= " + countBadPairs_opt(new int[]{1, 2, 3, 4, 5}));
    }
}

