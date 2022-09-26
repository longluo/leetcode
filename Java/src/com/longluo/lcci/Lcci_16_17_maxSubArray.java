package com.longluo.lcci;

/**
 * 面试题 16.17. 连续数列
 * <p>
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * <p>
 * 示例：
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶：
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 */
public class Lcci_16_17_maxSubArray {

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public static int maxSubArray_2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + nums[i]);
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(" Method Easy: ");
        System.out.println("6 ?= " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("1 ?= " + maxSubArray(new int[]{1}));
        System.out.println("1 ?= " + maxSubArray(new int[]{-2, 1}));
        System.out.println("-1 ?= " + maxSubArray(new int[]{-1}));

        System.out.println(" Method Dp: ");
        System.out.println("6 ?= " + maxSubArray_2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("1 ?= " + maxSubArray_2(new int[]{1}));
        System.out.println("1 ?= " + maxSubArray_2(new int[]{-2, 1}));
        System.out.println("-1 ?= " + maxSubArray_2(new int[]{-1}));
    }
}
