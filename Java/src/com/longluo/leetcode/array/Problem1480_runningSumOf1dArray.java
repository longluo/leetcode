package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 1480. 一维数组的动态和
 * <p>
 * 给你一个数组nums。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回nums的动态和。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]。
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]。
 * <p>
 * 示例 3：
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 * <p>
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class Problem1480_runningSumOf1dArray {

    // BF time: O(n^2) space: O(n)
    public static int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                sums[i] += nums[j];
            }
        }

        return sums;
    }

    // BF Opt time: O(n^2) space: O(n)
    public static int[] runningSum_bf_opt(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        return sums;
    }

    // Opt time: O(n) space: O(1)
    public static int[] runningSum_opt(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("[1, 3, 6, 10] ?= " + Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.println("[1, 2, 3, 4, 5] ?= " + Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println("[3, 4, 6, 16, 17] ?= " + Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1})));

        System.out.println("[3, 4, 6, 16, 17] ?= " + Arrays.toString(runningSum_bf_opt(new int[]{3, 1, 2, 10, 1})));

        System.out.println("[3, 4, 6, 16, 17] ?= " + Arrays.toString(runningSum_opt(new int[]{3, 1, 2, 10, 1})));
    }
}
