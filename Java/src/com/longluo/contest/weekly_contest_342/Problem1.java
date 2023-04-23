package com.longluo.contest.weekly_contest_342;

/**
 * https://leetcode.cn/contest/weekly-contest-342
 */
public class Problem1 {

    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int time = arrivalTime + delayedTime;
        return time % 24;
    }

    public static void main(String[] args) {

    }
}
