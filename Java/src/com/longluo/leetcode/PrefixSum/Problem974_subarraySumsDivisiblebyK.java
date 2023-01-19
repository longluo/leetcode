package com.longluo.leetcode.PrefixSum;

/**
 * 974. 和可被 K 整除的子数组
 * <p>
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 * <p>
 * 子数组 是数组的 连续 部分。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,0,-2,-3,1], k = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * 示例 2:
 * 输入: nums = [5], k = 9
 * 输出: 0
 * <p>
 * 提示:
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * 2 <= k <= 10^4
 * <p>
 * https://leetcode.cn/problems/subarray-sums-divisible-by-k/
 */
public class Problem974_subarraySumsDivisiblebyK {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int subarraysDivByK_bf(int[] nums, int k) {
        int len = nums.length;

        int ans = 0;

        for (int i = 0; i < len; i++) {
            int sum = 0;

            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + subarraysDivByK_bf(new int[]{5}, 9));
        System.out.println("7 ?= " + subarraysDivByK_bf(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
