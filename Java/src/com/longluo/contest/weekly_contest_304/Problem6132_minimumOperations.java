package com.longluo.contest.weekly_contest_304;

import java.util.Arrays;

/**
 * 6132. 使数组中所有元素都等于零
 * <p>
 * 给你一个非负整数数组 nums 。在一步操作中，你必须：
 * <p>
 * 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
 * nums 中的每个正整数都减去 x。
 * 返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,0,3,5]
 * 输出：3
 * 解释：
 * 第一步操作：选出 x = 1 ，之后 nums = [0,4,0,2,4] 。
 * 第二步操作：选出 x = 2 ，之后 nums = [0,2,0,0,2] 。
 * 第三步操作：选出 x = 2 ，之后 nums = [0,0,0,0,0] 。
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：0
 * 解释：nums 中的每个元素都已经是 0 ，所以不需要执行任何操作。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
 */
public class Problem6132_minimumOperations {

    // Count time: O(n) space: O(1)
    public static int minimumOperations(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] > 0 ? 1 : 0;
        }

        Arrays.sort(nums);
        int ans = 0;
        int last = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= last) {
                continue;
            }

            last = nums[i];
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumOperations(new int[]{1}));
        System.out.println("3 ?= " + minimumOperations(new int[]{1, 5, 0, 3, 5}));
        System.out.println("4 ?= " + minimumOperations(new int[]{1, 2, 3, 5}));
    }
}
