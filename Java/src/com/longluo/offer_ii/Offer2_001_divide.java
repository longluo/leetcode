package com.longluo.offer_ii;

/**
 * 剑指 Offer II 001. 整数除法
 * <p>
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * <p>
 * 注意：
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31−1]。本题中，如果除法结果溢出，则返回 2^31 − 1
 * <p>
 * 示例 1：
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * <p>
 * 示例 2：
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 示例 3：
 * 输入：a = 0, b = 1
 * 输出：0
 * <p>
 * 示例 4：
 * 输入：a = 1, b = 1
 * 输出：1
 * <p>
 * 提示:
 * -2^31 <= a, b <= 2^31 - 1
 * b != 0
 * <p>
 * 注意：本题与主站 29 题相同：https://leetcode.cn/problems/divide-two-integers/
 * <p>
 * https://leetcode.cn/problems/xoh6Oh/
 */
public class Offer2_001_divide {

    // Brute Force time: O(x/y) space: O(1)
    // Edge Cases
    public static int divide(int a, int b) {
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }

        if (a == 0) {
            return 0;
        }

        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            } else if (b == -1) {
                return Integer.MAX_VALUE;
            }
        } else if (a == Integer.MAX_VALUE) {
            if (b == 1) {
                return a;
            } else if (b == -1) {
                return -a;
            }
        }

        int ans = 0;
        boolean sign = true;
        if (a > 0 && b > 0) {
            a = -a;
            sign = false;
        } else if (a > 0 && b < 0) {
            a = -a;
            b = -b;
        } else if (a < 0 && b < 0) {
            sign = false;
            b = -b;
        }

        // Minus
        while (a + b <= 0) {
            a += b;
            ans++;
        }

        return sign ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println("7 ?= " + divide(15, 2));
        System.out.println("-2 ?= " + divide(7, -3));
        System.out.println("0 ?= " + divide(0, 1));
        System.out.println("1 ?= " + divide(1, 1));
    }
}
