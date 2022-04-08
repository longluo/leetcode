package com.longluo.studyplan.binary_search;

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Problem33_searchInRotatedSortedArray {

    // BF time: O(n) space: O(1)
    public static int search_bf(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // BinarySearch time: O(logn) space: O(1)
    public static int search_binary(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // Another BinarySearch time: O(logn) space: O(1)
    public static int search_binary_2(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] >= nums[right]) {
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }

        if (nums[left] == target) {
            return left;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + search_binary(new int[]{5, 1, 3}, 5));
        System.out.println("4 ?= " + search_binary(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("-1 ?= " + search_binary(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));

        System.out.println("0 ?= " + search_binary_2(new int[]{5, 1, 3}, 5));
        System.out.println("0 ?= " + search_binary_2(new int[]{1, 3, 5}, 1));
        System.out.println("4 ?= " + search_binary_2(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("-1 ?= " + search_binary_2(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
