package com.longluo.contest.weekly_contest_315;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-315/
 */

/**
 * 2441. 与对应负数同时存在的最大正整数
 * <p>
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 * <p>
 * 示例 2：
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 * <p>
 * 示例 3：
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 * <p>
 * https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/
 */
public class Problem2441_largestPositiveIntegerThatExistsWithItsNegative {

    public static int findMaxK(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(-x)) {
                res.add(Math.abs(x));
            }

            set.add(x);
        }

        Collections.sort(res);

        return res.size() == 0 ? -1 : res.get(res.size() - 1);
    }

    public static int findMaxK_opt(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(-nums[i])) {
                max = Math.max(max, Math.abs(nums[i]));
            }

            set.add(nums[i]);
        }

        return max;
    }

    // Sort time: O(nlogn) space: O(logn)
    public static int findMaxK_sort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        if (nums[n - 1] <= 0 || nums[0] >= 0) {
            return -1;
        }

        int ans = -1;

        for (int i = 0, j = n - 1; i < j; ) {
            if (nums[j] == -nums[i]) {
                ans = nums[j];
                break;
            } else if (nums[i] < -nums[j]) {
                i++;
            } else if (nums[j] > -nums[i]) {
                j--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println("7 ?= " + findMaxK_opt(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println("7 ?= " + findMaxK_sort(new int[]{-1, 10, 6, 7, -7, 1}));
    }
}
