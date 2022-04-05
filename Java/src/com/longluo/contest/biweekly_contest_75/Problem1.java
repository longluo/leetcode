package com.longluo.contest.biweekly_contest_75;

public class Problem1 {

    public static int minBitFlips(int start, int goal) {
        if (start == goal) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (start & 0x01) ^ (goal & 0x01);
            start = start >>> 1;
            goal = goal >>> 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
    }
}
