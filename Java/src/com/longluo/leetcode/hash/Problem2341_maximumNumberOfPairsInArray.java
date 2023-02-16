package com.longluo.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2341. 数组能形成多少数对
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 * <p>
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 * <p>
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，
 * answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,2,1,3,2,2]
 * 输出：[3,1]
 * 解释：
 * nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
 * nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
 * nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
 * 无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,0]
 * 解释：nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [] 。
 * 无法形成更多数对。总共形成 1 个数对，nums 中剩下 0 个数字。
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0,1]
 * 解释：无法形成数对，nums 中剩下 1 个数字。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 */
public class Problem2341_maximumNumberOfPairsInArray {

    // HashMap time: O(n) space: O(n)
    public static int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2];

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int x : nums) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        for (int freq : countMap.values()) {
            ans[0] += freq / 2;
        }

        ans[1] = nums.length - ans[0] * 2;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0, 1] ?= " + Arrays.toString(numberOfPairs(new int[]{0})));
        System.out.println("[1, 0] ?= " + Arrays.toString(numberOfPairs(new int[]{1, 1})));
        System.out.println("[3, 1] ?= " + Arrays.toString(numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})));
    }
}
