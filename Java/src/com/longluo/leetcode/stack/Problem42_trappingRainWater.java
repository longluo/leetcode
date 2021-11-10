package com.longluo.leetcode.stack;

import java.util.Stack;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Problem42_trappingRainWater {

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int maxRight = 0;
            int maxLeft = 0;
            for (int j = i; j < len; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            for (int k = i; k >= 0; k--) {
                maxLeft = Math.max(maxLeft, height[k]);
            }

            ans += (Math.min(maxLeft, maxRight) - height[i]);
        }

        return ans;
    }

    public static int trap_dy(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int ans = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    public static int trap_dp(int[] height) {
        int ans = 0;


        return ans;
    }

    public static int trap_tp(int[] height) {
        int ans = 0;


        return ans;
    }

    public static int trap_st(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("9 ?= " + trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("9 ?= " + trap_dy(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
