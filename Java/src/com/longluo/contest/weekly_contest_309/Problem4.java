package com.longluo.contest.weekly_contest_309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {

    static int max = 1;

    public static int lengthOfLIS_(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        max = 1;
        backtrack(nums, new ArrayList<>(), 0, k);
        return max;
    }

    private static void backtrack(int[] nums, List<Integer> path, int index, int k) {
        max = Math.max(max, path.size());

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (path.size() > 0 && (nums[i] <= path.get(path.size() - 1) || nums[i] - k >= path.get(path.size() - 1))) {
                continue;
            }

            path.add(nums[i]);
            backtrack(nums, path, i + 1, k);
            path.remove(path.size() - 1);
        }
    }

    public static int lengthOfLIS(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int max = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && nums[i] <= nums[j] + k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static int lengthOfLIS_opt(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int max = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && nums[i] <= nums[j] + k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + lengthOfLIS_(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));
        System.out.println("5 ?= " + lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));
    }
}
