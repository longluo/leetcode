package com.longluo.leetcode.array;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为k的连续子数组，并输出该最大平均数。
 * <p>
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 提示：
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class Problem643_findMaxAverage {

    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(sum, max);
        }

        return (double) max / k;
    }

    public static void main(String[] args) {
        System.out.println("12.75 ?= " + findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
