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
public class Problem594_longestHarmoniousSubsequence {

    // BF time: O(n^2) space: O(1)
    public static int findLHS_bf(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int minDiff = 0;
            int maxDiff = 0;
            int cntMin = 0;
            int cntMax = 0;
            for (int j = 0; j < len; j++) {
                if (nums[j] >= nums[i] && nums[j] <= nums[i] + 1) {
                    minDiff = Math.max(minDiff, nums[j] - nums[i]);
                    cntMin++;
                }

                if (nums[j] >= nums[i] - 1 && nums[j] <= nums[i]) {
                    maxDiff = Math.max(maxDiff, nums[j] - nums[i]);
                    cntMax++;
                }
            }

            cntMin = minDiff == 1 ? cntMin : 0;
            cntMax = maxDiff == 1 ? cntMax : 0;
            ans = Math.max(ans, Math.max(cntMin, cntMax));
        }

        return ans;
    }

    // Hash time: O(n) space: O(n)
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

    // Hash Opt time: O(n) space: O(n)
    public static int findLHS_hash_opt(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                int temp = freq.get(key) + freq.get(key + 1);
                ans = Math.max(ans, temp);
            }
        }

        return ans;
    }

    // Sort + 滑动窗口 time: O(nlogn) space: O(1)
    public static int findLHS_sort(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        if (len <= 1 || nums[0] == nums[len - 1]) {
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
        System.out.println("5 ?= " + findLHS_hash_opt(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println("2 ?= " + findLHS_bf(new int[]{1, 2, 3, 4}));
        System.out.println("0 ?= " + findLHS_bf(new int[]{1, 1, 1, 1}));
        System.out.println("7 ?= " + findLHS_hash_opt(new int[]{1, 2, 2, 3, 4, 5, 1, 1, 1, 1}));
        System.out.println("4 ?= " + findLHS_hash_opt(new int[]{-3, -1, -1, -1, -3, -2}));
        System.out.println("20 ?= " + findLHS_hash_opt(new int[]{2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2, 2, 0, 1, 2, 2, 3, 2}));

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
