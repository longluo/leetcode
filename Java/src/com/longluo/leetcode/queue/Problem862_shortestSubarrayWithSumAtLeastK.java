package com.longluo.leetcode.queue;

/**
 * 862. 和至少为 K 的最短子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。
 * 如果不存在这样的 子数组 ，返回 -1 。
 * <p>
 * 子数组 是数组中 连续 的一部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1], k = 1
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 * 1 <= k <= 10^9
 * <p>
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
 */
public class Problem862_shortestSubarrayWithSumAtLeastK {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int shortestSubarray_bf(int[] nums, int k) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= k) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + shortestSubarray_bf(new int[]{2, -1, 2}, 3));
    }
}
