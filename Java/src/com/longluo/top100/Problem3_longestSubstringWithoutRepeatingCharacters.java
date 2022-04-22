package com.longluo.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Medium
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Problem3_longestSubstringWithoutRepeatingCharacters {

    // HashSet + Win time: O(n) space: O(k)
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }

        int ans = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < len) {
            while (right < len && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }

            ans = Math.max(ans, right - left);
            set.remove(s.charAt(left));
            left++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("1 ?= " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("3 ?= " + lengthOfLongestSubstring("pwwkew"));
    }
}
