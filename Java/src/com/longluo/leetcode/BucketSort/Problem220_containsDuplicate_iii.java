package com.longluo.leetcode.BucketSort;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * <p>
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，
 * 同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * <p>
 * 提示：
 * 0 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^4
 * 0 <= t <= 2^31 - 1
 * <p>
 * https://leetcode.cn/problems/contains-duplicate-iii/
 */
public class Problem220_containsDuplicate_iii {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static boolean containsNearbyAlmostDuplicate_bf(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length <= 1 || indexDiff <= 0) {
            return false;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(i - j) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }

        return false;
    }

    // SlidingWindow time: O(n*2t) space: O(k)
    // TLE
    public static boolean containsNearbyAlmostDuplicate_win(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length <= 1 || indexDiff <= 0) {
            return false;
        }

        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (i > indexDiff) {
                set.remove(nums[i - indexDiff - 1]);
            }

            for (int j = nums[i] - valueDiff; j <= nums[i] + valueDiff; j++) {
                if (set.contains(j)) {
                    return true;
                }
            }

            set.add(nums[i]);
        }

        return false;
    }

    // SlidingWindow + TreeSet time: O(nlogk) space: O(k)
    public static boolean containsNearbyAlmostDuplicate_win_opt(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length <= 1 || indexDiff <= 0) {
            return false;
        }

        int len = nums.length;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            if (i > indexDiff) {
                set.remove(nums[i - indexDiff - 1]);
            }

            if (set.floor(nums[i] + valueDiff) != null && set.floor(nums[i] + valueDiff) >= nums[i] - valueDiff) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + containsNearbyAlmostDuplicate_bf(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println("true ?= " + containsNearbyAlmostDuplicate_bf(new int[]{1, 0, 1, 1}, 1, 2));

        System.out.println("true ?= " + containsNearbyAlmostDuplicate_win(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println("true ?= " + containsNearbyAlmostDuplicate_win(new int[]{1, 0, 1, 1}, 1, 2));

        System.out.println("false ?= " + containsNearbyAlmostDuplicate_win_opt(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println("true ?= " + containsNearbyAlmostDuplicate_win_opt(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println("true ?= " + containsNearbyAlmostDuplicate_win_opt(new int[]{1, 0, 1, 1}, 1, 2));
    }
}
