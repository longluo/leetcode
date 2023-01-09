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

    public static void main(String[] args) {
        System.out.println("false ?= " + isItPossible("ac", "b"));
        System.out.println("true ?= " + isItPossible("ab", "b"));
        System.out.println("true ?= " + isItPossible("abcc", "aab"));
        System.out.println("true ?= " + isItPossible("abcde", "fghij"));
    }
}
