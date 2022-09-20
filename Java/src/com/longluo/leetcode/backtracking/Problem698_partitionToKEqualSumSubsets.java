package com.longluo.leetcode.backtracking;

import java.util.*;

/**
 * 698. 划分为k个相等的子集
 * <p>
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 示例 2:
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 * <p>
 * 提示：
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 * <p>
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */
public class Problem698_partitionToKEqualSumSubsets {

    // Backtrack time: O(k^n) space: O(n)
    // TLE
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % k != 0) {
            return false;
        }

        int[] ans = new int[k];
        Arrays.fill(ans, sum / k);

        return backtrack(nums, ans, 0, k);
    }

    private static boolean backtrack(int[] nums, int[] res, int idx, int k) {
        if (idx == nums.length) {
            for (int x : res) {
                if (x != 0) {
                    return false;
                }
            }

            return true;
        }

        boolean flag = false;
        for (int i = 0; i < k; i++) {
            if (res[i] < nums[idx]) {
                continue;
            }

            res[i] -= nums[idx];
            if (backtrack(nums, res, idx + 1, k)) {
                flag = true;
                break;
            }
            res[i] += nums[idx];
        }

        return flag;
    }

    // DP
    public static boolean canPartitionKSubsets_dp(int[] nums, int k) {
        int len = nums.length;

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % k != 0) {
            return false;
        }

        boolean[][] dp = new boolean[len + 1][sum / k + 1];


        return dp[len][sum / k];
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
        System.out.println("true ?= " + canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println("false ?= " + canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
        System.out.println("true ?= " + canPartitionKSubsets(new int[]{114, 96, 18, 190, 207, 111, 73, 471, 99, 20, 1037, 700, 295, 101, 39, 649}, 4));
    }
}
