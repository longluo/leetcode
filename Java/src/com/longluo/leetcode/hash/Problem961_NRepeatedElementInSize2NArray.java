package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * <p>
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * 提示：
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 104
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 * <p>
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 */
public class Problem961_NRepeatedElementInSize2NArray {

    // HashMap time: O(n) space: O(n)
    public static int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == nums.length / 2) {
                ans = entry.getKey();
                break;
            }
        }

        return ans;
    }

    // HashMap Opt time: O(n) space: O(n)
    public static int repeatedNTimes_hash(int[] nums) {
        int ans = -1;
        int len = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            int count = freq.getOrDefault(x, 0) + 1;
            if (count == len / 2) {
                ans = x;
                break;
            }

            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        return ans;
    }

    // HashSet time: O(n) space: O(n)
    public static int repeatedNTimes_hashset(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) {
                return x;
            }
        }

        return -1;
    }

    // Random time: O(1) space: O(1)
    public static int repeatedNTimes_random(int[] nums) {
        int len = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(len);
            int y = random.nextInt(len);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println("2 ?= " + repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println("5 ?= " + repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
        System.out.println("5 ?= " + repeatedNTimes_hash(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
        System.out.println("5 ?= " + repeatedNTimes_hashset(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
        System.out.println("5 ?= " + repeatedNTimes_random(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
