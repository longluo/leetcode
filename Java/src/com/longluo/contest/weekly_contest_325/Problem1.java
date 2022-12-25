package com.longluo.contest.weekly_contest_325;

/**
 * https://leetcode.cn/contest/weekly-contest-325
 */

public class Problem1 {

    public static int closetTarget(String[] words, String target, int startIndex) {
        int len = words.length;

        int ans = -1;

        for (int i = 0; i < len; i++) {
            int left = (startIndex - i + len) % len;
            int right = (startIndex + i) % len;

            if (words[left].equals(target) || words[right].equals(target)) {
                if (ans == -1) {
                    ans = i;
                } else {
                    ans = Math.min(ans, i);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + closetTarget(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1));
    }
}
