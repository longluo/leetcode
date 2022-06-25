package com.longluo.leetcode.array;

/**
 * 665. 非递减数列
 * <p>
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <=nums[i+1]。
 * <p>
 * 示例 1:
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * 说明：
 * 1 <= n <= 10^4
 * - 10^5 <= nums[i] <= 10^5
 * <p>
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class Problem665_nonDecreasingArray {

    // Greedy time: O(n) space: O(1)
    public static boolean checkPossibility(int[] nums) {
        int len = nums.length;

        int count = 0;

        for (int i = 1; i < len && count < 2; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkPossibility(new int[]{4, 2, 3}));
        System.out.println("false ?= " + checkPossibility(new int[]{4, 2, 1}));
        System.out.println("false ?= " + checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println("true ?= " + checkPossibility(new int[]{4, 2, 3}));
        System.out.println("true ?= " + checkPossibility(new int[]{-1, 4, 2, 3}));
    }
}
