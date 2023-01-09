package com.longluo.contest.weekly_contest_327;

/**
 * https://leetcode.cn/contest/weekly-contest-327
 */

import java.util.HashSet;
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

    public static void main(String[] args) {
        System.out.println("false ?= " + isItPossible("ac", "b"));
        System.out.println("true ?= " + isItPossible("ab", "b"));
        System.out.println("true ?= " + isItPossible("abcc", "aab"));
        System.out.println("true ?= " + isItPossible("abcde", "fghij"));

        System.out.println("false ?= " + isItPossible_opt("ac", "b"));
        System.out.println("true ?= " + isItPossible_opt("ab", "b"));
        System.out.println("false ?= " + isItPossible_opt("a", "bb"));
    }
}
