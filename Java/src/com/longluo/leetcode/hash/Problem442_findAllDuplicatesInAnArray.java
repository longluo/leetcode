package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 442. 数组中重复的数据
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 * <p>
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class Problem442_findAllDuplicatesInAnArray {

    // BF + HashSet time: O(n^2) space: O(1)
    public static List<Integer> findDuplicates_bf(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && nums[i] == nums[j]) {
                    ans.add(nums[i]);
                    break;
                }
            }
        }

        return new ArrayList<>(ans);
    }

    // HashMap time: O(n) space: O(n)
    public static List<Integer> findDuplicates_hash(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int freq = map.getOrDefault(x, 0) + 1;
            if (freq >= 2) {
                ans.add(x);
            }
            map.put(x, freq);
        }

        return ans;
    }

    // Hash time: O(n) space: O(1)
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == i + 1) {
                continue;
            }

            while (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findDuplicates(new int[]{1, 1, 2}));
    }
}
