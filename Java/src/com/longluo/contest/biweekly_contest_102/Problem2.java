package com.longluo.contest.biweekly_contest_102;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-102
 */
public class Problem2 {

    public static long[] findPrefixScore(int[] nums) {
        int n = nums.length;

        int max = nums[0];

        int[] maxArray = new int[n];

        maxArray[0] = nums[0] * 2;

        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxArray[i] = max + nums[i];
        }

        long[] ans = new long[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += maxArray[i];
            ans[i] = sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[4, 10, 24, 36, 56] ?= " + Arrays.toString(findPrefixScore(new int[]{2, 3, 7, 5, 10})));
        System.out.println("[2, 4, 8, 16, 32, 64] ?= " + Arrays.toString(findPrefixScore(new int[]{1, 1, 2, 4, 8, 16})));
    }
}
