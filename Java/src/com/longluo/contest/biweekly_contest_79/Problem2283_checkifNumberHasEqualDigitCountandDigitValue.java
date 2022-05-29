package com.longluo.contest.biweekly_contest_79;

/**
 * 6083. 判断一个数的数字计数是否等于数位的值
 * <p>
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 * <p>
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：num = "1210"
 * 输出：true
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * "1210" 满足题目要求条件，所以返回 true 。
 * <p>
 * 示例 2：
 * 输入：num = "030"
 * 输出：false
 * 解释：
 * num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了一次。
 * num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
 * num[2] = '0' 。数字 2 在 num 中出现了 0 次。
 * 下标 0 和 1 都违反了题目要求，所以返回 false 。
 * <p>
 * 提示：
 * n == num.length
 * 1 <= n <= 10
 * num 只包含数字。
 * <p>
 * https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */
public class Problem2283_checkifNumberHasEqualDigitCountandDigitValue {

    // Simulate time: O(n) space: O(n)
    public static boolean digitCount(String num) {
        int len = num.length();
        int[] cnt = new int[10];
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            cnt[ch - '0']++;
        }

        for (int i = 0; i < len; i++) {
            int freq = num.charAt(i) - '0';
            if (cnt[i] != freq) {
                return false;
            }
        }

        return true;
    }

    //  Simulate time: O(n^2) space: O(1)
    public static boolean digitCount_bf(String num) {
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = (char) ('0' + i);
            int cnt = 0;
            for (char ch : num.toCharArray()) {
                if (ch == digit) {
                    cnt++;
                }
            }

            if (cnt != (num.charAt(i) - '0')) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + digitCount("1210"));
        System.out.println("true ?= " + digitCount_bf("1210"));
        System.out.println("false ?= " + digitCount("030"));
        System.out.println("false ?= " + digitCount_bf("030"));
    }
}
