package com.longluo.leetcode.array;

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
public class Problem977_squaresOfASortedArray {

    public static int[] sortedSquares_bf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int square = nums[i] * nums[i];
            res[i] = square;
        }

        Arrays.sort(res);
        return res;
    }

    public static int[] sortedSquares_tp(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] res = new int[len];
        int index = len - 1;
        while (left <= right) {
            while (index >= 0 && Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[index] = nums[left] * nums[left];
                left++;
                index--;
            }

            while (index >= 0 && Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }

        return res;
    }

    public static int[] sortedSquares_tp_opt(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0, j = len - 1, pos = len - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }

        return ans;
    }

    public static void main(String[] args) {
        sortedSquares_tp(new int[]{-7, -3, 2, 3, 11});
    }
}
