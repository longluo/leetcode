package com.longluo.top100;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * <p>
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * <p>
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Problem11_containerWithMostWater {

    // BF time: O(n^2) space: O(1)
    // TimeOut
    public static int maxArea_bf(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }

        return max;
    }

    // Two Pointers time: O(n) space: O(1)
    public static int maxArea_tp(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            // Move the shorter lines each time
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

            // update the max area
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("49 ?= " + maxArea_tp(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("24 ?= " + maxArea_tp(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }
}
