package com.longluo.contest.weekly_contest_310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {

    public static int partitionString(String s) {
        int len = s.length();

        int[] count = new int[26];

        int ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (count[ch - 'a'] >= 1) {
                Arrays.fill(count, 0);
                count[ch - 'a']++;
                ans++;
            } else {
                count[ch - 'a']++;
            }
        }

        return ans + 1;
    }

    public static int partitionString_map(String s) {
        int len = s.length();

        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.getOrDefault(ch, 0) >= 1) {
                map.clear();
                ans++;
            }

            map.put(ch, 1);
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + partitionString("abacaba"));
        System.out.println("6 ?= " + partitionString("ssssss"));
        System.out.println("4 ?= " + partitionString("hdklqkcssgxlvehva"));
        System.out.println("4 ?= " + partitionString_map("hdklqkcssgxlvehva"));
    }
}
