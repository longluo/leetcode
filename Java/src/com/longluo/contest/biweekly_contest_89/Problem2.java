package com.longluo.contest.biweekly_contest_89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {

    public static int[] productQueries(int n, int[][] queries) {
        int mod = 1_000_000_007;

        List<Integer> powersList = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) > 0) {
                powersList.add((1 << i));
            }
        }

        int len = queries.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            long res = 1;
            for (int j = left; j <= right; j++) {
                res = res * powersList.get(j);
                res %= mod;
            }

            ans[i] = (int) res;
        }

        return ans;
    }

    public static int[] productQueries_opt(int n, int[][] queries) {
        int MOD = 1_000_000_007;

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i <= 31; i++) {
            if ((n & (1 << i)) != 0) {
                nums.add((1 << i));
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            long product = 1;
            for (int j = left; j <= right; j++) {
                product = (product * nums.get(j)) % MOD;
            }

            res[i] = (int) product;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[2, 4, 64] ?= " + Arrays.toString(productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}})));
        System.out.println("[2, 4, 64] ?= " + Arrays.toString(productQueries_opt(15, new int[][]{{0, 1}, {2, 2}, {0, 3}})));
    }
}
