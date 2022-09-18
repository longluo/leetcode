package com.longluo.contest.weekly_contest_311;

import java.util.Arrays;

public class Problem2 {

    public static int longestContinuousSubstring(String s) {
        int len = s.length();

        int max = 1;
        for (int i = 0; i < len; i++) {
            int cnt = 1;
            char lastCh = s.charAt(i);
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) != lastCh + 1) {
                    break;
                }

                lastCh = s.charAt(j);
                cnt++;
            }

            max = Math.max(max, cnt);
        }

        return max;
    }

    public static int longestContinuousSubstring_dp(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);

        int ans = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                dp[i] = dp[i - 1] + 1;
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + longestContinuousSubstring("abacaba"));
        System.out.println("5 ?= " + longestContinuousSubstring("abcde"));
        System.out.println("5 ?= " + longestContinuousSubstring_dp("abcde"));
    }
}
