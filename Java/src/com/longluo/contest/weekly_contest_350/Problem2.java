package com.longluo.contest.weekly_contest_350;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-350
 */
public class Problem2 {

    public static int findValueOfPartition(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + findValueOfPartition(new int[]{1, 5}));
        System.out.println("1 ?= " + findValueOfPartition(new int[]{1, 3, 2, 4}));
        System.out.println("9 ?= " + findValueOfPartition(new int[]{100, 1, 10}));
    }
}
