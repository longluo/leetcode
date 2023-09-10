package com.longluo.contest.biweekly_contest_108;

/**
 * https://leetcode.cn/contest/biweekly-contest-108
 */
public class Problem1 {

    public static int alternatingSubarray(int[] nums) {
        int n = nums.length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = nums[i];
            int cnt = 0;
            int step = 1;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] != prev + step) {
                    break;
                }

                prev = nums[j];
                cnt++;
                step *= -1;
            }

            if (cnt > 0) {
                ans = Math.max(ans, cnt + 1);
            }
        }

        return ans == 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + alternatingSubarray(new int[]{4, 5, 6}));
        System.out.println("4 ?= " + alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }
}
