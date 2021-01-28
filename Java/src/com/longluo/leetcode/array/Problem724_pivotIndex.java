package com.longluo.leetcode.array;

/**
 * 724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 示例 1：
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * <p>
 * 示例 2：
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 * <p>
 * 说明：
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class Problem724_pivotIndex {

    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int length = nums.length;
        int totalSum = 0;
        for (int i = 0; i < length; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;
        int rightSum = totalSum - leftSum;

        for (int i = 0; i < length; i++) {
            if (i > 0) {
                leftSum += nums[i - 1];
            }
            rightSum = totalSum - nums[i] - leftSum;
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println("-1 ?= " + pivotIndex(new int[]{1, 2, 3}));
        System.out.println("-1 ?= " + pivotIndex(new int[]{}));
        System.out.println("0 ?= " + pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }
}
