package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 1262. 可被三整除的最大和
 * <p>
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * 示例 1：
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * <p>
 * 示例 2：
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * 提示：
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/
 */
public class Problem1262_greatestSumDivisibleByThree {

    // DP time: O(n) space: O(n)
    public static int maxSumDivThree(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][3];

        dp[0][nums[0] % 3] = nums[0];

        int max = nums[0] % 3 == 0 ? nums[0] : 0;

        for (int i = 1; i < n; i++) {
            int mod = nums[i] % 3;

            for (int j = 0; j < 3; j++) {
                dp[i][(j + mod) % 3] = dp[i - 1][j] + nums[i];
            }

            max = Math.max(max, dp[i][0]);
        }

        return max;
    }

    // Backtrack time: O(2^n) space: O(n)
    // TLE
    static int ans = 0;

    public static int maxSumDivThree_bf(int[] nums) {
        int n = nums.length;

        ans = 0;

        for (int i = n; i > 0; i--) {
            boolean[] visited = new boolean[n];
            backtrack(nums, new ArrayList<>(), visited, 0, i);
        }

        return ans;
    }

    private static void backtrack(int[] nums, List<Integer> path, boolean[] visited, int idx, int remain) {
        if (remain == 0) {
            int sum = 0;

            for (int x : path) {
                sum += x;
            }

            if (sum % 3 == 0) {
                ans = Math.max(ans, sum);
            }

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }


            visited[i] = true;
            path.add(nums[i]);

            backtrack(nums, path, visited, i + 1, remain - 1);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + maxSumDivThree(new int[]{4}));
        System.out.println("9 ?= " + maxSumDivThree(new int[]{1, 2, 3, 4}));
        System.out.println("18 ?= " + maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println("12 ?= " + maxSumDivThree(new int[]{1, 2, 3, 4, 4}));

        System.out.println("9 ?= " + maxSumDivThree_bf(new int[]{1, 2, 3, 4}));
        System.out.println("18 ?= " + maxSumDivThree_bf(new int[]{3, 6, 5, 1, 8}));
        System.out.println("12 ?= " + maxSumDivThree_bf(new int[]{1, 2, 3, 4, 4}));
        System.out.println("15 ?= " + maxSumDivThree_bf(new int[]{2, 6, 2, 2, 7}));
    }
}
