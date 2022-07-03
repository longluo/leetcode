package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 * <p>
 * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
 * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 * nums 中每个元素 恰好 在 一个 数对中，且
 * 最大数对和 的值 最小 。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7。
 * <p>
 * 示例 2：
 * 输入：nums = [3,5,4,2,4,6]
 * 输出：8
 * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 * <p>
 * 提示：
 * n == nums.length
 * 2 <= n <= 10^5
 * n 是 偶数 。
 * 1 <= nums[i] <= 10^5
 * <p>
 * https://leetcode.cn/problems/minimize-maximum-pair-sum-in-array/
 */
public class Problem1877_minimizeMaximumPairSumInArray {

    // TODO: 2022/7/3
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int value = nums[i] + nums[n - i - 1];
            ans = Math.max(ans, value);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + minPairSum(new int[]{3, 5, 2, 3}));
        System.out.println("8 ?= " + minPairSum(new int[]{3, 5, 4, 2, 4, 6}));
    }
}
