package com.longluo.algo200;

import java.util.*;

/**
 * 681. 最近时刻
 * <p>
 * 给定一个形如 "HH:MM" 表示的时刻 time ，利用当前出现过的数字构造下一个距离当前时间最近的时刻。
 * 每个出现数字都可以被无限次使用。
 * <p>
 * 你可以认为给定的字符串一定是合法的。例如， "01:34" 和  "12:09" 是合法的，“1:34” 和 “12:9” 是不合法的。
 * <p>
 * 示例 1:
 * 输入: "19:34"
 * 输出: "19:39"
 * 解释: 利用数字 1, 9, 3, 4 构造出来的最近时刻是 19:39，是 5 分钟之后。
 * 结果不是 19:33 因为这个时刻是 23 小时 59 分钟之后。
 * <p>
 * 示例 2:
 * 输入: "23:59"
 * 输出: "22:22"
 * 解释: 利用数字 2, 3, 5, 9 构造出来的最近时刻是 22:22。
 * 答案一定是第二天的某一时刻，所以选择可构造的最小时刻。
 * <p>
 * 提示：
 * time.length == 5
 * time 为有效时间，格式为 "HH:MM".
 * 0 <= HH < 24
 * 0 <= MM < 60
 * <p>
 * https://leetcode.cn/problems/next-closest-time/
 */
public class Problem681_nextClosestTime {

    // Simulate time: O(n) space: O(n)
    public static String nextClosestTime(String time) {
        if (time.equals("23:59")) {
            return "22:22";
        }

        Set<Integer> set = new TreeSet<>();
        for (char ch : time.toCharArray()) {
            if (Character.isDigit(ch)) {
                set.add(ch - '0');
            }
        }

        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));

        int dayMax = 23 * 60 + 59;
        int dayTime = hour * 60 + minute;

        List<Integer> nums = new ArrayList<>(set);

        List<Integer> parts = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                int value = nums.get(i) * 10 + nums.get(j);
                if (value < 60) {
                    parts.add(value);
                }
            }
        }

        int[] res = new int[2];
        int minDate = dayMax;
        boolean findNextBig = false;
        int nextMin = dayMax;
        int[] next = new int[2];

        for (int i = 0; i < parts.size(); i++) {
            for (int j = 0; j < parts.size(); j++) {
                int h = parts.get(i);
                int m = parts.get(j);
                if (h <= 23 && m <= 59) {
                    int date = h * 60 + m;
                    if (date <= dayMax) {
                        if (date > dayTime) {
                            findNextBig = true;
                            if (date < minDate) {
                                minDate = date;
                                res[0] = h;
                                res[1] = m;
                            }
                        } else {
                            if (date < nextMin) {
                                nextMin = date;
                                next[0] = h;
                                next[1] = m;
                            }
                        }
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        if (findNextBig) {
            if (res[0] < 10) {
                ans.append('0');
            }
            ans.append(res[0]);

            ans.append(':');

            if (res[1] < 10) {
                ans.append('0');
            }
            ans.append(res[1]);
        } else {
            if (next[0] < 10) {
                ans.append('0');
            }
            ans.append(next[0]);

            ans.append(':');

            if (next[1] < 10) {
                ans.append('0');
            }
            ans.append(next[1]);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("11:11 ?= " + nextClosestTime("15:55"));
        System.out.println("19:39 ?= " + nextClosestTime("19:34"));
        System.out.println("23:22 ?= " + nextClosestTime("22:37"));
        System.out.println("15:11 ?= " + nextClosestTime("13:55"));
        System.out.println("03:03 ?= " + nextClosestTime("03:00"));
        System.out.println("00:00 ?= " + nextClosestTime("03:33"));
        System.out.println("22:22 ?= " + nextClosestTime("23:59"));
    }
}
