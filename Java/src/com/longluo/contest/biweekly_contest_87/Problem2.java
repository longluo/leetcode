package com.longluo.contest.biweekly_contest_87;

import java.util.Arrays;

public class Problem2 {

    //
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int p = players.length - 1;
        int t = trainers.length - 1;

        if (trainers[t] < players[0]) {
            return 0;
        }

        if (players[p] <= trainers[0]) {
            return Math.min(players.length, trainers.length);
        }

        int ans = 0;
        while (p >= 0 && t >= 0) {
            while (players[p] > trainers[t]) {
                p--;
            }

            if (players[p] <= trainers[t]) {
                ans++;
                p--;
                t--;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
    }
}
