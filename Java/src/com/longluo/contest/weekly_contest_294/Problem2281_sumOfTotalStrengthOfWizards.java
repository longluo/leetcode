package com.longluo.contest.weekly_contest_294;

/**
 *
 */
public class Problem2281_sumOfTotalStrengthOfWizards {

    // BF time: O(n^3) space: O(n)
    public static int totalStrength_bf(int[] strength) {
        int MOD = 1_000_000_007;
        int ans = 0;
        int len = strength.length;
        long[] sums = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + strength[i];
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int min = strength[i];
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, strength[k]);
                }

                long power = (long) min * (sums[j + 1] - sums[i]) % MOD;
                ans = (int) (((long) ans + power) % MOD);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("213 ?= " + totalStrength_bf(new int[]{5, 4, 6}));
        System.out.println("44 ?= " + totalStrength_bf(new int[]{1, 3, 1, 2}));
    }
}
