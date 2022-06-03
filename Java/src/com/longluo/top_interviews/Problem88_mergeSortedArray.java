package com.longluo.top_interviews;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * Easy
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * <p>
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * <p>
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * <p>
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Problem88_mergeSortedArray {

    // Two Pointers time: O(m+n) space: O(m+n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length <= 0) {
            return;
        }

        int[] num = new int[m + n];
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        while (idx < m + n) {
            if (idx1 < m && idx2 < n && nums1[idx1] <= nums2[idx2]) {
                num[idx++] = nums1[idx1++];
            } else if (idx1 < m && idx2 < n && nums1[idx1] > nums2[idx2]) {
                num[idx++] = nums2[idx2++];
            } else if (idx1 == m && idx2 < n) {
                num[idx++] = nums2[idx2++];
            } else if (idx2 == n && idx1 < m) {
                num[idx++] = nums1[idx1++];
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = num[i];
        }
    }

    // Sort time: O(nlogm) space: O(logm)
    public static void merge_sort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    // Two Pointers time: O(m+n) space: O(1)
    public static void merge_tp(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int idx = m + n - 1;
        int cur = 0;
        while (p >= 0 || q >= 0) {
            if (p < 0) {
                cur = nums2[q--];
            } else if (q < 0) {
                cur = nums1[p--];
            } else if (nums1[p] < nums2[q]) {
                cur = nums2[q--];
            } else {
                cur = nums1[p--];
            }

            nums1[idx--] = cur;
        }
    }

    // Two Pointers time: O(m+n) space: O(1)
    public static void merge_tp_best(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            while (m >= 0 && nums1[m] >= nums2[n]) {
                nums1[idx--] = nums1[m--];
            }
            nums1[idx--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] tstNums1 = {1, 2, 3, 0, 0, 0};
        merge(tstNums1, 3, new int[]{2, 5, 6}, 3);
        merge_sort(tstNums1, 3, new int[]{2, 5, 6}, 3);
        merge_tp(tstNums1, 3, new int[]{2, 5, 6}, 3);
        merge_tp_best(tstNums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println("[1, 2, 2, 3, 5, 6] ?= " + Arrays.toString(tstNums1));
        int[] tstNums3 = {2, 0};
        merge(tstNums3, 1, new int[]{1}, 1);
        System.out.println("[1, 1] ?= " + Arrays.toString(tstNums3));
    }
}
