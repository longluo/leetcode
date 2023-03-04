package com.longluo.contest.biweekly_contest_99;

/**
 * https://leetcode.cn/contest/biweekly-contest-99
 */
public class Problem2 {

    public static long coloredCells(int n) {
        if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 5;
        }

        long side = n * 2 - 1;
        long product = side * side;

        long coner = 2L * n * (n - 1);

        return product - coner;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + coloredCells(1));
        System.out.println("5 ?= " + coloredCells(2));
        System.out.println("13 ?= " + coloredCells(3));
        System.out.println("25 ?= " + coloredCells(4));
    }
}
