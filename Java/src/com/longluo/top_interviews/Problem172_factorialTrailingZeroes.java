package com.longluo.top_interviews;

import java.math.BigInteger;

/**
 * 172. 阶乘后的零
 * <p>
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * <p>
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 提示：
 * 0 <= n <= 10^4
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * <p>
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class Problem172_factorialTrailingZeroes {

    // BigInteger time: O() space: O(1)
    // TLE
    public static int trailingZeroes_bf(int n) {
        BigInteger nFactorResult = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorResult = nFactorResult.multiply(BigInteger.valueOf(i));
        }

        int ans = 0;
        while (nFactorResult.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            ans++;
            nFactorResult = nFactorResult.divide(BigInteger.TEN);
        }

        return ans;
    }

    // Count 5 time: O(n) space: O(1)
    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i++) {
            int temp = i;
            while (temp % 5 == 0) {
                ans++;
                temp /= 5;
            }
        }

        return ans;
    }

    // Count 5 Opt time: O(logn) space: O(1)
    public static int trailingZeroes_log(int n) {
        int ans = 0;
        while (n > 0) {
            n /= 5;
            ans += n;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + trailingZeroes(0));
        System.out.println("0 ?= " + trailingZeroes(1));
        System.out.println("0 ?= " + trailingZeroes(3));
        System.out.println("0 ?= " + trailingZeroes_log(3));
        System.out.println("1 ?= " + trailingZeroes(5));
        System.out.println("1 ?= " + trailingZeroes_log(5));
        System.out.println("1 ?= " + trailingZeroes_bf(15));
    }
}
