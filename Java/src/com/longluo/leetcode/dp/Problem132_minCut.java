package com.longluo.leetcode.dp;

/**
 * 132. 分割回文串 II
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的最少分割次数 。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * 提示：
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 */
public class Problem132_minCut {

    public static int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int ans = 0;


        return ans;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minCut("aab"));
        System.out.println("0 ?= " + minCut("a"));
        System.out.println("1 ?= " + minCut("ab"));
    }
}
