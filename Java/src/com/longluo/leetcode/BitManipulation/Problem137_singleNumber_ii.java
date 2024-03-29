package com.longluo.leetcode.BitManipulation;

import java.util.*;

/**
 * 137. 只出现一次的数字 II
 * <p>
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * https://leetcode.cn/problems/single-number-ii/
 */
public class Problem137_singleNumber_ii {

    // HashMap time: O(n) space: O(n)
    public static int singleNumber_hashmap(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return nums[0];
    }

    public static int singleNumber_bit(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + singleNumber_hashmap(new int[]{2, 2, 3, 2}));
        System.out.println("3 ?= " + singleNumber_bit(new int[]{2, 2, 3, 2}));
        System.out.println("2 ?= " + singleNumber_hashmap(new int[]{2}));
        System.out.println("2 ?= " + singleNumber_bit(new int[]{2}));
        System.out.println("99 ?= " + singleNumber_hashmap(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println("99 ?= " + singleNumber_bit(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
