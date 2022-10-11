package com.longluo.algo200;

/**
 * 1099. 小于 K 的两数之和
 * <p>
 * 给你一个整数数组 nums 和整数 k ，返回最大和 sum ，满足存在 i < j 使得 nums[i] + nums[j] = sum 且 sum < k 。
 * 如果没有满足此等式的 i,j 存在，则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [34,23,1,24,75,33,54,8], k = 60
 * 输出：58
 * 解释：
 * 34 和 24 相加得到 58，58 小于 60，满足题意。
 * <p>
 * 示例 2：
 * 输入：nums = [10,20,30], k = 15
 * 输出：-1
 * 解释：
 * 我们无法找到和小于 15 的两个元素。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * 1 <= k <= 2000
 * <p>
 * https://leetcode.cn/problems/two-sum-less-than-k/
 */
public class Problem1099_twoSumLessThanK {

    // BF time: O(n^2) space: O(1)
    public static int twoSumLessThanK(int[] nums, int k) {
        int len = nums.length;
        int ans = -1;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];
                if (sum < k) {
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("58 ?= " + twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));
        System.out.println("-1 ?= " + twoSumLessThanK(new int[]{10, 20, 30}, 15));
    }
}
