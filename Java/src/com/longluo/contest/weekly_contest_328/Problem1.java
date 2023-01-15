package com.longluo.contest.weekly_contest_328;

/**
 * https://leetcode.cn/contest/weekly-contest-328
 */
public class Problem1 {

    public static int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;

        for (int x : nums) {
            sum += x;

            while (x > 0) {
                digitSum += x % 10;
                x /= 10;
            }
        }

        return Math.abs(sum - digitSum);
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + differenceOfSum(new int[]{1, 15, 6, 3}));
        System.out.println("0 ?= " + differenceOfSum(new int[]{1, 2, 3, 4}));
    }
}
