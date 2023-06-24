package com.longluo.contest.biweekly_contest_107;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-107
 */
public class Problem1 {

    public static int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;

        int ans = 0;

        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (seen[i]) {
                continue;
            }

            String reverse = new StringBuilder(words[i]).reverse().toString();

            for (int j = i + 1; j < n; j++) {
                if (seen[j]) {
                    continue;
                }

                if (words[j].equals(reverse)) {
                    ans++;
                    break;
                }
            }

            seen[i] = true;
        }

        return ans;
    }

    public static int maximumNumberOfStringPairs_set(String[] words) {
        Set<String> set = new HashSet<>();

        for (String word : words) {
            set.add(word);
        }

        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            if (!set.contains(words[i]) || words[i].charAt(0) == words[i].charAt(1)) {
                continue;
            }

            String reverse = new StringBuilder(words[i]).reverse().toString();

            if (set.contains(reverse)) {
                ans++;
                set.remove(words[i]);
                set.remove(reverse);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + maximumNumberOfStringPairs(new String[]{"aa", "ab"}));
        System.out.println("1 ?= " + maximumNumberOfStringPairs(new String[]{"ab", "ba", "cc"}));
        System.out.println("2 ?= " + maximumNumberOfStringPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));
        System.out.println("2 ?= " + maximumNumberOfStringPairs_set(new String[]{"cd", "ac", "dc", "ca", "zz"}));
    }
}
