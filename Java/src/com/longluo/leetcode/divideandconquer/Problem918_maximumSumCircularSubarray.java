package com.longluo.leetcode.divideandconquer;

/**
 * 918. 环形子数组的最大和
 * <p>
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * <p>
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ，
 * nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，
 * 不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * <p>
 * 示例 2：
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * <p>
 * 示例 3：
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * <p>
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */
public class Problem918_maximumSumCircularSubarray {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int maxSubarraySumCircular_bf(int[] nums) {
        int len = nums.length;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int step = 0; step < len; step++) {
                sum += nums[(i + step) % len];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxSubarraySumCircular_bf(new int[]{1, -2, 3, -2}));
        System.out.println("10 ?= " + maxSubarraySumCircular_bf(new int[]{5, -3, 5}));
    }
}
