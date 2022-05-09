package com.longluo.top100;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * <p>
 * Medium
 * <p>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * Input: digits = ""
 * Output: []
 * <p>
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * <p>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Problem17_letterCombinationsOfAPhoneNumber {

    // BF time: O(4^n) space: O(n)
    public static List<String> letterCombinations_4Loops(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        int[] digitsArr = new int[len];
        for (int i = 0; i < len; i++) {
            digitsArr[i] = digits.charAt(i) - '0';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("a");
        }

        for (int i = 0; i < letters[digitsArr[0] - 2].length(); i++) {
            sb.replace(0, 1, letters[digitsArr[0] - 2].charAt(i) + "");
            if (len == 1) {
                ans.add(sb.substring(0, 1));
            }

            for (int j = 0; len >= 2 && j < letters[digitsArr[1] - 2].length(); j++) {
                sb.replace(1, 2, letters[digitsArr[1] - 2].charAt(j) + "");
                if (len == 2) {
                    ans.add(sb.toString());
                }

                for (int k = 0; len >= 3 && k < letters[digitsArr[2] - 2].length(); k++) {
                    sb.replace(2, 3, letters[digitsArr[2] - 2].charAt(k) + "");
                    if (len == 3) {
                        ans.add(sb.toString());
                    }

                    for (int l = 0; len >= 4 && l < letters[digitsArr[3] - 2].length(); l++) {
                        sb.replace(3, 4, letters[digitsArr[3] - 2].charAt(l) + "");
                        ans.add(sb.toString());
                    }
                }
            }
        }

        return ans;
    }

    // Backtrack time: O(3^m * 4^n) space: O(m+n)
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        String[] lettersMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(ans, new StringBuilder(), digits, lettersMap, 0);
        return ans;
    }

    public static void backtrack(List<String> res, StringBuilder sb, String digits, String[] lettersMap, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int number = digits.charAt(idx) - '0';
        String numStr = lettersMap[number - 2];
        for (int i = 0; i < numStr.length(); i++) {
            sb.append(numStr.charAt(i));
            backtrack(res, sb, digits, lettersMap, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // BFS time: O((M + N) * (3^M×4^N)*4) space: O(2 * 3^M×4^N)
    public static List<String> letterCombinations_bfs(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (char digit : digits.toCharArray()) {
            String curLetters = letters[digit - '2'];
            List<String> newRes = new ArrayList<>();

            for (String item : res) {
                for (char curDigit : curLetters.toCharArray()) {
                    newRes.add(item + curDigit);
                }
            }

            res = newRes;
        }

        return res;
    }

    // Queue time: O(3^m * 4^n) space: O(3^m * 4^n)
    public static List<String> letterCombinations_queue(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        int len = digits.length();
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        int[] digitsArr = new int[len];
        for (int i = 0; i < len; i++) {
            digitsArr[i] = digits.charAt(i) - '0';
        }

        queue.offer("");
        for (int i = 0; i < len; i++) {
            String letter = letters[digitsArr[i] - 2];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                for (char ch : letter.toCharArray()) {
                    queue.offer(temp + ch);
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        System.out.println("[a, b, c] ?= " + letterCombinations_4Loops("2"));
        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf] ?= " + letterCombinations_4Loops("23"));

        System.out.println("[a, b, c] ?= " + letterCombinations_bfs("2"));
        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf] ?= " + letterCombinations_bfs("23"));

        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf] ?= " + letterCombinations("23"));

        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf] ?= " + letterCombinations_bfs("23"));

        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf] ?= " + letterCombinations_queue("23"));
    }
}
