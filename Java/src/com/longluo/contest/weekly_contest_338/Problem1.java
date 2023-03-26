package com.longluo.contest.weekly_contest_338;

/**
 * https://leetcode.cn/contest/weekly-contest-338
 */
public class Problem1 {

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = 0;

        if (k <= numOnes) {
            return k;
        }

        ans += numOnes;
        k -= numOnes;

        if (k <= numZeros) {
            return ans;
        }

        k -= numZeros;

        if (k <= numNegOnes) {
            return ans - k;
        }

        return ans - numNegOnes;
    }

    public static int kItemsWithMaximumSum_opt(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = Math.min(numOnes, k);
        k -= numOnes;
        k -= numZeros;

        if (k <= 0) {
            return ans;
        }

        return ans - Math.min(k, numNegOnes);
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + kItemsWithMaximumSum(3, 2, 0, 2));
        System.out.println("3 ?= " + kItemsWithMaximumSum(3, 2, 0, 4));
        System.out.println("3 ?= " + kItemsWithMaximumSum_opt(3, 2, 0, 4));
    }
}
