package com.longluo.contest.weekly_contest_326;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-326
 */

/**
 * https://leetcode.cn/problems/distinct-prime-factors-of-product-of-array/
 */
public class Problem2 {

    // Math time: O(n*sqrt(x)) space: O(n)
    public static int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int x : nums) {
            for (int prime : getPrimeFactors(x)) {
                set.add(prime);
            }
        }

        return set.size();
    }

    private static List<Integer> getPrimeFactors(int num) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                ans.add(i);
                num /= i;
                while (num % i == 0) {
                    num /= i;
                }
            }
        }

        if (num > 1) {
            ans.add(num);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + distinctPrimeFactors(new int[]{2, 4, 8, 16}));
        System.out.println("4 ?= " + distinctPrimeFactors(new int[]{2, 4, 3, 7, 10, 6}));
    }
}
