package com.longluo.contest.weekly_contest_313;

public class Problem3 {

    public static int minimizeXor(int num1, int num2) {
        int num1bits = Integer.bitCount(num1);
        int num2bits = Integer.bitCount(num2);

        if (num1bits == num2bits) {
            return num1;
        }

        int ans = 0;
        int cnt = 0;

        if (num1bits < num2bits) {
            int diff = num2bits - num1bits;
            while (num1 != 0 && diff > 0) {
                if ((num1 & 0x01) == 0) {
                    diff--;
                }
                ans |= (1 << cnt);
                num1 = num1 >> 1;
                cnt++;
            }
        } else {
            int diff = num1bits - num2bits;
            while (num1 != 0 && diff > 0) {
                if ((num1 & 0x01) == 1) {
                    diff--;
                }
                ans |= 1 << cnt;
                num1 >>= 1;
                cnt++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minimizeXor(3, 5));
        System.out.println("3 ?= " + minimizeXor(1, 12));
    }
}
