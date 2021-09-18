package com.longluo.offer;

import java.util.*;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * <p>
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class Offer57_twoSum {

    // 暴力
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = nums[i];
                    ans[1] = nums[j];
                    return ans;
                }
            }
        }

        return ans;
    }

    // 二分
    public static int[] twoSum_1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n - 1; i++) {
            int low = i + 1;
            int high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target - nums[i]) {
                    ans[0] = nums[i];
                    ans[1] = nums[mid];
                    return ans;
                } else if (nums[mid] > target - nums[i]) {
                    high = mid - 1;
                } else if (nums[mid] < target - nums[i]) {
                    low = mid + 1;
                }
            }
        }

        return ans;
    }

    // Set
    public static int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (set.contains(target - nums[i])) {
                ans[0] = nums[i];
                ans[1] = target - ans[0];
                return ans;
            } else {
                set.add(nums[i]);
            }
        }

        return ans;
    }

    // Two Pointers
    public static int[] twoSum_3(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int n = nums.length;
        int[] ans = new int[2];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while (left < right && nums[left] + nums[right] > target) {
                right--;
            }

            while (left < right && nums[left] + nums[right] < target) {
                left++;
            }

            if (nums[left] + nums[right] == target) {
                ans[0] = nums[left];
                ans[1] = nums[right];
                return ans;
            }
        }

        return ans;
    }

    // Binary Search
    public static int[] twoSum_4(int[] nums, int target) {
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
        System.out.println("[6, 59] ?= " + Arrays.toString(twoSum_1(new int[]{6, 18, 27, 40, 46, 57, 59, 66, 72, 91}, 65)));
        System.out.println("[6, 59] ?= " + Arrays.toString(twoSum_2(new int[]{6, 18, 27, 40, 46, 57, 59, 66, 72, 91}, 65)));
        System.out.println("[6, 59] ?= " + Arrays.toString(twoSum_3(new int[]{6, 18, 27, 40, 46, 57, 59, 66, 72, 91}, 65)));
        System.out.println("[16, 60] ?= " + Arrays.toString(twoSum_3(new int[]{14, 15, 16, 22, 53, 60}, 76)));
    }
}
