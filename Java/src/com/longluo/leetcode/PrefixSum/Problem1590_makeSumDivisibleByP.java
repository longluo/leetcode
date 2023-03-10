package com.longluo.leetcode.PrefixSum;

/**
 * 1590. 使数组和能被 P 整除
 * <p>
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 * <p>
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 * <p>
 * 子数组 定义为原数组中连续的一组元素。
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * <p>
 * 示例  4：
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * <p>
 * 示例 5：
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= p <= 10^9
 * <p>
 * https://leetcode.cn/problems/make-sum-divisible-by-p/
 */
public class Problem1590_makeSumDivisibleByP {

    // BF + PrefixSums time: O(n^2) space: O(n)
    public static int minSubarray_bf(int[] nums, int p) {
        int len = nums.length;

        long[] prefixSums = new long[len + 1];
        for (int i = 0; i < len; i++) {
            int mod = nums[i] % p;
            prefixSums[i + 1] = mod + prefixSums[i];
        }

        if (prefixSums[len] % p == 0) {
            return 0;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= len - i; j++) {
                long sum = prefixSums[j] + prefixSums[len] - prefixSums[j + i];
                if (sum % p == 0) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minSubarray_bf(new int[]{3, 1, 4, 2}, 6));
        System.out.println("2 ?= " + minSubarray_bf(new int[]{6, 3, 5, 2}, 9));
        System.out.println("0 ?= " + minSubarray_bf(new int[]{1, 2, 3}, 3));
        System.out.println("-1 ?= " + minSubarray_bf(new int[]{1, 2, 3}, 7));
        System.out.println("0 ?= " + minSubarray_bf(new int[]{1000000000, 1000000000, 1000000000}, 3));
    }
}
