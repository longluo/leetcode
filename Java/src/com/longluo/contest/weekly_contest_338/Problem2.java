package com.longluo.contest.weekly_contest_338;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.cn/contest/weekly-contest-338
 */

/**
 * https://leetcode.cn/problems/rearrange-array-to-maximize-prefix-score/
 */
public class Problem2 {

    public static boolean primeSubOperation(int[] nums) {
        int n = nums.length;

        HashSet<Integer> primes = new HashSet<>();

        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        int prev = nums[0];

        for (int i = nums[0] - 1; i >= 2; i--) {
            if (primes.contains(i)) {
                prev = nums[0] - i;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            int cur = nums[i];

            for (int j = cur - 1; j >= 2; j--) {
                if (primes.contains(j) && cur - j > prev) {
                    cur -= j;
                    break;
                }
            }

            if (cur > prev) {
                prev = cur;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean primeSubOperation_opt(int[] nums) {
        int n = nums.length;

        int max = Arrays.stream(nums).max().getAsInt();

        HashSet<Integer> primeSet = new HashSet<>();

        for (int i = 2; i < max; i++) {
            if (isPrime(i)) {
                primeSet.add(i);
            }
        }

        int prevNum = nums[0];

        for (int i = nums[0] - 1; i >= 2; i--) {
            if (primeSet.contains(i)) {
                prevNum = nums[0] - i;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            int curNum = nums[i];

            for (int j = curNum - 1; j >= 2; j--) {
                if (primeSet.contains(j) && curNum - j > prevNum) {
                    curNum -= j;
                    break;
                }
            }

            if (curNum > prevNum) {
                prevNum = curNum;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return n >= 2;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + primeSubOperation(new int[]{5, 8, 3}));
        System.out.println("true ?= " + primeSubOperation(new int[]{6, 8, 11, 12}));
        System.out.println("true ?= " + primeSubOperation(new int[]{4, 9, 6, 10}));
    }
}
