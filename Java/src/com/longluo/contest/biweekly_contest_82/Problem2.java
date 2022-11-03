package com.longluo.contest.biweekly_contest_82;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/the-latest-time-to-catch-a-bus/
 */
public class Problem2 {

    // TODO: 2022/11/3
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int n = buses.length;
        int m = passengers.length;

        Arrays.sort(buses);
        Arrays.sort(passengers);


        return 0;
    }

    public static void main(String[] args) {
        System.out.println("16 ?= " + latestTimeCatchTheBus(new int[]{10, 20}, new int[]{2, 17, 18, 19}, 2));
        System.out.println("20 ?= " + latestTimeCatchTheBus(new int[]{20, 30, 10}, new int[]{19, 13, 26, 4, 25, 11, 21}, 2));
    }
}
