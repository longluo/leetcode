package com.longluo.contest.biweekly_contest_89;

import java.util.Arrays;

/**
 * 2439. 最小化数组中的最大值
 * <p>
 * 给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。
 * <p>
 * 每一步操作中，你需要：
 * 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。
 * 将 nums[i] 减 1 。
 * 将 nums[i - 1] 加 1 。
 * <p>
 * 你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。
 * <p>
 * 示例 1：
 * 输入：nums = [3,7,1,6]
 * 输出：5
 * 解释：
 * 一串最优操作是：
 * 1. 选择 i = 1 ，nums 变为 [4,6,1,6] 。
 * 2. 选择 i = 3 ，nums 变为 [4,6,2,5] 。
 * 3. 选择 i = 1 ，nums 变为 [5,5,2,5] 。
 * nums 中最大值为 5 。无法得到比 5 更小的最大值。
 * 所以我们返回 5 。
 * <p>
 * 示例 2：
 * 输入：nums = [10,1]
 * 输出：10
 * 解释：
 * 最优解是不改动 nums ，10 是最大值，所以返回 10 。
 * <p>
 * 提示：
 * n == nums.length
 * 2 <= n <= 10^5
 * 0 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/minimize-maximum-of-array/
 */
public class Problem2439_minimizeMaximumOfArray {

    // Binary Search time: O(nlogn) space: O(1)
    public static int minimizeArrayValue(int[] nums) {
        int left = 0;
        int right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;

            long sum = 0;

            for (int x : nums) {
                if (x <= mid) {
                    sum += mid - x;
                } else {
                    sum -= x - mid;
                    if (sum < 0) {
                        break;
                    }
                }
            }

            if (sum >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("10 ?= " + minimizeArrayValue(new int[]{10, 1}));
        System.out.println("5 ?= " + minimizeArrayValue(new int[]{3, 7, 1, 6}));
        System.out.println("16 ?= " + minimizeArrayValue(new int[]{13, 13, 20, 0, 8, 9, 9}));
    }
}
