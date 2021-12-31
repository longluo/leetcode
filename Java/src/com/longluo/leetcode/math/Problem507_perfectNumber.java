package com.longluo.leetcode.math;

/**
 * 507. 完美数
 * <p>
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * <p>
 * 示例 1：
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * <p>
 * 示例 2：
 * 输入：num = 6
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：num = 496
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：num = 8128
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：num = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= num <= 10^8
 * <p>
 * https://leetcode-cn.com/problems/perfect-number/
 */
public class Problem507_perfectNumber {

    public static boolean checkPerfectNumber(int num) {
        if (num < 5) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum == num) {
            return true;
        }

        return false;
    }

    public static boolean checkPerfectNumber_fast(int num) {
        if (num < 5) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }

        if (sum == num) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + checkPerfectNumber(1));
        System.out.println("false ?= " + checkPerfectNumber(2));
        System.out.println("false ?= " + checkPerfectNumber(3));
        System.out.println("true ?= " + checkPerfectNumber(28));
        System.out.println("true ?= " + checkPerfectNumber_fast(28));
        System.out.println("true ?= " + checkPerfectNumber(6));
        System.out.println("true ?= " + checkPerfectNumber(496));
        System.out.println("true ?= " + checkPerfectNumber(8128));
    }
}

