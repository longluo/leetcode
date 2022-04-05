package com.longluo.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 410. 分割数组的最大值
 * <p>
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * <p>
 * 示例 1：
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。
 * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4,5], m = 2
 * 输出：9
 * <p>
 * 示例 3：
 * 输入：nums = [1,4,4], m = 3
 * 输出：4
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 10^6
 * 1 <= m <= min(50, nums.length)
 * <p>
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class Problem410_splitArrayLargestSum {

    // BF Version 1.0 Fail
    public static int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int len = nums.length;
        int[] prefixSums = new int[len + 1];
        int maxVal = nums[0];
        prefixSums[0] = 0;
        for (int i = 0; i < len; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
            maxVal = Math.max(maxVal, nums[i]);
        }

        if (m == 1) {
            return prefixSums[len];
        } else if (m == len) {
            return maxVal;
        }

        int maxSum = maxVal;
        int average = prefixSums[len] / m;
        int splitIdx = 0;
        int[][] dp = new int[len + 1][m + 1];
        for (int i = 1; i <= len; i++) {
            dp[i][1] = i - 1;
        }

        for (int i = 1; i <= len; i++) {

            for (int j = 2; j <= m; j++) {
                average = prefixSums[len] / j;
                int curIdx = binarySearch(prefixSums, average);

            }
        }


        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < m; i++) {
            int target = i * average;
            int curIdx = binarySearch(prefixSums, target);
            maxSum = Math.max(maxSum, prefixSums[curIdx] - prefixSums[splitIdx]);
            list.add(curIdx - 1);
            splitIdx = curIdx;
        }

        maxSum = Math.max(maxSum, prefixSums[len] - prefixSums[splitIdx]);

        for (int idx : list) {
            System.out.print(idx + ",");
        }

        return maxSum;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    // Use Binary Search
    public static int splitArray_bs(int[] nums, int m) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int len = nums.length;
        int left = nums[0];
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 1;
            int tempSum = 0;
            for (int i = 0; i < len; i++) {
                if (tempSum + nums[i] > mid) {
                    tempSum = nums[i];
                    cnt++;
                } else {
                    tempSum += nums[i];
                }
            }

            if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + splitArray(new int[]{1}, 1));
        System.out.println("3 ?= " + splitArray(new int[]{1, 2}, 1));
        System.out.println("2 ?= " + splitArray(new int[]{1, 2}, 2));

        System.out.println("18 ?= " + splitArray_bs(new int[]{7, 2, 5, 10, 8}, 2));

        System.out.println("9 ?= " + splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println("9 ?= " + splitArray(new int[]{1, 2, 3, 4, 5, 6}, 3));
        System.out.println("25 ?= " + splitArray(new int[]{10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8}, 8));
    }
}
