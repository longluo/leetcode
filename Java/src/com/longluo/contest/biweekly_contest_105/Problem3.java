package com.longluo.contest.biweekly_contest_105;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-105
 */
public class Problem3 {

    public static long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;

        Arrays.sort(nums);

        int negCnt = 0;
        int zeroCnt = 0;
        int posCnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negCnt++;
            } else if (nums[i] > 0) {
                posCnt++;
            } else {
                zeroCnt++;
            }
        }

        if (zeroCnt == n || (negCnt == 1 && zeroCnt == n - 1)) {
            return 0;
        }

        long left = 1;
        long right = 1;

        if (negCnt % 2 == 0) {
            if (negCnt > 0) {
                left *= nums[negCnt - 1];
            }
        }

        for (int i = 0; negCnt > 1; i++, negCnt--) {
            left *= nums[i];
        }

        for (int i = n - 1; posCnt > 0; i--, posCnt--) {
            right *= nums[i];
        }

        return left * right;
    }

    public static void main(String[] args) {
        System.out.println("1350 ?= " + maxStrength(new int[]{3, -1, -5, 2, 5, -9}));
        System.out.println("20 ?= " + maxStrength(new int[]{-4, -5, -4}));
        System.out.println("0 ?= " + maxStrength(new int[]{0, -1}));
        System.out.println("0 ?= " + maxStrength(new int[]{0}));
        System.out.println("-9 ?= " + maxStrength(new int[]{-9}));
        System.out.println("432 ?= " + maxStrength(new int[]{-2, -3, 8, 9}));
        System.out.println("432 ?= " + maxStrength(new int[]{9, 6, 3}));
    }
}
