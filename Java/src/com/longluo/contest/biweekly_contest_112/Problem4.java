package com.longluo.contest.biweekly_contest_112;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/biweekly-contest-112
 */
public class Problem4 {

    public static int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        Arrays.sort(cnt);

        int mod = 1_000_000_007;

        int kinds = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                kinds++;
            } else {
                break;
            }
        }

        if (kinds < k) {
            return 0;
        } else if (kinds == k) {
            return cnt[0] % mod;
        }

        long ans = 1;


        return (int) (ans % mod);
    }

    public static void main(String[] args) {

    }
}
