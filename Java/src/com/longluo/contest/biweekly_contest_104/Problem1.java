package com.longluo.contest.biweekly_contest_104;

/**
 * https://leetcode.cn/contest/biweekly-contest-104
 */
public class Problem1 {

    public static int countSeniors(String[] details) {
        int ans = 0;

        for (String x : details) {
            if (Integer.parseInt(x.substring(11, 13)) > 60) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
        System.out.println("0 ?= " + countSeniors(new String[]{"1313579440F2036", "2921522980M5644"}));
    }
}
