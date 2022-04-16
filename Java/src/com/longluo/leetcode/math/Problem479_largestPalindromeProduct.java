package com.longluo.leetcode.math;

/**
 * 479. 最大回文数乘积
 * <p>
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 * <p>
 * 示例 1:
 * 输入：n = 2
 * 输出：987
 * 解释：99 x 91 = 9009, 9009 % 1337 = 987
 * <p>
 * 示例 2:
 * 输入： n = 1
 * 输出： 9
 * <p>
 * 提示:
 * 1 <= n <= 8
 * <p>
 * https://leetcode-cn.com/problems/largest-palindrome-product/
 */
public class Problem479_largestPalindromeProduct {

    // TimeOut
    public static int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        int MOD = 1337;
        int ans = 0;
        int max = (int) (Math.pow(10, n) - 1);
        int min = (int) (Math.pow(10, n - 1) - 1);
        for (long i = (long) max * max; i >= 1; i--) {
            if (isPalindrome(i)) {
                for (int j = max; j >= min; j--) {
                    if (i % j == 0 && i / j >= min && i / j <= max) {
                        return (int) (i % MOD);
                    }
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(long x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        long revisited = 0;
        while (x > revisited) {
            revisited = revisited * 10 + x % 10;
            x /= 10;
        }

        return x == revisited || x == revisited / 10;
    }

    public static boolean checkPalindrome(long num) {
        String numStr = String.valueOf(num);
        int left = 0;
        int right = numStr.length() - 1;
        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Math time: O(10^2n) space: O(1)
    public static int largestPalindrome_best(int n) {
        if (n == 1) {
            return 9;
        }

        int ans = 0;
        int max = (int) Math.pow(10, n) - 1;
        for (int i = max; ans == 0; i--) {
            long num = i;

            for (int j = i; j > 0; j /= 10) {
                num = 10 * num + j % 10;
            }

            for (long x = max; x * x >= num; x--) {
                if (num % x == 0) {
                    ans = (int) (num % 1337);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + largestPalindrome(1));
        System.out.println("987 ?= " + largestPalindrome(2));
        System.out.println("123 ?= " + largestPalindrome(3));
        System.out.println("677 ?= " + largestPalindrome(5));
        System.out.println("1218 ?= " + largestPalindrome(6));

        System.out.println("987 ?= " + largestPalindrome_best(2));
        System.out.println("123 ?= " + largestPalindrome_best(3));
    }
}
