package com.longluo.top100;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class Problem4_findMedianSortedArrays {

    // BF time: O(m + n) space: O(m + n)
    public static double findMedianSortedArrays_bf(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        } else if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int[] nums = new int[m + n];
        int total = m + n;
        for (int i = 0, j = 0, cnt = 0; cnt < total; ) {
            if (i == m && j < n) {
                nums[cnt++] = nums2[j++];
            } else if (j == n && i < m) {
                nums[cnt++] = nums1[i++];
            } else if (i < m && nums1[i] <= nums2[j]) {
                nums[cnt++] = nums1[i++];
            } else if (i < m && nums1[i] > nums2[j]) {
                nums[cnt++] = nums2[j++];
            }
        }

        if (total % 2 == 0) {
            return (nums[total / 2 - 1] + nums[total / 2]) / 2.0;
        } else {
            return nums[total / 2];
        }
    }

    // BF Opt time: O(m + n) space: O(m + n)
    public static double findMedianSortedArrays_bf_opt(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        } else if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int[] nums = new int[m + n];
        int total = m + n;
        for (int i = 0, j = 0, cnt = 0; cnt <= total / 2; ) {
            if (i == m && j < n) {
                nums[cnt++] = nums2[j++];
            } else if (j == n && i < m) {
                nums[cnt++] = nums1[i++];
            } else if (i < m && nums1[i] <= nums2[j]) {
                nums[cnt++] = nums1[i++];
            } else if (i < m && nums1[i] > nums2[j]) {
                nums[cnt++] = nums2[j++];
            }
        }

        if (total % 2 == 0) {
            return (nums[total / 2 - 1] + nums[total / 2]) / 2.0;
        } else {
            return nums[total / 2];
        }
    }

    // Merge time: O(m + n) space: O(1)
    public static double findMedianSortedArrays_merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int len = m + n;
        int p = 0;
        int q = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (p == m && q < n) {
                right = nums2[q];
                q++;
            } else if (q == n && p < m) {
                right = nums1[p];
                p++;
            } else if (p < m && nums1[p] <= nums2[q]) {
                right = nums1[p];
                p++;
            } else if (q < n && nums1[p] > nums2[q]) {
                right = nums2[q];
                q++;
            }
        }

        if (len % 2 == 0) {
            return (double) (left + right) / 2;
        } else {
            return right;
        }
    }

    public static double findMedianSortedArrays_merge_opt(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int len = m + n;
        int p = 0;
        int q = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (p < m && (q >= n || nums1[p] <= nums2[q])) {
                right = nums1[p++];
            } else  {
                right = nums2[q++];
            }
        }

        if (len % 2 == 0) {
            return (double) (left + right) / 2;
        } else {
            return right;
        }
    }

    // Binary Search  time: O(log(m + n)) space: O(1)
    public static double findMedianSortedArrays_bs(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = 0;

        return 0;
    }

    public static double findMedianSortedArrays_bs_getk(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len % 2 == 1) {
            int midIdx = len / 2;
            double median = getKthElement(nums1, nums2, midIdx + 1);
            return median;
        } else {
            int midIndex1 = len / 2 - 1;
            int midIndex2 = len / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int idx1 = 0;
        int idx2 = 0;
        int kthElement = 0;
        while (true) {
            if (idx1 == len1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == len2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(idx1 + half, len1) - 1;
            int newIndex2 = Math.min(idx2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - idx1 + 1);
                idx1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - idx2 + 1);
                idx2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("1.00000 ?= " + findMedianSortedArrays_bf(new int[]{}, new int[]{1}));
        System.out.println("2.00000 ?= " + findMedianSortedArrays_bf(new int[]{1, 3}, new int[]{2}));
        System.out.println("2.50000 ?= " + findMedianSortedArrays_bf(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println("0.00000 ?= " + findMedianSortedArrays_bf(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println("2.00000 ?= " + findMedianSortedArrays_bf(new int[]{2}, new int[]{}));
        System.out.println("0.00000 ?= " + findMedianSortedArrays_bf(new int[]{0, 0, 0, 0, 0}, new int[]{-1, 0, 0, 0, 0, 0, 1}));

        System.out.println("2.0 ?= " + findMedianSortedArrays_merge(new int[]{2}, new int[]{}));
        System.out.println("0.0 ?= " + findMedianSortedArrays_merge(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println("2.5 ?= " + findMedianSortedArrays_merge(new int[]{1, 2}, new int[]{3, 4}));

        System.out.println("2.5 ?= " + findMedianSortedArrays_merge_opt(new int[]{1, 2}, new int[]{3, 4}));

    }
}
