package com.longluo.contest.weekly_contest_352;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-352
 */
public class Problem2 {

    public static List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 2; i <= n - 2; i++) {
            if (!set.contains(i) && !set.contains(n - i) && isPrime(i) && isPrime(n - i)) {
                set.add(i);
                set.add(n - i);

                List<Integer> item = new ArrayList<>();
                item.add(i);
                item.add(n - i);
                ans.add(item);
            }
        }

        return ans;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("[] ?= " + findPrimePairs(2));
        System.out.println("[[3, 7], [5, 5]] ?= " + findPrimePairs(10));
    }
}
