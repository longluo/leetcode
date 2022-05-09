package com.longluo.contest.weekly_contest_292;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3 {

    public static int countTexts(String pressedKeys) {
        int[] cnt = {3, 3, 3, 3, 3, 4, 3, 4};
        int MOD = 1_000_000_000;
        int len = pressedKeys.length();

        List<int[]> list = new ArrayList<>();
        int idx = 1;
        int count = 1;
        int num = pressedKeys.charAt(0) - '0';
        while (idx < len) {
            while (idx < len && (pressedKeys.charAt(idx) - '0') == num) {
                idx++;
                count++;
            }

            list.add(new int[]{num, count});
            if (idx < len) {
                num = pressedKeys.charAt(idx) - '0';
                count = 0;
            }
        }

        int size = list.size();
        int[] dp = new int[size];
        dp[0] = getCount(list.get(0)[0], list.get(0)[1], cnt) % MOD;
        for (int i = 1; i < size; i++) {
            int cur = getCount(list.get(i)[0], list.get(i)[1], cnt) % MOD;
            dp[i] = (dp[i - 1] * cur) % MOD;
        }

        return dp[size - 1];
    }

    public static int getCount(int digit, int len, int[] count) {
        if (len <= 2) {
            return len;
        }

        int MOD = 1_000_000_000;
        int maxCnt = count[digit - 2];
        int[] dp = new int[len + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= len; i++) {
            if (maxCnt > 3) {
                dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD + dp[i - 3] % MOD + dp[i - 4] % MOD;
            } else {
                dp[i] = dp[i - 1] % MOD + dp[i - 2] % MOD + dp[i - 3] % MOD;
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(countTexts("22233"));
        System.out.println(countTexts("222222222222222222222222222222222222"));
    }
}
