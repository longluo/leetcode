package com.longluo.leetcode.math;

/**
 * 1154. 一年中的第几天
 * <p>
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。
 * 每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * 示例 1：
 * 输入：date = "2019-01-09"
 * 输出：9
 * <p>
 * 示例 2：
 * 输入：date = "2019-02-10"
 * 输出：41
 * <p>
 * 示例 3：
 * 输入：date = "2003-03-01"
 * 输出：60
 * <p>
 * 示例 4：
 * 输入：date = "2004-03-01"
 * 输出：61
 * <p>
 * 提示：
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 * <p>
 * https://leetcode-cn.com/problems/day-of-the-year/
 */
public class Problem1154_dayOfYear {

    public static int dayOfYear(String date) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int ans = 0;
        boolean isLeapYear = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            isLeapYear = true;
        }
        for (int i = 0; i < month - 1; i++) {
            if (i == 1 && isLeapYear) {
                ans += 29;
            } else {
                ans += months[i];
            }
        }

        ans += day;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + dayOfYear("2019-01-09"));
        System.out.println("9 ?= " + dayOfYear("2019-11-29"));
        System.out.println("41 ?= " + dayOfYear("2019-02-10"));
        System.out.println("60 ?= " + dayOfYear("2003-03-01"));
        System.out.println("61 ?= " + dayOfYear("2004-03-01"));
    }
}
