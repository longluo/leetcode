package com.longluo.contest.biweekly_contest_92;

/**
 * https://leetcode.cn/contest/biweekly-contest-92
 */

public class Problem1 {

    public static int numberOfCuts(int n) {
        if (n <= 1) {
            return 0;
        }

        if (n % 2 == 1) {
            return n;
        }

        return n / 2;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + numberOfCuts(1));
        System.out.println("1 ?= " + numberOfCuts(2));
        System.out.println("3 ?= " + numberOfCuts(3));
        System.out.println("2 ?= " + numberOfCuts(4));
        System.out.println("3 ?= " + numberOfCuts(6));
        System.out.println("4 ?= " + numberOfCuts(8));
        System.out.println("4 ?= " + numberOfCuts(12));
    }
}
