package com.longluo.leetcode.math;

/**
 * 1185. 一周中的第几天
 * <p>
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 * <p>
 * 示例 1：
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * <p>
 * 示例 2：
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * <p>
 * 示例 3：
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 * <p>
 * 提示：
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 * <p>
 * https://leetcode-cn.com/problems/day-of-the-week/
 */
public class Problem1185_dayOfTheWeek {

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        return weekDays[week];
    }

    public static void main(String[] args) {

    }
}
