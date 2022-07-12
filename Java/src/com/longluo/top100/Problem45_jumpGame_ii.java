package com.longluo.top100;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class Problem45_jumpGame_ii {

    // Greedy Reverse time: O(n^2) space: O(n）
    public static int jump_greedy_reverse(int[] nums) {
        int ans = 0;
        int position = nums.length - 1;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    ans++;
                    position = i;
                    break;
                }
            }
        }

        return ans;
    }

    // Greedy time: O(n) space: O(1）
    public static int jump_greedy(int[] nums) {
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }

    // DP time: O(n^2) space: O(n)
    public static int jump_dp(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int minStep = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int steps = nums[i];
            for (int j = 1; j <= steps && i + j < len; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                if (i + j >= len - 1) {
                    minStep = Math.min(minStep, dp[i] + 1);
                    return minStep;
                }
            }
        }

        return minStep;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + jump_greedy_reverse(new int[]{1, 2, 1, 1, 1}));
        System.out.println("2 ?= " + jump_greedy_reverse(new int[]{2, 3, 1, 1, 4}));

        System.out.println("2 ?= " + jump_greedy(new int[]{2, 3, 1, 1, 4}));

        System.out.println("2 ?= " + jump_dp(new int[]{2, 3, 1, 1, 4}));
        System.out.println("3 ?= " + jump_dp(new int[]{1, 2, 1, 1, 1}));
    }
}
