package com.longluo.leetcode.memoization;

/**
 * 1137. 第 N 个泰波那契数
 * <p>
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * 提示：
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <p>
 * https://leetcode.cn/problems/n-th-tribonacci-number/
 */
public class Problem1137_nThTribonacciNumber {

    // Recursion time: O(n) space: O(n)
    // TLE
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    // DP time: O(n) space: O(n)
    public static int tribonacci_dp(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    // DP time: O(n) space: O(1)
    public static int tribonacci_dp_opt(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int i_3 = 0;
        int i_2 = 1;
        int i_1 = 1;

        int ans = 0;

        for (int i = 3; i <= n; i++) {
            ans = i_3 + i_2 + i_1;
            i_3 = i_2;
            i_2 = i_1;
            i_1 = ans;
        }

        return ans;
    }

    // Look Up Table time: O(C) space: O(1)
    static int[] nums = {0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103};

    public static int tribonacci_table(int n) {
        return nums[n];
    }

    // Math time: O(logn) sapce: O(C)
    public static int tribonacci_math(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        int[][] q = {{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        int[][] res = pow(q, n);
        return res[0][2];
    }

    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j] + a[i][2] * b[2][j];
            }
        }

        return c;
    }

    // DP time: O(n) space: O(1)
    public static int tribonacci_opt(int n) {
        int dp[] = {0, 1, 1};

        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        }

        return dp[n % 3];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + tribonacci(1));
        System.out.println("4 ?= " + tribonacci(4));
        System.out.println("1389537 ?= " + tribonacci(25));

        System.out.println("0 ?= " + tribonacci_dp(0));
        System.out.println("1 ?= " + tribonacci_dp(1));
        System.out.println("1 ?= " + tribonacci_dp(2));
        System.out.println("2 ?= " + tribonacci_dp(3));
        System.out.println("4 ?= " + tribonacci_dp(4));
        System.out.println("1389537 ?= " + tribonacci_dp(25));

        System.out.println("0 ?= " + tribonacci_dp_opt(0));
        System.out.println("1 ?= " + tribonacci_dp_opt(1));
        System.out.println("1 ?= " + tribonacci_dp_opt(2));
        System.out.println("2 ?= " + tribonacci_dp_opt(3));
        System.out.println("4 ?= " + tribonacci_dp_opt(4));
        System.out.println("1389537 ?= " + tribonacci_dp_opt(25));

        System.out.println("2 ?= " + tribonacci_table(3));
        System.out.println("4 ?= " + tribonacci_table(4));
        System.out.println("1389537 ?= " + tribonacci_table(25));

        System.out.println("4 ?= " + tribonacci_math(4));
        System.out.println("1389537 ?= " + tribonacci_math(25));

        System.out.println("0 ?= " + tribonacci_opt(0));
        System.out.println("1 ?= " + tribonacci_opt(1));
        System.out.println("2 ?= " + tribonacci_opt(3));
        System.out.println("4 ?= " + tribonacci_opt(4));
        System.out.println("4 ?= " + tribonacci_opt(6));

        for (int i = 0; i <= 37; i++) {
            System.out.print("," + tribonacci_dp_opt(i));
        }
    }
}
