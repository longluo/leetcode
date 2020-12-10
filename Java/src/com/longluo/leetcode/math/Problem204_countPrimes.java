package com.longluo.leetcode.math;

import java.util.Arrays;

/*
204. 计数质数
统计所有小于非负整数n的质数的数量。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7。

示例 2：
输入：n = 0
输出：0

示例 3：
输入：n = 1
输出：0

提示：
0 <= n <= 5 * 10^6
 */
public class Problem204_countPrimes {

    public static int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        int count = 0;
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i - 1] == 0) {
                continue;
            }

            if (isPrimeNumber(i)) {
                count++;
            }

            for (int j = 2; j * i < n; j++) {
                isPrime[j * i - 1] = 0;
            }
        }

        return count;
    }

    private static boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println("false ?= " + isPrimeNumber(0));
//        System.out.println("false ?= " + isPrimeNumber(1));
//        System.out.println("true ?= " + isPrimeNumber(2));
//        System.out.println("true ?= " + isPrimeNumber(3));
//        System.out.println("false ?= " + isPrimeNumber(10));

        System.out.println("4 ?= " + countPrimes(10));
        System.out.println("0 ?= " + countPrimes(0));
        System.out.println("0 ?= " + countPrimes(1));

    }
}
