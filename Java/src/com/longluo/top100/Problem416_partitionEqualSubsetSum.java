package com.longluo.top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 416. 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 */
public class Problem416_partitionEqualSubsetSum {

    // Backtracking time: O(2^n) space: O(n)
    // TLE
    public static boolean canPartition_bt(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 == 1) {
            return false;
        }

//        return backtrack(nums, new ArrayList<>(), 0, sum / 2);
        return backtrack(nums, 0, sum / 2);
    }

    private static boolean backtrack(int[] nums, List<Integer> list, int idx, int remain) {
        if (remain == 0) {
            return true;
        }

        boolean flag = false;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > remain) {
                continue;
            }

            list.add(nums[i]);
            flag = backtrack(nums, list, i + 1, remain - nums[i]);
            if (flag) {
                break;
            }
            list.remove(list.size() - 1);
        }

        return flag;
    }

    private static boolean backtrack(int[] nums, int idx, int remain) {
        if (remain == 0) {
            return true;
        }

        boolean flag = false;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > remain) {
                continue;
            }

            flag = backtrack(nums, i + 1, remain - nums[i]);
            if (flag) {
                break;
            }
        }

        return flag;
    }

    // HashSet time: O(2^n) space: O(2^n)
    // AC
    public static boolean canPartition_set(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 == 1) {
            return false;
        }

        Set<Integer> sumsSet = new HashSet<>();
        sumsSet.add(0);

        for (int num : nums) {
            List<Integer> sumList = new ArrayList<>(sumsSet);
            for (int x : sumList) {
                sumsSet.add(x + num);
            }
        }

        return sumsSet.contains(sum / 2);
    }

    // DP time: O(n^sum) space: O(n*sum)
    public static boolean canPartition_dp(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 == 1) {
            return false;
        }

        boolean[][] dp = new boolean[len + 1][sum / 2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len][sum / 2];
    }

    // DP Opt time: O(n^sum) space: O(sum)
    public static boolean canPartition_dp_opt(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 == 1) {
            return false;
        }

        boolean[][] dp = new boolean[2][sum / 2 + 1];
        dp[0][0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[1][j] = dp[0][j] || dp[0][j - nums[i - 1]];
                } else {
                    dp[1][j] = dp[0][j];
                }
            }

            for (int k = 0; k <= sum / 2; k++) {
                dp[0][k] = dp[1][k];
            }
        }

        return dp[1][sum / 2];
    }

    // DP time: O(n^sum) space: O(sum)
    public static boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int len = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 == 1) {
            return false;
        }

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    dp[j] = dp[j - nums[i - 1]] || dp[j];
                }
            }
        }

        return dp[sum / 2];
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canPartition_bt(new int[]{1, 5, 11, 5}));
        System.out.println("false ?= " + canPartition_bt(new int[]{1, 2, 3, 5}));

        System.out.println("true ?= " + canPartition_set(new int[]{1, 5, 11, 5}));
        System.out.println("false ?= " + canPartition_set(new int[]{1, 2, 3, 5}));

        System.out.println("false ?= " + canPartition_dp(new int[]{1, 2, 5}));
        System.out.println("true ?= " + canPartition_dp(new int[]{1, 5, 11, 5}));
        System.out.println("false ?= " + canPartition_dp(new int[]{1, 2, 3, 5}));

        System.out.println("false ?= " + canPartition_dp_opt(new int[]{1, 2, 5}));
        System.out.println("true ?= " + canPartition_dp_opt(new int[]{1, 5, 11, 5}));
        System.out.println("false ?= " + canPartition_dp_opt(new int[]{1, 2, 3, 5}));

        System.out.println("false ?= " + canPartition(new int[]{1, 2, 5}));
        System.out.println("true ?= " + canPartition(new int[]{1, 5, 11, 5}));
        System.out.println("false ?= " + canPartition(new int[]{1, 2, 3, 5}));
    }
}
