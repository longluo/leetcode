package com.longluo.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数n，令整数x符合 x=n * k ，则称 x 是 k 的一个倍数。
 * <p>
 * 示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * <p>
 * 示例 3：
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= sum(nums[i]) <= 2^31 - 1
 * 1 <= k <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class Problem523_continuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = nums[i];
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkSubarraySum_dp(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < len; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int preIndex = map.get(remainder);
                if (i - preIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println("true ?= " + checkSubarraySum_dp(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println("true ?= " + checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println("true ?= " + checkSubarraySum_dp(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println("true ?= " + checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println("true ?= " + checkSubarraySum_dp(new int[]{23, 2, 6, 4, 7}, 13));
    }
}
