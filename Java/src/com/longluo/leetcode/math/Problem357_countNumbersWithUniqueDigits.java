package com.longluo.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 357. 统计各位数字都不同的数字个数
 * <p>
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * 0 <= n <= 8
 * <p>
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 */
public class Problem357_countNumbersWithUniqueDigits {

    // BF to String time: O(10^n) space: O(n)
    // TimeOut
    public static int countNumbersWithUniqueDigits_bf(int n) {
        int start = 0;
        int end = (int) Math.pow(10, n);
        int ans = 0;
        for (int i = start; i < end; i++) {
            if (!isDigitUnique_str(i)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean isDigitUnique_str(int num) {
        String numStr = String.valueOf(num);
        Set<Character> seen = new HashSet<>();
        for (char ch : numStr.toCharArray()) {
            if (!seen.add(ch)) {
                return true;
            }
        }

        return false;
    }

    //
    public static int countNumbersWithUniqueDigits_math(int n) {
        int start = 0;
        int end = (int) Math.pow(10, n);
        int ans = 0;
        for (int i = start; i < end; i++) {
            if (!isDigitUnique_math(i)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean isDigitUnique_math(int num) {
        Set<Integer> seen = new HashSet<>();
        while (num != 0) {
            int digit = num % 10;
            if (!seen.add(digit)) {
                return true;
            }
            num /= 10;
        }

        return false;
    }

    // Permutation time: O(n) space: O(1)
    public static int countNumbersWithUniqueDigits_perm(int n) {
        if (n == 0) {
            return 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans += 10;
            } else {
                int sum = 9;
                for (int j = 0; j <= (i - 1); j++) {
                    sum *= (9 - j);
                }
                ans += sum;
            }
        }

        return ans;
    }

    public static int countNumbersWithUniqueDigits_perm_opt(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }

        int res = 10;
        int cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= (9 - i);
            res += cur;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + countNumbersWithUniqueDigits_bf(0));
        System.out.println("11 ?= " + countNumbersWithUniqueDigits_bf(1));
        System.out.println("91 ?= " + countNumbersWithUniqueDigits_bf(2));

        System.out.println("91 ?= " + countNumbersWithUniqueDigits_math(2));

        System.out.println("1 ?= " + countNumbersWithUniqueDigits_perm(0));
        System.out.println("91 ?= " + countNumbersWithUniqueDigits_perm(2));
        System.out.println("739 ?= " + countNumbersWithUniqueDigits_perm(3));

        System.out.println("91 ?= " + countNumbersWithUniqueDigits_perm_opt(2));
        System.out.println("739 ?= " + countNumbersWithUniqueDigits_perm_opt(3));
    }
}
