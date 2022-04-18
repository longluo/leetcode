package com.longluo.contest.biweekly_contest_76;

/**
 * 2239. 找到最接近 0 的数字
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-2,1,4,8]
 * 输出：1
 * 解释：
 * -4 到 0 的距离为 |-4| = 4 。
 * -2 到 0 的距离为 |-2| = 2 。
 * 1 到 0 的距离为 |1| = 1 。
 * 4 到 0 的距离为 |4| = 4 。
 * 8 到 0 的距离为 |8| = 8 。
 * 所以，数组中距离 0 最近的数字为 1 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,-1,1]
 * 输出：1
 * 解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/find-closest-number-to-zero/
 */
public class Problem2239_findClosestNumberToZero {

    // BF time: O(n) space: O(1)
    public static int findClosestNumber(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int delta = 100_001;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                return nums[i];
            } else if (Math.abs(nums[i]) < delta) {
                delta = Math.abs(nums[i]);
                ans = nums[i];
            } else if (Math.abs(nums[i]) == delta) {
                ans = Math.max(ans, nums[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println("1 ?= " + findClosestNumber(new int[]{2, -1, 1}));
    }
}


