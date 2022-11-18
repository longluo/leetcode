package com.longluo.leetcode.math;

/**
 * 263. 丑数
 * <p>
 * 丑数 就是只包含质因数2、3 和 5的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 * 示例 2：
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * <p>
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * 示例 4：
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 * <p>
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * https://leetcode.cn/problems/ugly-number/
 */
public class Problem263_uglyNumber {

    // Recursion time: O(logn) space: O(logn)
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 == 0) {
            return isUgly(n / 2);
        }

        if (n % 3 == 0) {
            return isUgly(n / 3);
        }

        if (n % 5 == 0) {
            return isUgly(n / 5);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isUgly(1));
        System.out.println("false ?= " + isUgly(0));
        System.out.println("true ?= " + isUgly(6));
        System.out.println("true ?= " + isUgly(8));
        System.out.println("false ?= " + isUgly(14));
    }

}
