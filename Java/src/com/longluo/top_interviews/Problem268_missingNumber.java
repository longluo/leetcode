package com.longluo.top_interviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. Missing Number
 * <p>
 * Easy
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * *
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^4
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * <p>
 * https://leetcode.com/problems/missing-number/
 */
public class Problem268_missingNumber {

    // Sort time: O(nlogn) space: O(logn)
    public static int missingNumber_sort(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return len;
    }

    // Count time: O(n) space: O(n)
    public static int missingNumber_count(int[] nums) {
        int len = nums.length;
        boolean[] seen = new boolean[len + 1];
        for (int x : nums) {
            seen[x] = true;
        }

        for (int i = 0; i < len; i++) {
            if (!seen[nums[i]]) {
                return nums[i];
            }
        }

        return len;
    }

    // HashSet time: O(n) space: O(n)
    public static int missingNumber_set(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i <= len; i++) {
            if (set.add(i)) {
                return i;
            }
        }

        return len;
    }

    // XOR time: O(n) space: O(1)
    public static int missingNumber_xor(int[] nums) {
        int xor = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            xor ^= nums[i];
        }

        for (int i = 0; i <= len; i++) {
            xor ^= i;
        }

        return xor;
    }

    // Math time: O(n) space: O(1)
    public static int missingNumber_math(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        int arraySum = 0;
        for (int x : nums) {
            arraySum += x;
        }

        return sum - arraySum;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + missingNumber_sort(new int[]{3, 0, 1}));
        System.out.println("2 ?= " + missingNumber_set(new int[]{3, 0, 1}));
        System.out.println("2 ?= " + missingNumber_count(new int[]{3, 0, 1}));
        System.out.println("2 ?= " + missingNumber_math(new int[]{3, 0, 1}));
        System.out.println("2 ?= " + missingNumber_xor(new int[]{3, 0, 1}));
    }
}
