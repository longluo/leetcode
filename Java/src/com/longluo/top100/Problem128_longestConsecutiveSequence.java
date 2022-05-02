package com.longluo.top100;

import java.util.*;

/**
 * 128. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class Problem128_longestConsecutiveSequence {

    // BF time: O(n^2) space: O(logn)
    // Timeout
    public static int longestConsecutive_bf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        int ans = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int last = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == last + 1) {
                    ans = Math.max(ans, nums[j] - nums[i] + 1);
                    last = nums[j];
                } else if (nums[j] > last + 1) {
                    break;
                }
            }
        }

        return ans;
    }

    // Hash time: O(nlogn) space: O(n)
    public static int longestConsecutive_hash(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int ans = 1;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x + 1) || map.containsKey(x - 1)) {
                int tempLen = Math.max(map.getOrDefault(x + 1, 1) + 1, map.getOrDefault(x - 1, 1) + 1);
                map.put(x, tempLen);
                ans = Math.max(ans, tempLen);
            } else {
                map.put(x, 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + longestConsecutive_bf(new int[]{0}));
        System.out.println("1 ?= " + longestConsecutive_bf(new int[]{0, 0}));
        System.out.println("3 ?= " + longestConsecutive_bf(new int[]{1, 2, 0, 1}));
        System.out.println("4 ?= " + longestConsecutive_bf(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("9 ?= " + longestConsecutive_bf(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

        System.out.println("1 ?= " + longestConsecutive_hash(new int[]{0}));
        System.out.println("1 ?= " + longestConsecutive_hash(new int[]{0, 0}));
        System.out.println("3 ?= " + longestConsecutive_hash(new int[]{1, 2, 0, 1}));
        System.out.println("4 ?= " + longestConsecutive_hash(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("9 ?= " + longestConsecutive_hash(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
