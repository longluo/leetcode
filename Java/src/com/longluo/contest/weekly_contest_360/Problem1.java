package com.longluo.contest.weekly_contest_360;

/**
 * https://leetcode.cn/contest/weekly-contest-360
 */
public class Problem1 {

    public static int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();

        int leftCnt = 0;
        int rightCnt = 0;

        for (int i = 0; i < n; i++) {
            char ch = moves.charAt(i);
            if (ch == 'L') {
                leftCnt++;
            } else if (ch == 'R') {
                rightCnt++;
            }
        }

        if (leftCnt == rightCnt) {
            return n - leftCnt - rightCnt;
        } else if (leftCnt > rightCnt) {
            return n - 2 * rightCnt;
        } else {
            return n - 2 * leftCnt;
        }
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + furthestDistanceFromOrigin("L_RL__R"));
        System.out.println("5 ?= " + furthestDistanceFromOrigin("_R__LL_"));
        System.out.println("7 ?= " + furthestDistanceFromOrigin("_______"));
    }
}
