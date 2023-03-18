package com.longluo.contest.biweekly_contest_100;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-100
 */
public class Problem2 {

    public static int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        if (nums[0] == nums[n - 1]) {
            return 0;
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            while (ans + i < n && nums[i] == nums[i + ans]) {
                ans++;
            }
        }

        return n - ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maximizeGreatness(new int[]{1, 2, 3, 4}));
        System.out.println("4 ?= " + maximizeGreatness(new int[]{1, 3, 5, 2, 1, 3, 1}));   // 1 1 1 2 3 3 5
        System.out.println("6 ?= " + maximizeGreatness(new int[]{42, 8, 75, 28, 35, 21, 13, 21})); //
    }
}
