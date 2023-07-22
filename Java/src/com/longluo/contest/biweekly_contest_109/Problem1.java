package com.longluo.contest.biweekly_contest_109;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-109
 */
public class Problem1 {

    public static boolean isGood(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int n = nums[len - 1];
        if (n != len - 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isGood(new int[]{1, 1}));
        System.out.println("false ?= " + isGood(new int[]{2, 1, 3}));
        System.out.println("true ?= " + isGood(new int[]{1, 3, 3, 2}));
    }
}
