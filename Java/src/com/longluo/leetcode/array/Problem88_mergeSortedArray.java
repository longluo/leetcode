package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
 * 这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Problem88_mergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || nums2.length == 0) {
            return;
        }

        int[] nums = new int[m + n];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (idx1 < m && idx2 < n) {
                if (nums1[idx1] <= nums2[idx2]) {
                    nums[i] = nums1[idx1];
                    idx1++;
                } else {
                    nums[i] = nums2[idx2];
                    idx2++;
                }
            } else if (idx1 < m && idx2 >= n) {
                nums[i] = nums1[idx1];
                idx1++;
            } else if (idx1 >= m && idx2 < n) {
                nums[i] = nums2[idx2];
                idx2++;
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums[i];
        }
    }

    public static void main(String[] args) {
        int[] tstNums1 = {1, 2, 3, 0, 0, 0};
        merge(tstNums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println("[1, 2, 2, 3, 5, 6] ?= " + Arrays.toString(tstNums1));
    }
}
