package com.longluo.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 * <p>
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，
 * 而 x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，
 * 那么其特征值 x 是 唯一的 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,5]
 * 输出：2
 * 解释：有 2 个元素（3 和 5）大于或等于 2 。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0]
 * 输出：-1
 * 解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * 如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * 如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * 如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * x 不能取更大的值，因为 nums 中只有两个元素。
 * <p>
 * 示例 3：
 * 输入：nums = [0,4,3,0,4]
 * 输出：3
 * 解释：有 3 个元素大于或等于 3 。
 * <p>
 * 示例 4：
 * 输入：nums = [3,6,7,7,0]
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
public class Problem1608_specialArray {

    // BF time: O(n^2) space: O(1)
    public static int specialArray_bf(int[] nums) {
        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (nums[j] >= i) {
                    cnt++;
                }
            }
            if (cnt == i) {
                return i;
            }
        }

        return -1;
    }

    // Sort + BF O(n^2 + nlogn) space: O(logn)
    public static int specialArray_sort(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            int cnt = 0;
            for (int j = len - 1; j >= 0; j--) {
                if (nums[j] >= i) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == i) {
                return i;
            }
        }

        return -1;
    }

    // Sort time: O(nlogn) space: O(1)
    public static int specialArray_sort_better(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        if (nums[0] >= len) {
            return len;
        }

        int x = len - 1;
        int i = 1;
        while (x > 0) {
            if (x <= nums[i] && nums[i - 1] < x) {
                return x;
            } else {
                i++;
                x--;
            }
        }

        return -1;
    }

    // BS time: O(nlogn) space: O(1)
    public static int specialArray_bs(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                cnt = num >= mid ? cnt + 1 : cnt;
            }

            if (cnt == mid) {
                return mid;
            } else if (cnt > mid) {
                left = mid + 1;
            } else if (cnt < mid) {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + specialArray_bf(new int[]{3, 5}));
        System.out.println("2 ?= " + specialArray_sort(new int[]{3, 5}));
        System.out.println("2 ?= " + specialArray_sort_better(new int[]{3, 5}));
        System.out.println("2 ?= " + specialArray_bs(new int[]{3, 5}));
        System.out.println("-1 ?= " + specialArray_bs(new int[]{0, 0}));
    }
}
