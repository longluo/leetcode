package com.longluo.top100;

import java.util.*;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * https://leetcode.com/problems/3sum/
 */
public class Problem15_3Sum {

    // Brute Force time: O(n^3) space: O(1)
    // Failed for not remove the same elements.
    public static List<List<Integer>> threeSum_bf(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> ans = new HashSet<>();
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

    // Sort + BF + Set time: O(n^3) space: O(1)
    // TimeOut
    public static List<List<Integer>> threeSum_bf_sort(int[] nums) {
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

    // Sort + BF + List time: O(n^3) space: O(1)
    // TimeOut
    public static List<List<Integer>> threeSum_bf_list(int[] nums) {
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

            for (int j = i + 1; j < length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = j + 1; k < length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return ans;
    }

    // Hash time: O(n^2) space: O(n)
    public static List<List<Integer>> threeSum_hash(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < len; j++) {
                if (set.contains(target - nums[j])) {
                    ans.add(Arrays.asList(nums[i], nums[j], target - nums[j]));
                } else {
                    set.add(nums[j]);
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

    public static void main(String[] args) {
        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_bf(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_bf_sort(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_bf_list(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_hash(new int[]{-1, 0, 1, 2, -1, -4}));

        System.out.println("[0, 0, 0] ?= " + threeSum_bf(new int[]{0, 0, 0, 0}));
        System.out.println("[0, 0, 0] ?= " + threeSum_bf_list(new int[]{0, 0, 0, 0}));

        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_tp(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[0, 0, 0] ?= " + threeSum_tp(new int[]{0, 0, 0, 0}));
    }
}
