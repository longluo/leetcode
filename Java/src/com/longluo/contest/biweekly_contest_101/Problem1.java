package com.longluo.contest.biweekly_contest_101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-101
 */
public class Problem1 {

    public static int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ans = Math.min(nums1[0], nums2[0]) * 10;
        if (nums1[0] < nums2[0]) {
            ans += nums2[0];
        } else {
            ans += nums1[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }

        for (int x : nums2) {
            if (set.contains(x)) {
                ans = Math.min(ans, x);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
