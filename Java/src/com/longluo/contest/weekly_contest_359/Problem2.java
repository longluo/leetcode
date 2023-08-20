package com.longluo.contest.weekly_contest_359;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-359
 */
public class Problem2 {

    public static int minimumSum(int n, int k) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 1; seen.size() < n; i++) {
            boolean flag = true;

            for (int x : seen) {
                if (k - i == x) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                seen.add(i);
            }
        }

        int sum = 0;
        for (int x : seen) {
            sum += x;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("18 ?= " + minimumSum(5, 4));
        System.out.println("3 ?= " + minimumSum(2, 6));
    }
}
