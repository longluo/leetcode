package com.longluo.studyplan.algorithms;

import java.util.*;

/**
 * 15. 3Sum
 * <p>
 * Medium
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * <p>
 * Example 2:
 * Input: nums = []
 * Output: []
 * <p>
 * Example 3:
 * Input: nums = [0]
 * Output: []
 * <p>
 * Constraints:
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * https://leetcode.com/problems/3sum/
 */
public class Problem15_threeSum {

    // Brute Force time: O(n^3) space: O(1)
    public static List<List<Integer>> threeSum_bf(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }

    // Two Pointers time: O(n^2) space: O(1)
    public static List<List<Integer>> threeSum_tp(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[length - 2] + nums[length - 1] < 0) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else if (nums[left] + nums[right] == -nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> threeSum_tp_2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[length - 2] + nums[length - 1] < 0) {
                continue;
            }

            for (int j = i + 1; j < length - 1; j++) {

            }

            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else if (nums[left] + nums[right] == -nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_bf(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[0, 0, 0] ?= " + threeSum_bf(new int[]{0, 0, 0, 0}));

        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_tp(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[0, 0, 0] ?= " + threeSum_tp(new int[]{0, 0, 0, 0}));
    }
}
