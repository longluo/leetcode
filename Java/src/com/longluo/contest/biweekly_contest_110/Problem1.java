package com.longluo.contest.biweekly_contest_110;

/**
 * https://leetcode.cn/contest/biweekly-contest-110
 */
public class Problem1 {

    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        int shiwei = purchaseAmount / 10;
        int gewei = purchaseAmount % 10;

        if (gewei >= 5) {
            shiwei++;
        }

        return 100 - 10 * shiwei;
    }

    public static void main(String[] args) {
        System.out.println("90 ?= " + accountBalanceAfterPurchase(9));
        System.out.println("80 ?= " + accountBalanceAfterPurchase(15));
    }
}
