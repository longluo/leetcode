package com.longluo.contest.biweekly_contest_80;

import java.util.HashSet;
import java.util.Set;

/**
 * 6095. 强密码检验器 II
 * <p>
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * <p>
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：password = "IloveLe3tcode!"
 * 输出：true
 * 解释：密码满足所有的要求，所以我们返回 true 。
 * 示例 2：
 * <p>
 * 输入：password = "Me+You--IsMyDream"
 * 输出：false
 * 解释：密码不包含数字，且包含 2 个连续相同的字符。所以我们返回 false 。
 * <p>
 * 示例 3：
 * 输入：password = "1aB!"
 * 输出：false
 * 解释：密码不符合长度要求。所以我们返回 false 。
 * <p>
 * 提示：
 * 1 <= password.length <= 100
 * password 包含字母，数字和 "!@#$%^&*()-+" 这些特殊字符。
 * <p>
 * https://leetcode.cn/problems/strong-password-checker-ii/
 */
public class Problem6095_strongPasswordChecker_ii {

    // Simulate time: O(n) space: O(1)
    public static boolean strongPasswordCheckerII(String password) {
        int len = password.length();
        if (len < 8) {
            return false;
        }

        int lowerCnt = 0;
        int upperCnt = 0;
        int digitCnt = 0;

        boolean specialFlag = false;
        Set<Character> special = new HashSet<>();
        for (char ch : "!@#$%^&*()-+".toCharArray()) {
            special.add(ch);
        }

        for (int i = 0; i < len; i++) {
            char ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                digitCnt++;
            } else if (Character.isUpperCase(ch)) {
                upperCnt++;
            } else if (Character.isLowerCase(ch)) {
                lowerCnt++;
            } else if (special.contains(ch)) {
                specialFlag = true;
            }

            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }
        }

        if (lowerCnt > 0 && upperCnt > 0 && digitCnt > 0 && specialFlag) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + strongPasswordCheckerII("1aB!"));
    }
}
