package com.longluo.contest.biweekly_contest_95;

/**
 * https://leetcode.cn/contest/biweekly-contest-95
 */
public class Problem3 {

    public static int xorBeauty(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int cur = 0x01 << i;

            int cnt = 0;

            for (int x : nums) {
                if ((x & cur) > 0) {
                    cnt++;
                }
            }

            if (cnt % 2 != 0) {
                ans += cur;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + xorBeauty(new int[]{1, 4}));
        System.out.println("34 ?= " + xorBeauty(new int[]{15, 45, 20, 2, 34, 35, 5, 44, 32, 30}));
    }
}
