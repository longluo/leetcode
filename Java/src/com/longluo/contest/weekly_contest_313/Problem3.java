package com.longluo.contest.weekly_contest_313;

public class Problem3 {

    public static int minimizeXor(int num1, int num2) {
        int cnt1 = 0;
        int cnt2 = 0;

        int p1 = num1;
        int p2 = num2;

        for (int i = 0; i < 32 && p1 != 0; i++) {
            cnt1 += (p1 & 0x01) == 1 ? 1 : 0;
            p1 = p1 >> 1;
        }

        for (int i = 0; i < 32 && p2 != 0; i++) {
            cnt2 += (p2 & 0x01) == 1 ? 1 : 0;
            p2 = p2 >> 1;
        }

        int ans = num1;
        int diff = Math.abs(cnt1 - cnt2);
        int base = 1;

        if (cnt1 == cnt2) {
            return num1;
        } else if (cnt1 > cnt2) {
            while (diff > 0) {
                if ((num1 & 0x01) == 1) {
                    diff--;
                    ans -= base;
                }

                base *= 2;
                num1 = num1 >> 1;
            }
        } else {
            while (diff > 0) {
                if ((num1 & 0x01) == 0) {
                    diff--;
                    ans += base;
                }

                base *= 2;
                num1 = num1 >> 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minimizeXor(3, 5));
        System.out.println("3 ?= " + minimizeXor(1, 12));
    }
}
