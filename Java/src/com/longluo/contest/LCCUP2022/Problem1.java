package com.longluo.contest.LCCUP2022;

public class Problem1 {

    public static int minNumBooths(String[] demand) {
        if (demand == null || demand.length == 0) {
            return 0;
        }

        int len = demand.length;
        int[] count = new int[26];

        String first = demand[0];
        for (char ch : first.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 1; i < len; i++) {
            int[] sum = new int[26];
            String s = demand[i];
            for (char ch : s.toCharArray()) {
                sum[ch - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                if (count[j] >= sum[j]) {
                    continue;
                }

                count[j] = sum[j];
            }
        }

        int ans = 0;
        for (int x : count) {
            ans += x;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + minNumBooths(new String[]{"acd", "bed", "accd"}));
    }
}
