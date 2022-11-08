package com.longluo.leetcode.stack;

/**
 * https://leetcode.cn/problems/make-the-string-great/
 */
public class Problem1544_makeTheStringGreat {

    // Stack time: O(n) space: O(n)
    public static String makeGood(String s) {
        int len = s.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (sb.length() == 0) {
                sb.append(ch);
                continue;
            }

            if ((Character.isUpperCase(ch) && sb.charAt(sb.length() - 1) == Character.toLowerCase(ch))
                    || (Character.isLowerCase(ch) && sb.charAt(sb.length() - 1) == Character.toUpperCase(ch))) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }

            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("leetcode ?= " + makeGood("leEeetcode"));
        System.out.println(" ?= " + makeGood("abBAcC"));
        System.out.println("s ?= " + makeGood("s"));
    }
}
