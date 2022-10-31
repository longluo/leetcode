package com.longluo.contest.biweekly_contest_85;

/**
 * https://leetcode.cn/contest/biweekly-contest-85/
 */

/**
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */
public class Problem1 {

    public static int minimumRecolors(String blocks, int k) {
        int len = blocks.length();

        int ans = k;

        for (int i = 0; i <= len - k; i++) {
            int cnt = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    cnt++;
                }
            }

            ans = Math.min(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minimumRecolors("WBBWWBBWBW", 7));
        System.out.println("0 ?= " + minimumRecolors("WBWBBBW", 2));
    }
}
