package com.longluo.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // Backtrack time: O(3^m * 4^n) space: O(m+n)
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        backtrack(ans, new StringBuilder(), digits, map, 0);
        return ans;
    }

    public static void backtrack(List<String> res, StringBuilder sb, String digits, Map<Integer, String> map, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int number = digits.charAt(idx) - '0';
        String numStr = map.get(number);
        for (int i = 0; i < numStr.length(); i++) {
            sb.append(numStr.charAt(i));
            backtrack(res, sb, digits, map, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // BF time: O() space: O()
    public static List<String> letterCombinations_bf(String digits) {
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

    public static void main(String[] args) {
        System.out.println("[a, b, c] ?= " + letterCombinations_bf("2"));
        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf] ?= " + letterCombinations_bf("23"));

        System.out.println("[ad, ae, af, bd, be, bf, cd, ce, cf] ?= " + letterCombinations("23"));
    }
}
