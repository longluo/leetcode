package com.longluo.contest.weekly_contest_324;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-324
 */

/**
 * https://leetcode.cn/problems/count-pairs-of-similar-strings/
 */
public class Problem2 {

    public static int smallestValue(int n) {
        if (isPrime(n)) {
            return n;
        }

        Set<Integer> seen = new HashSet<>();

        while (!seen.contains(n)) {
            int cur = n;
            int sum = 0;

            seen.add(cur);

            while (!isPrime(cur)) {
                for (int i = 2; i <= cur; i++) {
                    if (cur % i == 0) {
                        cur /= i;
                        sum += i;
                        break;
                    }
                }
            }

            sum += cur;
            n = sum;
        }

        return n;
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return n > 2;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + smallestValue(3));
        System.out.println("4 ?= " + smallestValue(4));
        System.out.println("5 ?= " + smallestValue(5));
        System.out.println("5 ?= " + smallestValue(15));
    }
}
