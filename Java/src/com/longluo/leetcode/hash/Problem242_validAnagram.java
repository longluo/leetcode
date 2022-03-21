package com.longluo.leetcode.hash;

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

    public static boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }

        if (sLen > 1 && s.equals(t)) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < sLen; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            if (!tMap.containsKey(ch) || (cnt != tMap.get(ch))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isAnagram("a", "a"));
        System.out.println("false ?= " + isAnagram("a", "b"));
        System.out.println("true ?= " + isAnagram("anagram", "nagaram"));
        System.out.println("false ?= " + isAnagram("rat", "car"));
    }
}
