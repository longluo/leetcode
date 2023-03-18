package com.longluo.contest.biweekly_contest_100;

/**
 * https://leetcode.cn/contest/biweekly-contest-100
 */
public class Problem1 {

    public static int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }

        if (money < children + 7) {
            return 0;
        } else if (money == (8 * (children - 1) + 4)) {
            return children - 2;
        } else if (money == 8 * children) {
            return children;
        } else if (money > children * 8) {
            return children - 1;
        }

        return (money - children) / 7;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + distMoney(9, 2));
        System.out.println("1 ?= " + distMoney(16, 3));
        System.out.println("1 ?= " + distMoney(17, 2));
        System.out.println("1 ?= " + distMoney(23, 2));
        System.out.println("1 ?= " + distMoney(20, 3));
        System.out.println("2 ?= " + distMoney(16, 2));
    }
}
