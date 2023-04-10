package com.longluo.contest.weekly_contest_340;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-340
 */
public class Problem2 {

    // BF time: O(n^2) space: O(n)
    // TLE
    public static long[] distance_bf(int[] nums) {
        int n = nums.length;

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j] && i != j) {
                    sum += Math.abs(i - j);
                }
            }

            ans[i] = sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[5, 0, 3, 4, 0] ?= " + Arrays.toString(distance_bf(new int[]{1, 3, 1, 1, 2})));
        System.out.println("[0, 0, 0] ?= " + Arrays.toString(distance_bf(new int[]{0, 5, 3})));
    }
}
