package com.longluo.contest.weekly_contest_319;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-319
 */

/**
 * https://leetcode.cn/problems/convert-the-temperature/
 */
public class Problem1 {

    public static double[] convertTemperature(double celsius) {
        double[] ans = new double[2];

        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.80 + 32.00;

        return ans;
    }

    public static double[] convertTemperature_opt(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }

    public static void main(String[] args) {
        System.out.println("[309.65000,97.70000] ?= " + Arrays.toString(convertTemperature(36.50)));
        System.out.println("[309.65000,97.70000] ?= " + Arrays.toString(convertTemperature_opt(36.50)));
    }
}
