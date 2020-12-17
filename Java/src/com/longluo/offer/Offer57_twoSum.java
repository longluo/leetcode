package com.longluo.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Offer57_twoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{};
        }

        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int second = target - first;
            if (binarySearch(nums, second) != -1) {
                ans[0] = first;
                ans[1] = second;
                return ans;
            }
        }

        return ans;
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("[2, 7] ?= " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("[10, 30] ?= " + Arrays.toString(twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)));
        System.out.println("[3, 46] ?= " + Arrays.toString(twoSum(new int[]{2, 3, 9, 41, 46, 47}, 49)));
        System.out.println("[6, 59] ?= " + Arrays.toString(twoSum(new int[]{6, 18, 27, 40, 46, 57, 59, 66, 72, 91}, 65)));
    }
}
