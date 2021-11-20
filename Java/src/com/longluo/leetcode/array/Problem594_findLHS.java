package com.longluo.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 * <p>
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 */
public class Problem594_findLHS {

    public static int findLHS(int[] nums) {
        int len = nums.length;
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> has = new HashMap<>();
        for (int i = 0; i < len; i++) {
            has.put(nums[i], has.getOrDefault(nums[i], 0) + 1);
            if (freq.getOrDefault(nums[i] + 1, 0) == 0 && freq.getOrDefault(nums[i] - 1, 0) == 0) {
                continue;
            }
            int plus = freq.get(nums[i]) - has.get(nums[i]) + 1 + freq.getOrDefault(nums[i] + 1, 0) - has.getOrDefault(nums[i] + 1, 0);
            int minus = freq.get(nums[i]) - has.get(nums[i]) + 1 + freq.getOrDefault(nums[i] - 1, 0) - has.getOrDefault(nums[i] - 1, 0);
            ans = Math.max(ans, Math.max(plus, minus));
        }

        return ans;
    }

    public static int findLHS_hash(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int x : nums) {
            if (freq.getOrDefault(x + 1, 0) == 0 && freq.getOrDefault(x - 1, 0) == 0) {
                continue;
            }
            int plus = freq.get(x) + freq.getOrDefault(x + 1, 0);
            int minus = freq.get(x) + freq.getOrDefault(x - 1, 0);
            ans = Math.max(ans, Math.max(plus, minus));
        }

        return ans;
    }

    public static int findLHS_sort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[len - 1] == nums[0]) {
            return 0;
        }
        int left = 0;
        int ans = 0;
        for (int right = 0; right < len; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                ans = Math.max(ans, right - left + 1);
            }
        }

        return ans == 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println("2 ?= " + findLHS(new int[]{1, 2, 3, 4}));
        System.out.println("0 ?= " + findLHS(new int[]{1, 1, 1, 1}));
        System.out.println("7 ?= " + findLHS(new int[]{1, 2, 2, 3, 4, 5, 1, 1, 1, 1}));
        System.out.println("4 ?= " + findLHS(new int[]{-3, -1, -1, -1, -3, -2}));
        System.out.println("20 ?= " + findLHS(new int[]{2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2, 2, 0, 1, 2, 2, 3, 2}));

        System.out.println("0 ?= " + findLHS_hash(new int[]{1, 1, 1, 1}));
        System.out.println("20 ?= " + findLHS_hash(new int[]{2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2, 2, 0, 1, 2, 2, 3, 2}));

        System.out.println("0 ?= " + findLHS_sort(new int[]{1, 1, 1, 1}));
        System.out.println("4 ?= " + findLHS_sort(new int[]{1, 2, 2, 1}));
        System.out.println("7 ?= " + findLHS_sort(new int[]{1, 2, 2, 3, 4, 5, 1, 1, 1, 1}));
        System.out.println("0 ?= " + findLHS_sort(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17}));
        System.out.println("2 ?= " + findLHS_sort(new int[]{1, 4, 1, 3, 1, -14, 1, -13}));
        System.out.println("3 ?= " + findLHS_sort(new int[]{1, 2, 3, 3, 1, -14, 13, 4}));
        System.out.println("20 ?= " + findLHS_sort(new int[]{2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2, 2, 0, 1, 2, 2, 3, 2}));
    }
}
