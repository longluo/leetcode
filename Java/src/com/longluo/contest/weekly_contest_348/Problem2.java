package com.longluo.contest.weekly_contest_348;

/**
 * https://leetcode.cn/contest/weekly-contest-348
 */
public class Problem2 {

    public static int semiOrderedPermutation(int[] nums) {
        int n = nums.length;

        if (nums[0] == 1 && nums[n - 1] == n) {
            return 0;
        }

        int left = -1;
        int right = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                left = i;
            } else if (nums[i] == n) {
                right = i;
            }
        }

        int ans = left + n - 1 - right;

        if (left < right) {
            return ans;
        } else {
            return ans - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + semiOrderedPermutation(new int[]{3, 2, 1}));
        System.out.println("2 ?= " + semiOrderedPermutation(new int[]{2, 1, 4, 3}));
        System.out.println("3 ?= " + semiOrderedPermutation(new int[]{2, 4, 1, 3}));
        System.out.println("5 ?= " + semiOrderedPermutation(new int[]{4, 2, 3, 1}));
        System.out.println("0 ?= " + semiOrderedPermutation(new int[]{1, 3, 4, 2, 5}));
    }
}
