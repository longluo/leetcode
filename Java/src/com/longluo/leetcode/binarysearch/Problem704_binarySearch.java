package com.longluo.leetcode.binarysearch;

/**
 * 704. Binary Search
 * <p>
 * Easy
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 * <p>
 * https://leetcode.com/problems/binary-search/
 */
public class Problem704_binarySearch {

    public static int search_bf(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static int search_bs(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int search_bs_rec(int[] nums, int target) {
        int len = nums.length;
        return binarySearch(nums, target, 0, len - 1);
    }

    public static int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return binarySearch(nums, target, low, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static int search_bs_less(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }

        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + search_bs(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println("4 ?= " + search_bs_rec(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println("0 ?= " + search_bs_less(new int[]{1, 3}, 1));
        System.out.println("1 ?= " + search_bs_less(new int[]{1, 3}, 3));
        System.out.println("-1 ?= " + search_bs_less(new int[]{1, 3}, 5));
        System.out.println(" " + (0 + 5 >> 1) + " " + (0 + 5 / 2));
    }
}
