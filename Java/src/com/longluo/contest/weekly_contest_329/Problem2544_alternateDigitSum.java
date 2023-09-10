package com.longluo.contest.weekly_contest_329;

/**
 * https://leetcode.cn/contest/weekly-contest-329
 */

/**
 * 2544. 交替数字和
 * <p>
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 * <p>
 * 示例 1：
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * <p>
 * 示例 2：
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * <p>
 * 示例 3：
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 * <p>
 * 提示：
 * 1 <= n <= 10^9
 * <p>
 * https://leetcode.cn/problems/alternating-digit-sum/
 */
public class Problem2544_alternateDigitSum {

    public static int alternateDigitSum(int n) {
        int ans = 0;

        String s = String.valueOf(n);

        int flag = 1;

        for (char ch : s.toCharArray()) {
            int digit = ch - '0';
            ans += flag * digit;
            flag = -1 * flag;
        }

        return ans;
    }

    // Math time: O(logn) space: O(1)
    public static int alternateDigitSum_opt(int n) {
        int flag = 1;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += flag * digit;
            flag *= -1;
            n /= 10;
        }

        return flag < 0 ? sum : -sum;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + alternateDigitSum(521));
        System.out.println("1 ?= " + alternateDigitSum(111));

        System.out.println("4 ?= " + alternateDigitSum_opt(521));
        System.out.println("3 ?= " + alternateDigitSum_opt(52));
    }
}