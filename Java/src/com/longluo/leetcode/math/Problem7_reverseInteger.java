package com.longluo.leetcode.math;

import java.util.Arrays;

/**
 * 7. 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * <p>
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Problem7_reverseInteger {

    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }

        int ans = 0;
        while (x > 0) {
            int temp = x % 10;
            if (ans > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + temp;
            x /= 10;
        }

        if (flag) {
            ans = -ans;
        }

        return ans;
    }

    public static int reverse_opt(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println("321 ?= " + reverse(123));
        System.out.println("-321 ?= " + reverse(-123));
        System.out.println("21 ?= " + reverse(120));
        System.out.println("0 ?= " + reverse(0));
        System.out.println("0 ?= " + reverse(1534236469));

        System.out.println("21 ?= " + reverse_opt(120));
        System.out.println("0 ?= " + reverse_opt(1534236469));
        System.out.println("Max= " + Integer.MAX_VALUE + ", Min=" + Integer.MIN_VALUE);
    }
}
