package com.longluo.contest.biweekly_contest_86;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-86/
 */

/**
 * 2395. 和相等的子数组
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，判断是否存在 两个 长度为 2 的子数组且它们的 和 相等。
 * 注意，这两个子数组起始位置的下标必须 不相同 。
 * <p>
 * 如果这样的子数组存在，请返回 true，否则返回 false 。
 * <p>
 * 子数组 是一个数组中一段连续非空的元素组成的序列。
 * <p>
 * 示例 1：
 * 输入：nums = [4,2,4]
 * 输出：true
 * 解释：元素为 [4,2] 和 [2,4] 的子数组有相同的和 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4,5]
 * 输出：false
 * 解释：没有长度为 2 的两个子数组和相等。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：true
 * 解释：子数组 [nums[0],nums[1]] 和 [nums[1],nums[2]] 的和相等，都为 0 。
 * 注意即使子数组的元素相同，这两个子数组也视为不相同的子数组，因为它们在原数组中的起始位置不同。
 * <p>
 * 提示：
 * 2 <= nums.length <= 1000
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/find-subarrays-with-equal-sum/
 */
public class Problem2395_findSubarraysWithEqualSum {

    // BF time: O(n^2) space: O(1)
    public static boolean findSubarrays_bf(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int sumA = nums[i] + nums[i + 1];

            for (int j = i + 1; j < n - 1; j++) {
                int sumB = nums[j] + nums[j + 1];
                if (sumA == sumB) {
                    return true;
                }
            }
        }

        return false;
    }

    // HashMap time: O(n) space: O(n)
    public static boolean findSubarrays(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (map.containsValue(sum)) {
                return true;
            }

            map.put(i, sum);
        }

        return false;
    }

    // HashSet time: O(n) space: O(n)
    public static boolean findSubarrays_set(int[] nums) {
        int len = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!set.add(sum)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + findSubarrays_bf(new int[]{4, 2, 4}));
        System.out.println("false ?= " + findSubarrays_bf(new int[]{1, 2, 3, 4, 5}));

        System.out.println("true ?= " + findSubarrays(new int[]{4, 2, 4}));
        System.out.println("true ?= " + findSubarrays_set(new int[]{4, 2, 4}));
    }
}
