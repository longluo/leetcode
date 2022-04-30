package com.longluo.studyplan.binary_search;

/**
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 * <p>
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 进阶：
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class Problem209_minimumSizeSubarraySum {

    // BF time: O(n^2) space: O(1)
    public static int minSubArrayLen_bf(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // Sliding Window time: O(n) space: O(1)
    public static int minSubArrayLen_sw(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < len) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // PrefixSum + Sliding Window time: O(n) space: O(n)
    public static int minSubArrayLen_prefix(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] prefixSums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        int left = 0;
        int right = 1;
        while (right <= len) {
            int sum = prefixSums[right] - prefixSums[left];
            if (sum >= target) {
                ans = Math.min(ans, right - left);
                left++;
            } else {
                right++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // PrefixSum + Binary Search time: O(nlogn) space: O(n)
    public static int minSubArrayLen_prefix_bs(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] prefixSums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= len; i++) {
            int upperBound = binarySearch(prefixSums, i, len, target + prefixSums[i - 1]);
            if (upperBound != -1) {
                ans = Math.min(ans, upperBound - i + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (nums[right] < target) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return nums[left] >= target ? left : -1;
    }

    // Binary Search time: O(nlogn) space: O(1)
    public static int minSubArrayLen_bs(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int left = 0;
        int right = len;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int maxSum = getMaxSum(nums, mid);
            if (mid == len && maxSum < target) {
                return 0;
            }
            if (maxSum >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left <= len ? left : 0;
    }

    public static int getMaxSum(int[] nums, int segLen) {
        int sum = 0;
        for (int i = 0; i < segLen; i++) {
            sum += nums[i];
        }

        int ans = sum;
        for (int i = segLen; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - segLen];
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minSubArrayLen_bf(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2 ?= " + minSubArrayLen_prefix(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2 ?= " + minSubArrayLen_prefix_bs(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2 ?= " + minSubArrayLen_sw(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("5 ?= " + minSubArrayLen_prefix(15, new int[]{1, 2, 3, 4, 5}));
        System.out.println("2 ?= " + minSubArrayLen_prefix(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
        System.out.println("1 ?= " + minSubArrayLen_sw(4, new int[]{1, 4, 4}));
        System.out.println("0 ?= " + minSubArrayLen_sw(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println("2 ?= " + minSubArrayLen_bs(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("0 ?= " + minSubArrayLen_bs(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
