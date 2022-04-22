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

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }

            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

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
        while (left < right && right <= len) {
            int sum = prefixSums[right] - prefixSums[left];
            if (sum >= target) {
                ans = Math.min(ans, right - left);
                left++;
            } else if (sum < target) {
                right++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int minSubArrayLen_bs(int target, int[] nums) {
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
            int value = target + prefixSums[i - 1];
            int upperBound = binarySearch(prefixSums, i, value);
//            int upperBound = Arrays.binarySearch(prefixSums, value);
            if (upperBound == -1) {
                continue;
            }
            if (upperBound <= len) {
                ans = Math.min(ans, upperBound - i + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int binarySearch(int[] nums, int start, int target) {
        int len = nums.length;
        if (start > len || nums[len - 1] < target) {
            return -1;
        }

        if (nums[start] > target) {
            return start;
        }

        int end = len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        return end;
    }

    public static int minSubArrayLen_sw(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < len) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2 ?= " + minSubArrayLen_prefix(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2 ?= " + minSubArrayLen_bs(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("2 ?= " + minSubArrayLen_sw(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("5 ?= " + minSubArrayLen_prefix(15, new int[]{1, 2, 3, 4, 5}));
        System.out.println("2 ?= " + minSubArrayLen_prefix(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
        System.out.println("1 ?= " + minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println("0 ?= " + minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
