package com.longluo.leetcode.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Problem34_findFirstAndLastPositionOfElementInSortedArray {

    // BF time: O(n) space: O(1)
    public static int[] searchRange_bf(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length <= 0) {
            return ans;
        }

        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : ans;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && ans[0] == -1) {
                ans[0] = i;
            } else if (nums[i] > target && ans[0] >= 0) {
                ans[1] = i - 1;
                return ans;
            }
        }

        if (ans[0] >= 0 && ans[1] == -1) {
            ans[1] = nums.length - 1;
        }

        return ans;
    }

    // BS time: O(logn) space: O(1)
    public static int[] searchRange_bs(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length <= 0) {
            return ans;
        }

        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : ans;
        }

        ans[0] = binarySearchLeft(nums, target);
        ans[1] = binarySearchRight(nums, target);

        return ans;
    }

    public static int binarySearchLeft(int[] arr, int target) {
        if (arr[arr.length - 1] < target) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return arr[left] == target ? left : -1;
    }

    public static int binarySearchRight(int[] arr, int target) {
        if (arr[0] > target) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return arr[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        searchRange_bf(new int[]{2, 2}, 2);
        searchRange_bs(new int[]{2}, 2);
        searchRange_bs(new int[]{2, 2}, 2);
        searchRange_bs(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
