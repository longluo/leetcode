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
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * <p>
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class Problem1137_nThTribonacciNumber {

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = res[2] = 1;

        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 3] + res[i - 2] + res[i - 1];
        }

        return res[n];
    }

    public static int tribonacci_iter(int n) {
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

    public static int tribonacci_recursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }

        return tribonacci_recursive(n - 1) + tribonacci_recursive(n - 2) + tribonacci_recursive(n - 3);
    }

    static int[] nums = {0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103};
    public static int tribonacci_fast(int n) {
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + tribonacci(0));
        System.out.println("0 ?= " + tribonacci_iter(0));
        System.out.println("1 ?= " + tribonacci(1));
        System.out.println("1 ?= " + tribonacci_iter(1));
        System.out.println("1 ?= " + tribonacci(2));
        System.out.println("1 ?= " + tribonacci_iter(2));
        System.out.println("2 ?= " + tribonacci(3));
        System.out.println("2 ?= " + tribonacci_iter(3));
        System.out.println("4 ?= " + tribonacci(4));
        System.out.println("4 ?= " + tribonacci_iter(4));
        System.out.println("1389537 ?= " + tribonacci(25));
        System.out.println("1389537 ?= " + tribonacci_iter(25));

        for (int i = 0; i <= 37; i++) {
            System.out.print("," + tribonacci_iter(i));
        }
    }
}
