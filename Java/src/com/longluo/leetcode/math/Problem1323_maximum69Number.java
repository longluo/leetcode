package com.longluo.leetcode.math;

/**
 * 1323. 6 和 9 组成的最大数字
 * <p>
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * <p>
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * <p>
 * 请返回你可以得到的最大数字。
 * <p>
 * 示例 1：
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * <p>
 * 示例 2：
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * <p>
 * 示例 3：
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 * <p>
 * 提示：
 * 1 <= num <= 10^4
 * num 每一位上的数字都是 6 或者 9 。
 * <p>
 * https://leetcode.cn/problems/maximum-69-number/
 */
public class Problem1323_maximum69Number {

    // String time: O(n) space: O(n)
    public static int maximum69Number(int num) {
        char[] array = String.valueOf(num).toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '6') {
                array[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(array));
    }

    // Math time: O(logn) space: O(1)
    public static int maximum69Number_math(int num) {
        int base = 1000;

        int ans = 0;

        while (num > 0) {
            int digit = num / base;

            if (digit == 6) {
                digit = 9;
                ans += digit * base + num % base;
                break;
            } else {
                ans += digit * base;
            }

            num %= base;
            base /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("9969 ?= " + maximum69Number(9669));
        System.out.println("9999 ?= " + maximum69Number(9996));
        System.out.println("9999 ?= " + maximum69Number(9999));

        System.out.println("9969 ?= " + maximum69Number_math(9669));
    }
}
