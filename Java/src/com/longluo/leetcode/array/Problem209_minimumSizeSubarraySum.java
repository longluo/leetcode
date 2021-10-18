package com.longluo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 进阶：
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Problem209_minimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }

            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        }

        return ans;
    }

    public static int minSubArrayLen_prefix(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] prefixSums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        int left = 0;
        int right = 1;
        while (left < right && right <= len) {
            int sum = prefixSums[right] - prefixSums[left];
            if (sum >= target) {
                ans = Math.min(ans, right - left);
                left++;
            } else if (sum < target) {
                right++;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2 ?= " + minSubArrayLen_prefix(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("5 ?= " + minSubArrayLen_prefix(15, new int[]{1, 2, 3, 4, 5}));
        System.out.println("2 ?= " + minSubArrayLen_prefix(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
        System.out.println("1 ?= " + minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println("0 ?= " + minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
