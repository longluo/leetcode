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

    // Row time: O(max * n) space: O(1)
    // TimeOut
    public static int trap_row(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int ans = 0;
        int len = height.length;
        int maxHeight = 0;

        for (int x : height) {
            maxHeight = Math.max(maxHeight, x);
        }

        for (int i = 1; i <= maxHeight; i++) {
            boolean flag = false;
            int water = 0;
            for (int j = 0; j < len; j++) {
                if (flag && height[j] < i) {
                    water++;
                }

                if (height[j] >= i) {
                    ans += water;
                    water = 0;
                    flag = true;
                }
            }
        }

        return ans;
    }

    // Col time: O(n^2) space: O(1)
    public static int trap_col(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int ans = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int maxRight = 0;
            int maxLeft = 0;
            for (int right = i; right < len; right++) {
                maxRight = Math.max(maxRight, height[right]);
            }

            for (int left = i; left >= 0; left--) {
                maxLeft = Math.max(maxLeft, height[left]);
            }

            ans += Math.min(maxLeft, maxRight) - height[i];
        }

        return ans;
    }

    // DP time: O(n) space: O(n)
    public static int trap_dp(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int ans = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 1; i < len - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            ans += min > height[i] ? min - height[i] : 0;
        }

        return ans;
    }

    // Two Pointers time: O(n) space: O(n)
    public static int trap_tp(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int len = height.length;
        int ans = 0;
        int leftMax = height[0];
        int[] rightMax = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < len - 1; i++) {
            leftMax = Math.max(leftMax, height[i]);
            int min = Math.min(leftMax, rightMax[i]);
            ans += min > height[i] ? min - height[i] : 0;
        }

        return ans;
    }

    // Two Pointers time: O(n) space: O(1)
    public static int trap_tp_opt(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int len = height.length;
        int ans = 0;
        int left = 0;
        int right = len - 1;
        int leftMax = height[0];
        int rightMax = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }

    // Stack time: O(n) space: O(n)
    public static int trap_stack(int[] height) {
        int ans = 0;
        int len = height.length;
        Stack<Integer> stk = new Stack<>();
        int idx = 0;
        while (idx < len) {
            while (!stk.empty() && height[stk.peek()] < height[idx]) {
                int lastIdx = stk.pop();
                while (!stk.empty() && height[stk.peek()] == height[lastIdx]) {
                    stk.pop();
                }
                if (stk.empty()) {
                    break;
                }
                int stackTop = stk.peek();
                int dis = idx - stackTop - 1;
                int min = Math.min(height[idx], height[stackTop]);
                ans += dis * (min - height[lastIdx]);
            }

            stk.push(idx);
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + trap_row(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("6 ?= " + trap_col(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("6 ?= " + trap_dp(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("6 ?= " + trap_tp(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("6 ?= " + trap_tp_opt(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("6 ?= " + trap_stack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("9 ?= " + trap_col(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("9 ?= " + trap_dp(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("9 ?= " + trap_tp(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("9 ?= " + trap_tp_opt(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("9 ?= " + trap_stack(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println("2 ?= " + trap_stack(new int[]{2, 0, 2}));
    }
}
