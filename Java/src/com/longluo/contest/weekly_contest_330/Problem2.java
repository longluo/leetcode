package com.longluo.contest.weekly_contest_330;

/**
 * https://leetcode.cn/contest/weekly-contest-330
 */
public class Problem2 {

    // Math time: O(n) space: O(1)
    // TLE
    public static int monkeyMove(int n) {
        int mod = 1_000_000_007;

        long sum = 1;

        for (int i = 0; i < n; i++) {
            sum *= 2;

            if (sum - 1 > mod) {
                sum %= mod;
            }
        }

        return (int) (sum - 2);
    }

    // Quick Power time: O(logn) space: O(1)
    // TLE
    public static int monkeyMove_quick(int n) {
        int mod = 1_000_000_007;

        int ans = (int) quickPower(2, n);

        if (ans == 1) {
            ans += mod;
        }

        return ans - 2;
    }

    private static long quickPower(int base, int power) {
        if (power <= 1) {
            return base;
        }

        int mod = 1_000_000_007;

        if (power % 2 == 1) {
            return base * quickPower(base, power / 2) * quickPower(base, power / 2) % mod;
        } else {
            return quickPower(base, power / 2) * quickPower(base, power / 2) % mod;
        }
    }

    // AC
    private static long quickPower_opt(int base, int power) {
        if (power <= 1) {
            return base;
        }

        int mod = 1_000_000_007;

        long ret = quickPower(base, power / 2);
        ret %= mod;

        if (power % 2 == 1) {
            return base * ret * ret % mod;
        } else {
            return ret * ret % mod;
        }
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + monkeyMove(3));
        System.out.println("14 ?= " + monkeyMove(4));
        System.out.println("1000000006 ?= " + monkeyMove(500000003));

        System.out.println("1000000006 ?= " + monkeyMove_quick(500000003));
    }
}
