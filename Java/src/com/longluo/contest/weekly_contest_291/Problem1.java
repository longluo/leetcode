package com.longluo.contest.weekly_contest_291;

/**
 * https://leetcode.cn/contest/weekly-contest-291/
 */

/**
 * https://leetcode.cn/problems/remove-digit-from-number-to-maximize-result/
 */
public class Problem1 {

    public static String removeDigit(String number, char digit) {
        int len = number.length();

        if (number.charAt(0) == digit && number.charAt(1) > digit) {
            return number.substring(1);
        }

        String ans = "";

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder(len);
            char ch = number.charAt(i);
            if (ch == digit) {
                sb.append(number, 0, i).append(number, i + 1, len);
                if (ans.length() == 0) {
                    ans = sb.toString();
                } else if (ans.length() > 0 && ans.compareTo(sb.toString()) < 0) {
                    ans = sb.toString();
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + removeDigit("123", '3'));
        System.out.println("1554 ?= " + removeDigit("15454", '4'));
        System.out.println("231 ?= " + removeDigit("1231", '1'));
        System.out.println("51 ?= " + removeDigit("551", '5'));
        System.out.println("13325 ?= " + removeDigit("133235", '3'));
        System.out.println("8577 ?= " + removeDigit("58577", '5'));
        System.out.println("89577 ?= " + removeDigit("589577", '5'));
    }
}
