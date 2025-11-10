package com.longluo.contest.weekly_contest_369;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-369
 */
public class Problem1 {

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            int bits = Integer.bitCount(i);
            if (bits == k) {
                ans += nums.get(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println("13 ?= " + sumIndicesWithKSetBits(Arrays.asList(new int[]{5, 10, 1, 5, 2}), 1));
    }
}
