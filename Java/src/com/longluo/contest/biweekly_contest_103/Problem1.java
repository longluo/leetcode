package com.longluo.contest.biweekly_contest_103;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-103
 */
public class Problem1 {

    public static int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();

        int ans = 0;

        for (int i = 0; i < k; i++) {
            ans += max;
            max++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("18 ?= " + maximizeSum(new int[]{1, 2, 3, 4, 5}, 3));
    }
}
