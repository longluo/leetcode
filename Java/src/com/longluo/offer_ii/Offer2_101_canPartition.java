package com.longluo.offer_ii;

/**
 * 剑指 Offer II 101. 分割等和子集
 * <p>
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：nums 不可以分为和相等的两部分
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * <p>
 * https://leetcode.cn/problems/NUPfPr/
 */
public class Offer2_101_canPartition {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxNum = 0;
        for (int x : nums) {
            sum += x;
            maxNum = Math.max(maxNum, x);
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canPartition(new int[]{1, 5, 11, 5}));
        System.out.println("false ?= " + canPartition(new int[]{1, 2, 3, 5}));
        System.out.println("true ?= " + canPartition(new int[]{2, 2, 1, 1}));
    }
}
