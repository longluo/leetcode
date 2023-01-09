package com.longluo.contest.weekly_contest_327;

/**
 * https://leetcode.cn/contest/weekly-contest-327
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/make-number-of-distinct-characters-equal/
 */
public class Problem3 {

    // BF time: O(mn(m+n)) space: O(m+n)
    // TLE
    public static boolean isItPossible(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Character> setA = new HashSet<>();
                Set<Character> setB = new HashSet<>();

                for (int k = 0; k < m; k++) {
                    if (k != i) {
                        setA.add(word1.charAt(k));
                    }
                }

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        setB.add(word2.charAt(k));
                    }
                }

                setA.add(word2.charAt(j));
                setB.add(word1.charAt(i));

                if (setA.size() == setB.size()) {
                    return true;
                }
            }
        }

        return false;
    }

    // BF Opt time: O(mn*26) space: O(C)
    // TLE
    public static boolean isItPossible_opt(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] cntA = new int[26];
        int[] cntB = new int[26];

        for (char ch : word1.toCharArray()) {
            cntA[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            cntB[ch - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cntA[word1.charAt(i) - 'a']--;
                cntB[word2.charAt(j) - 'a']--;

                cntA[word2.charAt(j) - 'a']++;
                cntB[word1.charAt(i) - 'a']++;

                int p = 0;
                int q = 0;

                for (int k = 0; k < 26; k++) {
                    if (cntA[k] > 0) {
                        p++;
                    }

                    if (cntB[k] > 0) {
                        q++;
                    }
                }

                if (p == q) {
                    return true;
                }

                cntA[word1.charAt(i) - 'a']++;
                cntB[word2.charAt(j) - 'a']++;

                cntA[word2.charAt(j) - 'a']--;
                cntB[word1.charAt(i) - 'a']--;
            }
        }

        return false;
    }

    // HashMap time: O(mn) space: O(m+n)
    // TLE
    public static boolean isItPossible_hashmap(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            mapA.put(ch, mapA.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cntA = mapA.size();
                int cntB = mapB.size();

                if (word1.charAt(i) == word2.charAt(j)) {
                    if (cntA == cntB) {
                        return true;
                    }

                    continue;
                }

                if (mapA.get(word1.charAt(i)) == 1) {
                    cntA--;
                }

                if (!mapA.containsKey(word2.charAt(j))) {
                    cntA++;
                }

                if (!mapB.containsKey(word1.charAt(i))) {
                    cntB++;
                }

                if (mapB.get(word2.charAt(j)) == 1) {
                    cntB--;
                }

                if (cntA == cntB) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isItPossible("ac", "b"));
        System.out.println("true ?= " + isItPossible("ab", "b"));
        System.out.println("true ?= " + isItPossible("abcc", "aab"));
        System.out.println("true ?= " + isItPossible("abcde", "fghij"));

        System.out.println("false ?= " + isItPossible_opt("ac", "b"));
        System.out.println("true ?= " + isItPossible_opt("ab", "b"));
        System.out.println("false ?= " + isItPossible_opt("a", "bb"));

        System.out.println("false ?= " + isItPossible_hashmap("aa", "ab"));
        System.out.println("false ?= " + isItPossible_hashmap("aa", "bcd"));
        System.out.println("true ?= " + isItPossible_hashmap("ab", "b"));
        System.out.println("false ?= " + isItPossible_hashmap("a", "bb"));
    }
}
