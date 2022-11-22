package com.longluo.leetcode.math;

import java.util.HashSet;

/**
 * 878. 第 N 个神奇数字
 * <p>
 * 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
 * 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10^9 + 7 取模 后的值。
 * <p>
 * 示例 1：
 * 输入：n = 1, a = 2, b = 3
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 4, a = 2, b = 3
 * 输出：6
 * <p>
 * 提示：
 * 1 <= n <= 10^9
 * 2 <= a, b <= 4 * 10^4
 * <p>
 * https://leetcode.cn/problems/nth-magical-number/
 */
public class Problem878_nthMagicalNumber {

    // BF time: O(max(a^n, b^n, (ab)^n) space: O(1)
    // TLE
    public static int nthMagicalNumber_bf(int n, int a, int b) {
        int mod = 1_000_000_007;

        int idx = 1;
        long num = 1;

        while (idx <= n) {
            num++;

            if (num % a == 0 || num % b == 0) {
                idx++;
            }
        }

        return (int) (num % mod);
    }

    // DP time: O(n) space: O(n)
    // MLE
    public static int nthMagicalNumber_dp(int n, int a, int b) {
        int mod = 1_000_000_007;

        long[] dp = new long[n + 1];

        int p = 1;
        int q = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(p * a, q * b);
            if (dp[i] % a == 0 && dp[i] % b == 0) {
                p++;
                q++;
            } else if (dp[i] % a == 0) {
                p++;
            } else {
                q++;
            }
        }

        return (int) (dp[n] % mod);
    }

    // DP time: O(n) space: O(1)
    // TLE
    public static int nthMagicalNumber_dp_opt(int n, int a, int b) {
        int mod = 1_000_000_007;

        long ans = 1;

        int p = 1;
        int q = 1;

        for (int i = 1; i <= n; i++) {
            ans = Math.min(p * a, q * b);
            if (ans % a == 0 && ans % b == 0) {
                p++;
                q++;
            } else if (ans % a == 0) {
                p++;
            } else {
                q++;
            }
        }

        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + nthMagicalNumber_bf(1, 2, 3));
        System.out.println("6 ?= " + nthMagicalNumber_bf(4, 2, 3));

        System.out.println("2 ?= " + nthMagicalNumber_dp(1, 2, 3));
        System.out.println("10 ?= " + nthMagicalNumber_dp(5, 2, 4));
        System.out.println("6 ?= " + nthMagicalNumber_dp(4, 2, 3));

        System.out.println("10 ?= " + nthMagicalNumber_dp_opt(5, 2, 4));
        System.out.println("6 ?= " + nthMagicalNumber_dp_opt(4, 2, 3));
    }
}
