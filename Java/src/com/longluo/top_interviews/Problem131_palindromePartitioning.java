package com.longluo.top_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/palindrome-partitioning/
 */
public class Problem131_palindromePartitioning {

    // Backtrack time: O(2^n) space: O(n)
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), s, 0);
        return ans;
    }

    private static void backtrack(List<List<String>> res, List<Integer> path, String s, int idx) {
        if (idx == s.length()) {
            List<String> onePart = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                int begin = i == 0 ? 0 : path.get(i - 1);
                int end = i == path.size() - 1 ? s.length() : path.get(i);
                onePart.add(s.substring(begin, end));
            }

            res.add(onePart);
            return;
        }

        int len = s.length();
        for (int i = idx + 1; i <= len; i++) {
            String subStr = s.substring(idx, i);
            if (!isPalindrome(subStr)) {
                continue;
            }

            path.add(i);
            backtrack(res, path, s, i);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("[[a, a, b],[aa, b]] ?= " + partition("aab"));
    }
}
