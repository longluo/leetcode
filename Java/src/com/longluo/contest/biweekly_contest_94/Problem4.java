package com.longluo.contest.biweekly_contest_94;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/biweekly-contest-94
 */

public class Problem4 {

    public static int countAnagrams(String s) {
        int mod = 1_000_000_007;

        long ans = 1;

        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            Map<Character, Integer> map = new HashMap<>();
            for (char ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            long total = 1;
            for (int j = 1; j <= word.length(); j++) {
                total = total * j;
                total = total % mod;
            }

            long divsor = 1;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                int freq = entry.getValue();
                if (freq > 1) {
                    divsor = divsor * fractor(freq);
                    divsor = divsor % mod;
                }
            }

            ans = ans * total / divsor;
            ans = ans % mod;
        }

        return (int) ans;
    }

    private static long fractor(long k) {
        long ans = 1;

        for (long i = 1; i <= k; i++) {
            ans = ans * i;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("210324488 ?= " + countAnagrams("b okzojaporykbmq tybq zrztwlolvcyumcsq jjuowpp"));
        System.out.println("18 ?= " + countAnagrams("too hot"));
        System.out.println("1 ?= " + countAnagrams("aa"));
    }
}
