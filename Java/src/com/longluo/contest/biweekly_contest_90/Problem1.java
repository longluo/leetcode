package com.longluo.contest.biweekly_contest_90;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-90/
 */


/**
 * https://leetcode.cn/problems/odd-string-difference/
 */
public class Problem1 {

    // HashMap time: O(nk) space: O(n)
    public static String oddString(String[] words) {
        int len = words.length;

        int n = words[0].length();

        int ans = -1;

        for (int i = 0; i < n - 1; i++) {
            Map<Integer, int[]> map = new HashMap<>();

            for (int j = 0; j < len; j++) {
                String word = words[j];
                int diff = word.charAt(i + 1) - word.charAt(i);
                map.putIfAbsent(diff, new int[]{0, -1});
                int[] x = map.get(diff);
                x[0]++;
                x[1] = j;
                map.put(diff, x);
            }

            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                int[] value = entry.getValue();
                if (value[0] == 1) {
                    ans = value[1];
                    return words[ans];
                }
            }
        }

        return words[ans];
    }

    public static void main(String[] args) {
        System.out.println("abc ?= " + oddString(new String[]{"adc", "wzy", "abc"}));
    }
}
