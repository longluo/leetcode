package com.longluo.contest.weekly_contest_337;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-337
 */
/**
 * https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/
 */
public class Problem3 {

    public static int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        if (n == 1) {
            return 1;
        }

        int ans = n;




        return ans;
    }

    private static void backtrack() {

    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + beautifulSubsets(new int[]{1}, 1));
        System.out.println("4 ?= " + beautifulSubsets(new int[]{2, 4, 6}, 2));
    }
}