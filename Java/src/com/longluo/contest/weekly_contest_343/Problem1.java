package com.longluo.contest.weekly_contest_343;

/**
 * https://leetcode.cn/contest/weekly-contest-343
 */
public class Problem1 {

    public static int isWinner(int[] player1, int[] player2) {
        int score1 = count(player1);
        int score2 = count(player2);

        if (score1 > score2) {
            return 1;
        } else if (score1 < score2) {
            return 2;
        }

        return 0;
    }

    private static int count(int[] player) {
        int ans = 0;

        for (int i = 0; i < player.length; i++) {
            if ((i >= 1 && player[i - 1] == 10) || (i >= 2 && (player[i - 1] == 10 || player[i - 2] == 10))) {
                ans += 2 * player[i];
            } else {
                ans += player[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + isWinner(new int[]{5, 6, 1, 10}, new int[]{5, 1, 10, 5}));
        System.out.println("1 ?= " + isWinner(new int[]{9, 7, 10, 7}, new int[]{10, 2, 4, 10}));
    }
}
