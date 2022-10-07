package com.longluo.contest.LCCUP2022;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    public static int beautifulBouquet_bf(int[] flowers, int cnt) {
        int mod = 1_000_000_007;

        int len = flowers.length;

        int ans = len;

        for (int i = 0; i < len; i++) {
            for (int j = 2; j <= len && i + j <= len; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                boolean flag = true;
                for (int k = i; k < i + j && k < len; k++) {
                    int freq = map.getOrDefault(flowers[k], 0);
                    if (freq + 1 > cnt) {
                        flag = false;
                        break;
                    }

                    map.put(flowers[k], freq + 1);
                }

                if (flag) {
                    ans++;
                    ans = ans % mod;
                }
            }
        }

        return ans % mod;
    }

    public static int beautifulBouquet(int[] flowers, int cnt) {
        int mod = 1_000_000_007;

        int len = flowers.length;

        long ans = len;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while (left < right) {

        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + beautifulBouquet_bf(new int[]{1, 2, 3, 2}, 1));
    }
}
