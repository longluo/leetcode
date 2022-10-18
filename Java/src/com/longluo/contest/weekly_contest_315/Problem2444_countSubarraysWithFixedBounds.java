package com.longluo.contest.weekly_contest_315;

/**
 * 2444. 统计定界子数组的数目
 * <p>
 * 给你一个整数数组 nums 和两个整数 minK 以及 maxK 。
 * <p>
 * nums 的定界子数组是满足下述条件的一个子数组：
 * 子数组中的 最小值 等于 minK 。
 * 子数组中的 最大值 等于 maxK 。
 * 返回定界子数组的数目。
 * <p>
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,5,2,7,5], minK = 1, maxK = 5
 * 输出：2
 * 解释：定界子数组是 [1,3,5] 和 [1,3,5,2] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1,1], minK = 1, maxK = 1
 * 输出：10
 * 解释：nums 的每个子数组都是一个定界子数组。共有 10 个子数组。
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i], minK, maxK <= 10^6
 * <p>
 * https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/
 */
public class Problem2444_countSubarraysWithFixedBounds {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static long countSubarrays_bf(int[] nums, int minK, int maxK) {
        long ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (min == minK && max == maxK) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // SlidingWindow time: O(n) space: O(1)
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        if (minK > maxK) {
            return 0;
        }

        int len = nums.length;

        int start = 0;
        int minKIdx = -1;
        int maxKIdx = -1;

        long ans = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                start = i + 1;
                minKIdx = i;
                maxKIdx = i;
                continue;
            }

            if (nums[i] == minK) {
                minKIdx = i;
            }

            if (nums[i] == maxK) {
                maxKIdx = i;
            }

            ans += (i - start + 1) - (i - (Math.min(minKIdx, maxKIdx) + 1) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countSubarrays_bf(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));

        System.out.println("2 ?= " + countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println("10 ?= " + countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));
        System.out.println("81 ?= " + countSubarrays(new int[]{35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913}, 35054, 945315));
    }
}
