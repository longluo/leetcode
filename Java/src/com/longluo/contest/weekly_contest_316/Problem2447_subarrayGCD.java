package com.longluo.contest.weekly_contest_316;

/**
 * 2447. 最大公因数等于 K 的子数组数目
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的子数组中元素的最大公因数等于 k 的子数组数目。
 * 子数组 是数组中一个连续的非空序列。
 * 数组的最大公因数 是能整除数组中所有元素的最大整数。
 * <p>
 * 示例 1：
 * 输入：nums = [9,3,1,2,6,3], k = 3
 * 输出：4
 * 解释：nums 的子数组中，以 3 作为最大公因数的子数组如下：
 * - [9,3,1,2,6,3]
 * - [9,3,1,2,6,3]
 * - [9,3,1,2,6,3]
 * - [9,3,1,2,6,3]
 * <p>
 * 示例 2：
 * 输入：nums = [4], k = 7
 * 输出：0
 * 解释：不存在以 7 作为最大公因数的子数组。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], k <= 10^9
 * <p>
 * https://leetcode.cn/problems/number-of-subarrays-with-gcd-equal-to-k/
 */
public class Problem2447_subarrayGCD {

    // BF time: O(n(n+logU)) space: O(1)
    public static int subarrayGCD_bf(int[] nums, int k) {
        int len = nums.length;

        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] % k != 0) {
                continue;
            }

            int maxFactor = nums[i];
            for (int j = i; j < len; j++) {
                maxFactor = gcd(maxFactor, nums[j]);

                if (maxFactor % k > 0) {
                    break;
                }

                if (maxFactor == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + subarrayGCD_bf(new int[]{9, 3, 1, 2, 6, 3}, 3));
        System.out.println("10 ?= " + subarrayGCD_bf(new int[]{3, 3, 4, 1, 2}, 1));
        System.out.println("10 ?= " + subarrayGCD_bf(new int[]{4, 3, 1, 3, 3}, 1));
    }
}
