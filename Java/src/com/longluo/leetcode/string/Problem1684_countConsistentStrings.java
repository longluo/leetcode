package com.longluo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 1684. 统计一致字符串的数目
 * <p>
 * 给你一个由不同字符组成的字符串allowed和一个字符串数组words。如果一个字符串的每一个字符都在allowed中，
 * 就称这个字符串是一致字符串。
 * <p>
 * 请你返回 words数组中 一致字符串的数目。
 * <p>
 * 示例 1：
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符'a'和'b'。
 * <p>
 * 示例 2：
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * <p>
 * 示例 3：
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 * <p>
 * 提示：
 * 1 <= words.length <= 10^4
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 */
public class Problem1684_countConsistentStrings {

    // HashSet time: O(n) space: O(n)
    public static int countConsistentStrings(String allowed, String[] words) {
        if (allowed == null || allowed.length() == 0) {
            return 0;
        }

        Set<Character> allowedSet = new HashSet<>();
        for (Character ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        int ans = 0;
        for (String word : words) {
            if (check(word, allowedSet)) {
                ans++;
            }
        }

        return ans;
    }

    public static boolean check(String str, Set<Character> set) {
        for (Character ch : str.toCharArray()) {
            if (!set.contains(ch)) {
                return false;
            }
        }

        return true;
    }

    // Count time: O(n) space: O(26)
    public static int countConsistentStrings_count(String allowed, String[] words) {
        int[] count = new int[26];
        for (char ch : allowed.toCharArray()) {
            count[ch - 'a']++;
        }

        int ans = 0;
        for (String s : words) {
            boolean flag = true;
            for (char ch : s.toCharArray()) {
                if (count[ch - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
        System.out.println("7 ?= " + countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println("4 ?= " + countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));

        System.out.println("4 ?= " + countConsistentStrings_count("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
    }
}
