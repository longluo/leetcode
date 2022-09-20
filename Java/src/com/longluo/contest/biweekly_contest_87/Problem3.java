package com.longluo.contest.biweekly_contest_87;

import java.util.Arrays;

public class Problem3 {

    //
    // TLE
    public static int[] smallestSubarrays(int[] nums) {
        int len = nums.length;

        int[] ans = new int[len];
        Arrays.fill(ans, 1);

        for (int i = 0; i < len; i++) {
            int max = nums[i];
            int bitwiseOr = nums[i];
            for (int j = i + 1; j < len; j++) {
                bitwiseOr |= nums[j];
                if (bitwiseOr > max) {
                    max = bitwiseOr;
                    ans[i] = j - i + 1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3, 3, 2, 2, 1] ?= " + Arrays.toString(smallestSubarrays(new int[]{1, 0, 2, 1, 3})));
        System.out.println("[2, 1] ?= " + Arrays.toString(smallestSubarrays(new int[]{1, 2})));
    }
}
