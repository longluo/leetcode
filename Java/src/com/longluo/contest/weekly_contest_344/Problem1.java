package com.longluo.contest.weekly_contest_344;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-344
 */
public class Problem1 {

    public static int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            Set<Integer> prev = new HashSet<>();
            Set<Integer> back = new HashSet<>();

            for (int j = 0; j <= i; j++) {
                prev.add(nums[j]);
            }

            for (int j = i + 1; j < n; j++) {
                back.add(nums[j]);
            }

            ans[i] = prev.size() - back.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[-3, -1, 1, 3, 5] ?= " + Arrays.toString(distinctDifferenceArray(new int[]{1, 2, 3, 4, 5})));
    }
}
