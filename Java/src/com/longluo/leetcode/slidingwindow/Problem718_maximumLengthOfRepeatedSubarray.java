package com.longluo.leetcode.slidingwindow;

/**
 * 718. 最长重复子数组
 * <p>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * <p>
 * 示例 2：
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 * <p>
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 */
public class Problem718_maximumLengthOfRepeatedSubarray {

    // BF time: O(n^3) space: O(1)
    // TLE
    public static int findLength_bf(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int max = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] != nums2[j]) {
                    continue;
                }

                int cnt = 1;
                while (i + cnt < len1 && j + cnt < len2 && nums1[i + cnt] == nums2[j + cnt]) {
                    cnt++;
                }

                max = Math.max(max, cnt);
            }
        }

        return max;
    }

    // DP time: O(mn) space: O(mn)
    // AC
    public static int findLength_dp(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1][len2];

        int ans = 0;

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = i >= 1 && j >= 1 ? dp[i - 1][j - 1] + 1 : 1;
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + findLength_bf(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println("3 ?= " + findLength_dp(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
