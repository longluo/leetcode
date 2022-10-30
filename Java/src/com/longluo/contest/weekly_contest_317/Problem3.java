package com.longluo.contest.weekly_contest_317;

/**
 * https://leetcode.cn/problems/minimum-addition-to-make-integer-beautiful/
 */
public class Problem3 {

    // TLE
    public static long makeIntegerBeautiful_bf(long n, int target) {
        String s = String.valueOf(n);
        if (check(s, target)) {
            return 0;
        }

        long ans = 1;
        while (ans > 0) {
            long next = n + ans;
            String nextStr = String.valueOf(next);
            if (check(nextStr, target)) {
                break;
            }

            ans++;
        }

        return ans;
    }

    private static boolean check(String s, int target) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            cnt += ch - '0';
        }

        return cnt <= target;
    }

    public static long makeIntegerBeautiful_opt(long n, int target) {
        String s = String.valueOf(n);

        int len = s.length();

        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        int sum = 0;
        for (int x : digits) {
            sum += x;
        }

        if (sum <= target) {
            return 0;
        }

        long ans = 0;

        long base = 1;
        for (int i = len - 1; i >= 0; i--) {
            sum -= digits[i];

            ans += base * (10 - digits[i]);
            digits[i] = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (j == 0 && digits[j] == 9) {
                    sum++;
                    return ans;
                } else if (digits[j] < 9) {
                    digits[j]++;
                    sum++;
                    break;
                } else {
                    digits[j] = 0;
                    sum -= 9;
                }
            }

            if (sum <= target) {
                return ans;
            }

            base = base * 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + makeIntegerBeautiful_bf(16, 6));

        System.out.println("4 ?= " + makeIntegerBeautiful_opt(16, 6));
        System.out.println("22 ?= " + makeIntegerBeautiful_opt(30978, 6));
        System.out.println("33 ?= " + makeIntegerBeautiful_opt(467, 6));
        System.out.println("33 ?= " + makeIntegerBeautiful_opt(1992, 5));
        System.out.println("2 ?= " + makeIntegerBeautiful_opt(9998, 5));
    }
}
