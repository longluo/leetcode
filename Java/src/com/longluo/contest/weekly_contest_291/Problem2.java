package com.longluo.contest.weekly_contest_291;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

    public static int minimumCardPickup(int[] cards) {
        int len = cards.length;

        Map<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(cards[i])) {
                int prev = map.get(cards[i]);
                ans = Math.min(ans, i - prev + 1);
            }

            map.put(cards[i], i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println("-1 ?= " + minimumCardPickup(new int[]{1, 0, 5, 3}));
    }
}
