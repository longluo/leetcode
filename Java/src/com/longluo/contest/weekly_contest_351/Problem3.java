package com.longluo.contest.weekly_contest_351;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-351
 */
public class Problem3 {

    public static int numberOfGoodSubarraySplits(int[] nums) {
        int MOD = 1_000_000_007;

        int n = nums.length;

        List<Integer> onesIdx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                onesIdx.add(i);
            }
        }

        if (onesIdx.size() == 0) {
            return 0;
        }

        List<Integer> zeros = new ArrayList<>();

        for (int i = 0; i < onesIdx.size() - 1; i++) {
            int cnt = onesIdx.get(i + 1) - onesIdx.get(i);
            zeros.add(cnt);
        }

        long ans = 1;

        for (int i = 0; i < zeros.size(); i++) {
            ans *= zeros.get(i);
            ans %= MOD;
        }

        return (int) ans % MOD;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numberOfGoodSubarraySplits(new int[]{0, 1, 0}));
        System.out.println("1 ?= " + numberOfGoodSubarraySplits(new int[]{0, 1, 1}));
        System.out.println("3 ?= " + numberOfGoodSubarraySplits(new int[]{0, 1, 0, 0, 1}));
    }
}
