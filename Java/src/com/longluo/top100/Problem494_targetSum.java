package com.longluo.top100;

/**
 * 494. 目标和
 * <p>
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 * <p>
 * https://leetcode.com/problems/target-sum/
 */
public class Problem494_targetSum {

    // DP time: O(n) space: O(n)
    public static int findTargetSumWays_dp(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 == 1) {
            return 0;
        }

        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int i = neg; i >= x; i--) {
                dp[i] = dp[i] + dp[i - x];
            }
        }

        return dp[neg];
    }

    // DFS time: O(2^n) space: O(n)
    public static int findTargetSumWays_dfs(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    public static int dfs(int[] nums, int index, int current, int target) {
        if (current == target && index == nums.length) {
            return 1;
        }

        if (index >= nums.length) {
            return 0;
        }

        int plus = dfs(nums, index + 1, current + nums[index], target);
        int minus = dfs(nums, index + 1, current - nums[index], target);
        return plus + minus;
    }

    // Backtracking time: O(2^n) space: O(n)
    static int count = 0;

    public static int findTargetSumWays_backtrack(int[] nums, int target) {
        count = 0;
        backtrack(nums, 0, target);
        return count;
    }

    public static void backtrack(int[] nums, int idx, int remain) {
        if (idx == nums.length) {
            count += remain == 0 ? 1 : 0;
            return;
        }

        backtrack(nums, idx + 1, remain + nums[idx]);
        backtrack(nums, idx + 1, remain - nums[idx]);
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + findTargetSumWays_dp(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("1 ?= " + findTargetSumWays_dp(new int[]{1}, 1));
        System.out.println("0 ?= " + findTargetSumWays_dp(new int[]{100}, -200));

        System.out.println("5 ?= " + findTargetSumWays_dfs(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("5 ?= " + findTargetSumWays_backtrack(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("1 ?= " + findTargetSumWays_dfs(new int[]{1}, 1));
        System.out.println("1 ?= " + findTargetSumWays_backtrack(new int[]{1}, 1));
    }
}
