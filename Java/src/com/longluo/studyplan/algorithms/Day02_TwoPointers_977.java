package com.longluo.studyplan.algorithms;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按 非递减顺序 排序
 * <p>
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * <p>
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class Day02_TwoPointers_977 {

    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[i] * nums[i];
        }

        Arrays.sort(ans);
        return ans;
    }

    public static int[] sortedSquares_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] ans = new int[len];
        int left = 0;
        int right = len - 1;
        while (left < right) {

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0,1,9,16,100] ?= " + Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println("[4,9,9,49,121] ?= " + Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
