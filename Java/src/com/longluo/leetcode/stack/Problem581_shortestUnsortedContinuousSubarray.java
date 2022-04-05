package com.longluo.leetcode.stack;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * <p>
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class Problem581_shortestUnsortedContinuousSubarray {

    // BF Bad Not AC
    public static int findUnsortedSubarray_bf(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int left = 1;
        int right = len - 1;
        int insertLeft = 0;
        int insertRight = 0;
        int ans = len;
        while (left < right) {
            while (left < right && nums[left] >= nums[left - 1]) {
                left++;
            }

            insertLeft = left - 1;
            while (insertLeft >= 0 && nums[insertLeft] > nums[left]) {
                insertLeft--;
            }
            insertLeft++;

            while (left < right - 1 && nums[right - 1] <= nums[right]) {
                right--;
            }

            insertRight = right;
            while (insertRight < len && nums[insertRight] < nums[right]) {
                insertRight++;
            }

            insertRight--;

            if (insertLeft < insertRight) {
                ans = Math.min(ans, insertRight - insertLeft + 1);
            }
        }

        return insertLeft == 0 ? 0 : ans;
    }

    // Sort time: O(nlogn) space: O(n)
    public static int findUnsortedSubarray_sort(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] sortedArray = new int[len];
        System.arraycopy(nums, 0, sortedArray, 0, len);
        Arrays.sort(sortedArray);

        while (nums[left] == sortedArray[left]) {
            left++;
        }

        while (nums[right] == sortedArray[right]) {
            right--;
        }

        return right - left + 1;
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }

        return true;
    }

    // Best time: O(n) space: O(1)
    public static int findUnsortedSubarray_(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int left = 0;
        int right = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                right = i;
            }

            if (nums[len - i - 1] <= min) {
                min = nums[len - i - 1];
            } else {
                left = len - i - 1;
            }
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + findUnsortedSubarray_bf(new int[]{1}));
        System.out.println("2 ?= " + findUnsortedSubarray_bf(new int[]{2, 1}));
        System.out.println("5 ?= " + findUnsortedSubarray_bf(new int[]{5, 4, 3, 2, 1}));
        System.out.println("5 ?= " + findUnsortedSubarray_bf(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println("0 ?= " + findUnsortedSubarray_bf(new int[]{1, 2, 3, 4}));
    }
}
