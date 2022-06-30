package com.longluo.leetcode.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 462. 最少移动次数使数组元素相等 II
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 答案保证符合 32-bit 整数
 * <p>
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class Problem462_minMoves2 {

    // BF time: O(nC) space: O(1)
    // TLE
    public static int minMoves2_bf(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                cnt += Math.abs(nums[j] - i);
            }

            ans = Math.min(ans, cnt);
        }

        return ans;
    }

    // BF time: O(nC) space: O(1)
    // TLE
    public static int minMoves2_bf_opt(int[] nums) {
        int len = nums.length;

        long sum = 0;
        int max = nums[0];
        int min = nums[0];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            sum += x;
        }

        int average = (int) (sum / len);

        int ans = Integer.MAX_VALUE;
        for (int i = min - average; i <= max - average; i++) {
            int cnt = 0;
            int base = average + i;
            for (int x : nums) {
                cnt += Math.abs(x - base);
            }

            ans = Math.min(ans, cnt);
        }

        return ans;
    }

    // Sort time: O(nlogn) space: O(logn)
    public static int minMoves2_sort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int base = nums[len / 2];
        int ans = 0;
        for (int x : nums) {
            ans += Math.abs(x - base);
        }

        return ans;
    }

    // QuickSelect time: O(n) space: O(1)
    private static Random random = new Random();

    public static int minMoves2_quick(int[] nums) {
        int base = quickSelect(nums);
        int ans = 0;
        for (int x : nums) {
            ans += Math.abs(x - base);
        }

        return ans;
    }

    private static int quickSelect(int[] nums) {
        int len = nums.length;

        int target = len / 2;

        int left = 0;
        int right = len - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIdx = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIdx);
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);

        return ge;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minMoves2_bf(new int[]{1, 1, 2}));
        System.out.println("2 ?= " + minMoves2_bf(new int[]{1, 2, 3}));
        System.out.println("0 ?= " + minMoves2_bf(new int[]{1, 1, 1}));
        System.out.println("1 ?= " + minMoves2_bf(new int[]{1, 2}));
        System.out.println("16 ?= " + minMoves2_bf(new int[]{1, 10, 2, 9}));

        System.out.println("16 ?= " + minMoves2_bf_opt(new int[]{1, 10, 2, 9}));
        System.out.println("14 ?= " + minMoves2_bf_opt(new int[]{1, 0, 0, 8, 6}));

        System.out.println("14 ?= " + minMoves2_sort(new int[]{1, 0, 0, 8, 6}));

        System.out.println("14 ?= " + minMoves2_quick(new int[]{1, 0, 0, 8, 6}));
    }
}
