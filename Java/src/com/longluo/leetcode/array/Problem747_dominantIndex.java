package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 747. 至少是其他数字两倍的最大数
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 * <p>
 * 提示：
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 * <p>
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 */
public class Problem747_dominantIndex {

    public static int dominantIndex(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int len = nums.length;
        int[] copy = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);
        Arrays.sort(copy);
        int max = copy[len - 1];
        int ans = -1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num == max) {
                ans = i;
            }
            if (num < max && max - num < num) {
                return -1;
            }
        }

        return ans;
    }

    public static int dominantIndex_better(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int len = nums.length;
        int max = -1;
        int ans = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ans = i;
            }
        }

        for (int i = 0; i < len; i++) {
            if (i != ans) {
                if (max - nums[i] < nums[i]) {
                    return -1;
                }
            }
        }

        return ans;
    }

    public static int dominantIndex_best(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int len = nums.length;
        int max = -1;
        int subMax = -1;
        int ans = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                subMax = max;
                max = nums[i];
                ans = i;
            } else if (nums[i] > subMax) {
                subMax = nums[i];
            }
        }

        return max >= subMax * 2 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + dominantIndex(new int[]{1}));
        System.out.println("-1 ?= " + dominantIndex(new int[]{1, 2, 3, 4}));
        System.out.println("1 ?= " + dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println("1 ?= " + dominantIndex_better(new int[]{3, 6, 1, 0}));
        System.out.println("0 ?= " + dominantIndex_better(new int[]{1, 0}));
        System.out.println("0 ?= " + dominantIndex_best(new int[]{1, 0}));
    }
}
