package com.longluo.contest.weekly_contest_312;

import java.util.Arrays;

public class Problem2 {

    public static int longestSubarray(int[] nums) {
        int len = nums.length;
        int ans = 1;
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            int bitAnd = nums[i];
            if (bitAnd > max) {
                ans = 1;
                max = bitAnd;
            }

            for (int j = i + 1; j < len; j++) {
                bitAnd = bitAnd & nums[j];
                if (bitAnd > max) {
                    max = bitAnd;
                    ans = j - i + 1;
                } else if (bitAnd == max) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public static int longestSubarray_dp(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);


        return 0;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + longestSubarray(new int[]{1, 2, 3, 3, 2, 2}));
        System.out.println("1 ?= " + longestSubarray(new int[]{1, 2, 3, 4}));
        System.out.println("7 ?= " + longestSubarray(new int[]{323376, 323376, 323376, 323376, 323376, 323376, 323376, 75940, 75940}))
        ;
    }
}
