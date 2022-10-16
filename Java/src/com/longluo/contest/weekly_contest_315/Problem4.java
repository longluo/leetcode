package com.longluo.contest.weekly_contest_315;

public class Problem4 {

    public static long countSubarrays_bf(int[] nums, int minK, int maxK) {
        long ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (min == minK && max == maxK) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        if (minK > maxK) {
            return 0;
        }

        long ans = 0;
        int len = nums.length;
        long[] dp = new long[len];

        if (nums[0] == minK && nums[0] == maxK) {
            dp[0] = 1;
        }

        for (int i = 1; i < len; i++) {
            if (nums[i] == maxK) {
                dp[i] = 1;
            } else if (nums[i] < maxK) {
                dp[i] = dp[i - 1];
            }
        }

        for (int i = 0; i < len; i++) {
            ans += dp[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println("10 ?= " + countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));
        System.out.println("81 ?= " + countSubarrays(new int[]{35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913}, 35054, 945315));
    }
}
