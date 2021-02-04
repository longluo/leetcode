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

        int left = 0;
        int right = left + k - 1;
        double ans = 0.0;
        double sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        ans = sum / k;
        while (right < nums.length - 1) {
            sum -= nums[left];
            left++;
            right++;
            sum += nums[right];
            double average = sum / k;
            if (average> ans) {
                ans = average;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("12.75 ?= " + findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
