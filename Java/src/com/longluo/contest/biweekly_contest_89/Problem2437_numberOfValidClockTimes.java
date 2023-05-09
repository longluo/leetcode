package com.longluo.contest.biweekly_contest_89;

/**
 * https://leetcode.cn/contest/biweekly-contest-89/
 */

/**
 * 2437. 有效时间的数目
 * <p>
 * 给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。
 * 最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
 * <p>
 * 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
 * <p>
 * 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
 * <p>
 * 示例 1：
 * 输入：time = "?5:00"
 * 输出：2
 * 解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所以我们有两个选择。
 * <p>
 * 示例 2：
 * 输入：time = "0?:0?"
 * 输出：100
 * 解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
 * <p>
 * 示例 3：
 * 输入：time = "??:??"
 * 输出：1440
 * 解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
 * <p>
 * 提示：
 * time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。
 * "00" <= hh <= "23"
 * "00" <= mm <= "59"
 * 字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。
 * <p>
 * https://leetcode.cn/problems/number-of-valid-clock-times/
 */
public class Problem2437_numberOfValidClockTimes {

    // Simulate
    public static int countTime(String time) {
        String hour = time.substring(0, 2);
        String minute = time.substring(3);

        int cnt = 1;

        if (hour.charAt(0) == '?' && (hour.charAt(1) >= '0' && hour.charAt(1) <= '3')) {
            cnt *= 3;
        } else if (hour.charAt(0) == '?' && hour.charAt(1) != '?') {
            cnt *= 2;
        } else if (hour.charAt(0) == '?' && hour.charAt(1) == '?') {
            cnt *= 24;
        } else if ((hour.charAt(0) == '0' || hour.charAt(0) == '1') && hour.charAt(1) == '?') {
            cnt *= 10;
        } else if (hour.charAt(0) == '2' && hour.charAt(1) == '?') {
            cnt *= 4;
        }

        if (minute.charAt(0) == '?' && minute.charAt(1) == '?') {
            cnt *= 60;
        } else if (minute.charAt(0) == '?' && minute.charAt(1) == '0') {
            cnt *= 6;
        } else if (minute.charAt(0) == '?' && minute.charAt(1) != '?') {
            cnt *= 6;
        } else if ((minute.charAt(0) >= '0' && minute.charAt(0) <= '5') && minute.charAt(1) == '?') {
            cnt *= 10;
        }

        return cnt;
    }

    public static int countTime_opt(String time) {
        char[] array = time.toCharArray();

        int ans = 1;

        if (array[0] == '?') {
            if (array[1] >= '0' && array[1] <= '3') {
                ans *= 3;
            } else if (array[1] == '?') {
                ans *= 24;
            } else {
                ans *= 2;
            }
        } else if (array[0] == '0' || array[0] == '1') {
            if (array[1] == '?') {
                ans *= 10;
            }
        } else if (array[0] == '2') {
            if (array[1] == '?') {
                ans *= 4;
            }
        }

        if (array[3] == '?') {
            if (array[4] == '?') {
                ans *= 60;
            } else {
                ans *= 6;
            }
        } else if (array[3] >= '0' && array[3] <= '5') {
            if (array[4] == '?') {
                ans *= 10;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countTime("?5:00"));
        System.out.println("1 ?= " + countTime("21:09"));
        System.out.println("12 ?= " + countTime("?9:?0"));

        System.out.println("2 ?= " + countTime_opt("?5:00"));
        System.out.println("1 ?= " + countTime_opt("21:09"));
        System.out.println("12 ?= " + countTime_opt("?9:?0"));
    }
}
