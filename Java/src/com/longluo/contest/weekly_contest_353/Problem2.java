package com.longluo.contest.weekly_contest_353;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-353
 */
public class Problem2 {

    public static int maximumJumps(int[] nums, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int ans = 0;

        boolean flag = false;

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();

                if (idx == nums.length - 1) {
                    flag = true;
                    ans = Math.max(ans, step);
                }

                for (int j = idx + 1; j < nums.length; j++) {
                    if (Math.abs(nums[j] - nums[idx]) <= target) {
                        queue.offer(j);
                    }
                }
            }

            step++;
        }

        return flag ? ans : -1;
    }

    public static int maximumJumps_opt(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        dp[n - 1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = Math.abs(nums[j] - nums[i]);
                if (diff <= target && dp[i] >= 0) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + maximumJumps(new int[]{1, 2, 3, 0}, 1));
        System.out.println("-1 ?= " + maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0));
        System.out.println("3 ?= " + maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
        System.out.println("5 ?= " + maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3));

        System.out.println("1 ?= " + maximumJumps_opt(new int[]{1, 2, 3, 0}, 1));
        System.out.println("-1 ?= " + maximumJumps_opt(new int[]{1, 3, 6, 4, 1, 2}, 0));
        System.out.println("3 ?= " + maximumJumps_opt(new int[]{1, 3, 6, 4, 1, 2}, 2));
        System.out.println("5 ?= " + maximumJumps_opt(new int[]{1, 3, 6, 4, 1, 2}, 3));
    }
}
