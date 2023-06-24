package com.longluo.contest.biweekly_contest_107;

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

    public static void main(String[] args) {
        System.out.println("0 ?= " + maximumNumberOfStringPairs(new String[]{"aa", "ab"}));
        System.out.println("1 ?= " + maximumNumberOfStringPairs(new String[]{"ab", "ba", "cc"}));
        System.out.println("2 ?= " + maximumNumberOfStringPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));
    }
}
