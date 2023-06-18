package com.longluo.contest.weekly_contest_350;

/**
 * https://leetcode.cn/contest/weekly-contest-350
 */
public class Problem1 {

    public static int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;

        while (mainTank > 0) {
            if (mainTank >= 5) {
                mainTank -= 5;
                ans += 50;
                if (additionalTank > 0) {
                    additionalTank--;
                    mainTank++;
                }
            } else {
                ans += mainTank * 10;
                mainTank = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("60 ?= " + distanceTraveled(5, 10));
        System.out.println("10 ?= " + distanceTraveled(1, 2));
        System.out.println("110 ?= " + distanceTraveled(9, 2));
    }
}
