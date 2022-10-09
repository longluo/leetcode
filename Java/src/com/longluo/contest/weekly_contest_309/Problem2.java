package com.longluo.contest.weekly_contest_309;

public class Problem2 {

    public static int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(startPos - endPos) > k) {
            return 0;
        }

        int[][] dp = new int[k][2];
        dp[0][0] = startPos;


        return dp[k - 1][1];
    }

    public static void main(String[] args) {

    }
}
