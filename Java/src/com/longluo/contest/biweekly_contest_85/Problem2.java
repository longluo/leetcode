package com.longluo.contest.biweekly_contest_85;

/**
 * https://leetcode.cn/problems/time-needed-to-rearrange-a-binary-string/
 */
public class Problem2 {

    public static int secondsToRemoveOccurrences(String s) {
        if (!s.contains("01")) {
            return 0;
        }

        int len = s.length();

        char[] array = s.toCharArray();

        int ans = 0;

        while (true) {
            for (int i = 0; i < len; i++) {
                if (i + 1 < len && array[i] == '0' && array[i + 1] == '1') {
                    array[i] = '1';
                    array[i + 1] = '0';
                    i++;
                }
            }

            ans++;

            if (!check(array)) {
                break;
            }
        }

        return ans;
    }

    private static boolean check(char[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            if (i + 1 < len && array[i] == '0' && array[i + 1] == '1') {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + secondsToRemoveOccurrences("0110101"));
        System.out.println("0 ?= " + secondsToRemoveOccurrences("11100"));
    }
}
