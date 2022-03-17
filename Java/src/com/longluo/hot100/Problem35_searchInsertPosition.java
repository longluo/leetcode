package com.longluo.hot100;

/**
 * 35. Search Insert Position
 * Easy
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * <p>
 * https://leetcode.com/problems/search-insert-position/
 */
public class Problem35_searchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[0] > target) {
                return 0;
            }
            if (nums[i] == target) {
                return i;
            }
            if (i >= 1 && nums[i - 1] < target && nums[i] > target) {
                return i;
            }
            if (nums[len - 1] < target) {
                return len;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
