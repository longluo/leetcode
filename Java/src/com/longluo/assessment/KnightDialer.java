package com.longluo.assessment;

import java.util.*;

/**
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
 * or two squares horizontally and one square vertically (with both forming the shape of an L).
 * The possible movements of chess knight are shown in this diagaram:
 * A chess knight can move as indicated in the chess diagram below:
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 * You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n.
 * All jumps should be valid knight jumps.
 * <p>
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * Input: n = 1
 * Output: 10
 * Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
 * <p>
 * Example 2:
 * Input: n = 2
 * Output: 20
 * Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
 * <p>
 * Example 3:
 * Input: n = 3131
 * Output: 136006598
 * Explanation: Please take care of the mod.
 * <p>
 * Constraints:
 * 1 <= n <= 5000
 */
public class KnightDialer {

    public static int knightDialer(int n) {
        if (n == 1) {
            return 10;
        } else if (n == 2) {
            return 20;
        }

        final int MOD = 1000000007;
        int res = 0;
        int[][] dp = new int[n][10];
        List<List<Integer>> path = new ArrayList<>();
        path.add(Arrays.asList(4, 6));
        path.add(Arrays.asList(6, 8));
        path.add(Arrays.asList(7, 9));
        path.add(Arrays.asList(4, 8));
        path.add(Arrays.asList(3, 9, 0));
        path.add(new ArrayList<>());
        path.add(Arrays.asList(1, 7, 0));
        path.add(Arrays.asList(2, 6));
        path.add(Arrays.asList(1, 9));
        path.add(Arrays.asList(4, 2));

        for (int i = 0; i < n; i++) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int idx : path.get(j)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][idx]) % MOD;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            res = (res + dp[n - 1][i]) % MOD;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("10 ?= " + knightDialer(1));
        System.out.println("20 ?= " + knightDialer(2));
        System.out.println("136006598 ?= " + knightDialer(3131));
    }
}
