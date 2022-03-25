package com.longluo.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 287. Find the Duplicate Number
 * <p>
 * Medium
 * <p>
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * Follow up:
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * <p>
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class Problem287_findTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        return nums.length;
    }

    public static int findDuplicate_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return len;
    }

    public static int findDuplicate_sort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {

    }
}
