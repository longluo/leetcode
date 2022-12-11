package com.longluo.contest.weekly_contest_323;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-323
 */

/**
 * https://leetcode.cn/problems/longest-square-streak-in-an-array/
 */
public class Problem2 {

    public static int longestSquareStreak(int[] nums) {
        int len = nums.length;

        int ans = -1;

        Set<Long> set = new HashSet<>();
        for (int x : nums) {
            set.add((long) x);
        }

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            long square = (long) cur * cur;
            int cnt = 1;
            while (set.contains(square)) {
                cnt++;
                square = square * square;
            }

            if (cnt >= 2) {
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2}));
        System.out.println("-1 ?= " + longestSquareStreak(new int[]{2, 3, 5, 6, 7}));

    }
}
