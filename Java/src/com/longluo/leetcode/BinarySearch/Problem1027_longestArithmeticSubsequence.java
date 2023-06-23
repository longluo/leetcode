package com.longluo.leetcode.BinarySearch;

/**
 * 1027. 最长等差数列
 * <p>
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，
 * 且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，
 * 那么序列 seq 是等差的。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * <p>
 * 示例 2：
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * <p>
 * 示例 3：
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * 提示：
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 * <p>
 * https://leetcode.cn/problems/longest-arithmetic-subsequence/
 */
public class Problem1027_longestArithmeticSubsequence {

    // BF time: O(n^3) space: O(1)
    // AC
    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int ans = 2;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int delta = nums[j] - nums[i];
                int cnt = 2;
                int prev = nums[j];
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - prev != delta) {
                        continue;
                    } else {
                        prev = nums[k];
                        cnt++;
                    }
                }

                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println("3 ?= " + longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println("4 ?= " + longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }
}
