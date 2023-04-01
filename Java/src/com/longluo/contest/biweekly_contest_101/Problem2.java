package com.longluo.contest.biweekly_contest_101;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/biweekly-contest-101
 */
public class Problem2 {

    // TLE
    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        int len = s.length();

        int n = chars.length();
        Map<Character, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueMap.put(chars.charAt(i), vals[i]);
        }

        int[] prefixSums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (valueMap.containsKey(ch)) {
                prefixSums[i + 1] = prefixSums[i] + valueMap.get(ch);
            } else {
                prefixSums[i + 1] = prefixSums[i] + (ch - 'a') + 1;
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                ans = Math.max(ans, prefixSums[j] - prefixSums[i]);
            }
        }

        return Math.max(ans, 0);
    }

    public static int maximumCostSubstring_win(String s, String chars, int[] vals) {
        int len = s.length();

        int n = chars.length();
        Map<Character, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueMap.put(chars.charAt(i), vals[i]);
        }

        int[] prefixSums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (valueMap.containsKey(ch)) {
                prefixSums[i + 1] = prefixSums[i] + valueMap.get(ch);
            } else {
                prefixSums[i + 1] = prefixSums[i] + (ch - 'a') + 1;
            }
        }

        int ans = 0;

        int cnt = 0;

        int left = 0;
        int right = 0;

        while (left <= right && right < len) {
            while (right < len && valueMap.getOrDefault(s.charAt(right), s.charAt(right) - 'a' + 1) > 0) {
                cnt += valueMap.getOrDefault(s.charAt(right), s.charAt(right) - 'a' + 1);
                right++;
            }

            if (valueMap.getOrDefault(s.charAt(left), s.charAt(left) - 'a' + 1) < 0) {
                ans -= valueMap.getOrDefault(s.charAt(left), s.charAt(left) - 'a' + 1);
                left++;
            }

            ans = Math.max(ans, cnt);
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maximumCostSubstring("adaa", "d", new int[]{-1000}));
        System.out.println("2 ?= " + maximumCostSubstring("abc", "abc", new int[]{-1, -1, -1}));

        System.out.println("2 ?= " + maximumCostSubstring_win("adaa", "d", new int[]{-1000}));
        System.out.println("2 ?= " + maximumCostSubstring_win("abc", "abc", new int[]{-1, -1, -1}));
    }
}
