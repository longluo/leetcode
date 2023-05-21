package com.longluo.contest.weekly_contest_346;


/**
 * https://leetcode.cn/contest/weekly-contest-346
 */
public class Problem1 {

    public static int minLength(String s) {
        StringBuilder ans = new StringBuilder(s);

        while (ans.toString().contains("AB") || ans.toString().contains("CD")) {
            String res = ans.toString();

            int ab = res.indexOf("AB");
            int cd = res.indexOf("CD");

            if (ab >= 0) {
                ans.delete(ab, ab + 2);
            } else if (cd >= 0) {
                ans.delete(cd, cd + 2);
            }
        }

        return ans.length();
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minLength("ABFCACDB"));
        System.out.println("5 ?= " + minLength("ACBBD"));
    }
}
