package com.longluo.contest.weekly_contest_349;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-349
 */
public class Problem1 {

    public static int findNonMinOrMax(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        for (int x : nums) {
            if (x != min && x != max) {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findNonMinOrMax(new int[]{3, 2, 1, 4}));

    }
}
