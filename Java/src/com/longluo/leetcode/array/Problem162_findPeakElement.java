package com.longluo.leetcode.array;

/**
 * 162. 寻找峰值
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引2。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * <p>
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class Problem162_findPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int len = nums.length;
        if (len == 2) {
            if (nums[1] > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int i = 1; i < len; i++) {
            if (i + 1 < len && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            } else if (i == len - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println("1 ?= " + findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println("3 ?= " + findPeakElement(new int[]{3, 1, 2}));
    }
}
