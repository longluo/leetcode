package com.longluo.contest.biweekly_contest_96;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-96
 */
public class Problem1 {

    public static int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int x : nums1) {
            set.add(x);
        }

        int ans = 0;

        for (int x : nums2) {
            if (set.contains(x)) {
                if (ans == 0) {
                    ans = x;
                } else {
                    ans = Math.min(ans, x);
                }
            }
        }

        return ans == 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
    }
}
