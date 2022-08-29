package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 * <p>
 * Medium
 * <p>
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 * <p>
 * Example 1:
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * <p>
 * Example 2:
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 * <p>
 * Constraints:
 * 1 <= s.length <= 12
 * s consists of lowercase English letters, uppercase English letters, and digits.
 * <p>
 * https://leetcode.com/problems/letter-case-permutation/
 */
public class Problem784_letterCasePermutation {

    // Backtracking time: O(2^n) space: O(n)
    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        StringBuilder path = new StringBuilder(len);
        backtrack(s, ans, path, 0);
        return ans;
    }

    private static void backtrack(String str, List<String> res, StringBuilder path, int start) {
        int len = str.length();
        if (start == len) {
            res.add(path.toString());
            return;
        }

        char ch = str.charAt(start);
        if (Character.isDigit(ch)) {
            path.append(ch);
            backtrack(str, res, path, start + 1);
            path.deleteCharAt(path.length() - 1);
        } else {
            path.append(ch);
            backtrack(str, res, path, start + 1);
            path.deleteCharAt(path.length() - 1);

            if (Character.isUpperCase(ch)) {
                path.append(Character.toLowerCase(ch));
                backtrack(str, res, path, start + 1);
                path.deleteCharAt(path.length() - 1);
            } else if (Character.isLowerCase(ch)) {
                path.append(Character.toUpperCase(ch));
                backtrack(str, res, path, start + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("[a1b2, a1B2, A1b2, A1B2] ?= " + letterCasePermutation("a1b2"));
    }
}
