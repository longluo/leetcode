package com.longluo.contest.biweekly_contest_75;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static long numberOfWays(String s) {
        int len = s.length();
        List<int[]> houses = new ArrayList<>();
        char lastCh = s.charAt(0);
        int idx = 0;
        int cnt = 0;
        while (idx < len) {
            while (idx < len && s.charAt(idx) == lastCh) {
                idx++;
                cnt++;
            }

            if (idx < len) {
                houses.add(new int[]{lastCh - '0', cnt});
                lastCh = s.charAt(idx);
                cnt = 0;
            } else {
                houses.add(new int[]{lastCh - '0', cnt});
            }
        }

        if (houses.size() < 3) {
            return 0;
        }

        int size = houses.size();
        int[] dp = new int[size];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = houses.get(0)[1] * houses.get(1)[1] * houses.get(2)[1];
        for (int i = 3; i < size; i++) {
            dp[i] = dp[i - 1] * houses.get(i)[1] + dp[i - 2] * houses.get(i)[1];
        }

        return dp[size - 1];
    }

    public static void back(List<int[]> res, StringBuilder sb, boolean[] seen, String str) {
        if (sb.toString() == str) {

        }

    }

    public static void main(String[] args) {
        numberOfWays("001101");
        numberOfWays("111000");
    }
}
