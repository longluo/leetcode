package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * <p>
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：nums = [2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1]
 * 输出：0
 * <p>
 * 提示：
 * 3 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^6
 * <p>
 * https://leetcode.cn/problems/largest-perimeter-triangle/
 */
public class Problem976_largestPerimeterTriangle {

    // BF time: O(n^3) space: O(1)
    public static int largestPerimeter_bf(int[] nums) {
        int len = nums.length;

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {

                }
            }
        }

        return ans;
    }

    // Sort + Greedy time: O(nlogn) space: O(logn)
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int max = 0;
        for (int i = len - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                max = Math.max(max, nums[i] + nums[i - 1] + nums[i - 2]);
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + largestPerimeter_bf(new int[]{2, 1, 2}));
        System.out.println("5 ?= " + largestPerimeter(new int[]{2, 1, 2}));
    }
}
