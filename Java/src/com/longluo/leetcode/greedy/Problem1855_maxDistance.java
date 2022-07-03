package com.longluo.leetcode.greedy;

/**
 * 1855. 下标对中的最大距离
 * <p>
 * 给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
 * <p>
 * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，
 * 则称之为 有效 下标对，该下标对的 距离 为 j - i
 * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
 * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
 * <p>
 * 示例 1：
 * 输入：nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
 * 输出：2
 * 解释：有效下标对是 (0,0), (2,2), (2,3), (2,4), (3,3), (3,4) 和 (4,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * <p>
 * 示例 2：
 * 输入：nums1 = [2,2,2], nums2 = [10,10,1]
 * 输出：1
 * 解释：有效下标对是 (0,0), (0,1) 和 (1,1) 。
 * 最大距离是 1 ，对应下标对 (0,1) 。
 * <p>
 * 示例 3：
 * 输入：nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
 * 输出：2
 * 解释：有效下标对是 (2,2), (2,3), (2,4), (3,3) 和 (3,4) 。
 * 最大距离是 2 ，对应下标对 (2,4) 。
 * <p>
 * 提示：
 * 1 <= nums1.length <= 10^5
 * 1 <= nums2.length <= 10^5
 * 1 <= nums1[i], nums2[j] <= 10^5
 * nums1 和 nums2 都是 非递增 数组
 * <p>
 * https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/
 */
public class Problem1855_maxDistance {

    // TODO: 2022/7/3
    // BF time: O(m*n) space: O(1)
    public static int maxDistance_bf(int[] nums1, int[] nums2) {
        int max = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            for (int j = i; j < len2; j++) {
                if (nums1[i] <= nums2[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }

        return max;
    }

    // BF Opt time: O(m*n) space: O(1)
    public static int maxDistance_bf_opt(int[] nums1, int[] nums2) {
        int max = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (nums1[len1 - 1] > nums2[0]) {
            return 0;
        } else if (nums2[len2 - 1] >= nums1[0]) {
            return len2 - 1;
        }

        for (int i = 0; i < len1; i++) {
            for (int j = i; j < len2; j++) {
                if (nums1[i] <= nums2[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }

        return max;
    }

    // Two Pointers time: O(m + n) space: O(1)
    public static int maxDistance_tp(int[] nums1, int[] nums2) {
        int max = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p = 0;
        int q = 0;
        while (q < len2) {
            while (p < len1 && nums1[p] > nums2[q]) {
                p++;
            }

            if (p < len1) {
                max = Math.max(max, q - p);
            }
            q++;
        }

        return max;
    }

    // Two Pointers time: O(m + n) space: O(1)
    public static int maxDistance_tp_opt(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p = 0;
        int q = 0;
        while (p < len1 && q < len2) {
            if (nums1[p] > nums2[q]) {
                p++;
            }

            q++;
        }

        return Math.max(q - p - 1, 0);
    }

    // BinarySearch time: O(m*logn) space: O(1)
    public static int maxDistance_bs(int[] nums1, int[] nums2) {
        int max = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            int x = nums1[i];
            int j = binarySearch(nums2, i, len2 - 1, x);
            if (j >= i) {
                max = Math.max(max, j - i);
            }
        }

        return max;
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int left = low;
        int right = high;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return arr[left] >= target ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maxDistance_tp(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
        System.out.println("2 ?= " + maxDistance_tp_opt(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
        System.out.println("2 ?= " + maxDistance_bs(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));
    }
}
