package com.longluo.contest.biweekly_contest_94;

/**
 * https://leetcode.cn/contest/biweekly-contest-94
 */

public class Problem1 {

    public static int captureForts(int[] forts) {
        int ans = 0;

        int n = forts.length;

        for (int i = 0; i < n; i++) {
            if (forts[i] == 0 || forts[i] == -1) {
                continue;
            }

            int left = 0;
            boolean flag = false;

            for (int j = i - 1; j >= 0; j--) {
                if (forts[j] == 0) {
                    left++;
                } else if (forts[j] == 1) {
                    break;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                ans = Math.max(ans, left);
            }

            int right = 0;
            flag = false;
            for (int j = i + 1; j < n; j++) {
                if (forts[j] == 0) {
                    right++;
                } else if (forts[j] == 1) {
                    break;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                ans = Math.max(ans, right);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + captureForts(new int[]{0, 0, 1, -1}));
        System.out.println("4 ?= " + captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
    }
}
