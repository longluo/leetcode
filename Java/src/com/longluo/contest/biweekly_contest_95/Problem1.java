package com.longluo.contest.biweekly_contest_95;

/**
 * https://leetcode.cn/contest/biweekly-contest-95
 */

public class Problem1 {

    public static String categorizeBox(int length, int width, int height, int mass) {
        int Standard = 1_000_000_000;

        long volume = (long) length * width * height;

        boolean Bulky = volume >= Standard || length >= 10000 || width >= 10000 || height >= 10000;
        boolean Heavy = mass >= 100;

        if (Bulky && Heavy) {
            return "Both";
        } else if (Bulky) {
            return "Bulky";
        } else if (Heavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }

    public static void main(String[] args) {

    }
}
