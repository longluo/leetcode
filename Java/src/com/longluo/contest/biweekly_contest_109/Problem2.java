package com.longluo.contest.biweekly_contest_109;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-109
 */
public class Problem2 {

    public static String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>();

        for (char ch : "AEIOUaeiou".toCharArray()) {
            vowels.add(ch);
        }

        List<Character> list = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                list.add(ch);
            }
        }

        if (list.size() == 0) {
            return s;
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        int idx = 0;

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                sb.append(list.get(idx));
                idx++;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("lEOtcede ?= " + sortVowels("lEetcOde"));
        System.out.println("lYmpH ?= " + sortVowels("lYmpH"));
    }
}
