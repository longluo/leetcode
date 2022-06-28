package com.longluo.top100;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * 提示：
 * 1 <= heights.length <=10^5
 * 0 <= heights[i] <= 10^4
 * <p>
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Problem84_largestRectangleInHistogram {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int largestRectangleArea_bf(int[] heights) {
        int len = heights.length;
        if (len <= 1) {
            return heights[0];
        }

        int max = heights[0];
        for (int i = 0; i < len; i++) {
            if (heights[i] == 0) {
                continue;
            }

            int minH = heights[i];
            for (int j = i; j < len; j++) {
                if (heights[j] == 0) {
                    break;
                }

                minH = Math.min(minH, heights[j]);
                int area = minH * (j - i + 1);
                max = Math.max(max, area);
            }
        }

        return max;
    }

    // Record time: O(n) space: O(n)
    public static int largestRectangleArea_bf_opt(int[] heights) {
        int len = heights.length;
        if (len <= 1) {
            return heights[0];
        }

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = -1;
        right[len - 1] = len;

        for (int i = 1; i < len; i++) {
            int idx = i - 1;
            while (idx >= 0 && heights[idx] >= heights[i]) {
                idx = left[idx];
            }

            left[i] = idx;
        }

        for (int i = len - 2; i >= 0; i--) {
            int idx = i + 1;
            while (idx < len && heights[idx] >= heights[i]) {
                idx = right[idx];
            }

            right[i] = idx;
        }

        int max = heights[0];

        for (int i = 0; i < len; i++) {
            int area = heights[i] * (right[i] - left[i] - 1);
            max = Math.max(max, area);
        }

        return max;
    }

    // TODO: 2022/6/28
    // Stack
    public static int largestRectangleArea_stack(int[] heights) {
        int len = heights.length;
        if (len <= 1) {
            return heights[0];
        }

        int ans = heights[0];
        Stack<Integer> stk = new Stack<>();


        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + largestRectangleArea_bf(new int[]{2}));
        System.out.println("4 ?= " + largestRectangleArea_bf(new int[]{2, 4}));
        System.out.println("9 ?= " + largestRectangleArea_bf(new int[]{0, 9}));
        System.out.println("10 ?= " + largestRectangleArea_bf(new int[]{2, 1, 5, 6, 2, 3}));

        System.out.println("10 ?= " + largestRectangleArea_bf_opt(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
