package com.longluo.top100;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n <= 19
 * <p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class Problem96_uniqueBinarySearchTrees {

    // DP Math time: O(n^2) space: O(n)
    public static int numTrees(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i - 2; j++) {
                sum += dp[j] * dp[i - 1 - j];
            }
            dp[i] = 2 * dp[i - 1] + sum;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numTrees(1));
        System.out.println("2 ?= " + numTrees(2));
        System.out.println("5 ?= " + numTrees(3));
        System.out.println("14 ?= " + numTrees(4));
    }
}
