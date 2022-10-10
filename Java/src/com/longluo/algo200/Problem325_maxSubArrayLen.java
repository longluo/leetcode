package com.longluo.algo200;

/**
 * 325. 和等于 k 的最长子数组长度
 * <p>
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
 * <p>
 * 示例 1:
 * 输入: nums = [1,-1,5,-2,3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * <p>
 * 示例 2:
 * 输入: nums = [-2,-1,2,1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 10^5
 * -10^4 <= nums[i] <= 10^4
 * -10^9 <= k <= 10^9
 * <p>
 * https://leetcode.cn/problems/maximum-size-subarray-sum-equals-k/
 */
public class Problem325_maxSubArrayLen {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int maxSubArrayLen_bf(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + maxSubArrayLen_bf(new int[]{1, -1, 5, -2, 3}, 3));
    }
}
