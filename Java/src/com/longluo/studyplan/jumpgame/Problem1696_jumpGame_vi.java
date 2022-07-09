package com.longluo.studyplan.jumpgame;

import java.util.Arrays;

/**
 * 1696. 跳跃游戏 VI
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。
 * 也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * 请你返回你能得到的 最大得分 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * <p>
 * 示例 2：
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * <p>
 * 示例 3：
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length, k <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/jump-game-vi/
 */
public class Problem1696_jumpGame_vi {

    // DP time: O(nk) space: O(n)
    // TLE
    public static int maxResult(int[] nums, int k) {
        int len = nums.length;

        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
            for (int j = Math.max(i - k, 0); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println("17 ?= " + maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
    }
}
