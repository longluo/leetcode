package com.longluo.studyplan.programming_skills;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * <p>
 * Easy
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * <p>
 * https://leetcode.com/problems/valid-anagram/
 */
public class Problem242_validAnagram {

    // HashMap time: O(n) space: O(S) = O(26)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int len = s.length();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            if (!tMap.containsKey(ch) || cnt != tMap.get(ch)) {
                return false;
            }
        }

        return true;
    }

    // Count time: O(n) space: O(S) = O(26)
    public static boolean isAnagram_arr(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int len = s.length();
        int[] sCnt = new int[26];
        int[] tCnt = new int[26];
        for (int i = 0; i < len; i++) {
            sCnt[s.charAt(i) - 'a']++;
            tCnt[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCnt[i] != tCnt[i]) {
                return false;
            }
        }

        return true;
    }

    // Count Opt time: O(n) space: O(S) = O(26)
    public static boolean isAnagram_cnt(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int len = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < len; i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] < 0) {
                return false;
            }
        }

        return true;
    }

    // Sort time: O(nlogn) space: O(n)
    public static boolean isAnagram_sort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isAnagram("a", "a"));
        System.out.println("false ?= " + isAnagram("a", "b"));
        System.out.println("true ?= " + isAnagram("anagram", "nagaram"));
        System.out.println("false ?= " + isAnagram("rat", "car"));

        System.out.println("true ?= " + isAnagram_arr("a", "a"));
        System.out.println("false ?= " + isAnagram_arr("a", "b"));
        System.out.println("true ?= " + isAnagram_arr("anagram", "nagaram"));
        System.out.println("false ?= " + isAnagram_arr("rat", "car"));

        System.out.println("false ?= " + isAnagram_cnt("rat", "car"));

        System.out.println("true ?= " + isAnagram_sort("a", "a"));
        System.out.println("false ?= " + isAnagram_sort("a", "b"));
        System.out.println("false ?= " + isAnagram_sort("abc", "abc"));
        System.out.println("true ?= " + isAnagram_sort("anagram", "nagaram"));
        System.out.println("false ?= " + isAnagram_sort("rat", "car"));
    }
}
