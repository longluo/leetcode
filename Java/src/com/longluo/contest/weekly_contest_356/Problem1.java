package com.longluo.contest.weekly_contest_356;

/**
 * https://leetcode.cn/contest/weekly-contest-356
 */
public class Problem1 {

    // Simulate time: O(n) space: O(1)
    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;

        for (int x : hours) {
            if (x >= target) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numberOfEmployeesWhoMetTarget(new int[]{0, 1, 2, 3, 4}, 2));
        System.out.println("0 ?= " + numberOfEmployeesWhoMetTarget(new int[]{5, 1, 4, 2, 2}, 6));
    }
}
