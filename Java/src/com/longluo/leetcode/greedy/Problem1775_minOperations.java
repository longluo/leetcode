package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 1775. 通过最少操作次数使数组的和相等
 * <p>
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 * <p>
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 * <p>
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * <p>
 * 示例 3：
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length <= 10^5
 * 1 <= nums1[i], nums2[i] <= 6
 * <p>
 * https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/
 */
public class Problem1775_minOperations {

    // Greedy time: O(n) space: O(C)
    public static int minOperations(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        if (sum1 == sum2) {
            return 0;
        }

        if (6 * len2 < len1 || 6 * len1 < len2) {
            return -1;
        }

        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];

        for (int x : nums1) {
            cnt1[x]++;
        }

        for (int x : nums2) {
            cnt2[x]++;
        }

        if (sum1 > sum2) {
            return equal(cnt1, cnt2, sum1 - sum2);
        } else {
            return equal(cnt2, cnt1, sum2 - sum1);
        }
    }

    private static int equal(int[] largeCnt, int[] smallCnt, int diff) {
        int ans = 0;

        int idx = 6;

        while (diff > 0 && idx > 0) {
            while (largeCnt[idx] > 0 && diff > 0) {
                diff -= idx - 1;
                largeCnt[idx]--;
                ans++;
            }

            while (smallCnt[6 - idx + 1] > 0 && diff > 0) {
                diff -= idx - 1;
                smallCnt[6 - idx + 1]--;
                ans++;
            }

            idx--;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minOperations(new int[]{6, 6}, new int[]{1}));
        System.out.println("-1 ?= " + minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));
        System.out.println("3 ?= " + minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
    }
}
