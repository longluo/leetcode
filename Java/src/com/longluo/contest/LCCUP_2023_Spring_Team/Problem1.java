package com.longluo.contest.LCCUP_2023_Spring_Team;


import java.util.Arrays;

public class Problem1 {

    public static int runeReserve(int[] runes) {
        int n = runes.length;

        Arrays.sort(runes);

        int ans = 1;

        for (int i = 0; i < n; i++) {
            int cur = runes[i];

            int cnt = 1;

            for (int j = i - 1; j >= 0; j--) {
                int diff = Math.abs(runes[j] - runes[j + 1]);
                if (diff > 1) {
                    break;
                }

                cnt++;
            }

            for (int j = i + 1; j < runes.length; j++) {
                int diff = Math.abs(runes[j] - runes[j - 1]);
                if (diff > 1) {
                    break;
                }

                cnt++;
            }

            ans = Math.max(ans, cnt);
            if (ans == n) {
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + runeReserve(new int[]{1, 3, 5, 4, 1, 7}));
        System.out.println("6 ?= " + runeReserve(new int[]{1, 1, 3, 3, 2, 4}));
    }
}
