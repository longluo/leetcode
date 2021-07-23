package com.longluo.leetcode.string;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * <p>
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <p>
 * 示例 1：
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * <p>
 * 示例 2：
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * <p>
 * 示例 3：
 * 输入：time = "1?:22"
 * 输出："19:22"
 * <p>
 * 提示：
 * time 的格式为 hh:mm
 * 题目数据保证你可以由输入的字符串生成有效的时间
 * <p>
 * https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/submissions/
 */
public class Problem1736_latestTimeByReplacingHiddenDigits {

    public static String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        if (time.charAt(0) != '?') {
            sb.append(time.charAt(0));
        } else {
            if (time.charAt(1) != '?' && time.charAt(1) > '3') {
                sb.append(1);
            } else {
                sb.append(2);
            }
        }
        if (time.charAt(1) != '?') {
            sb.append(time.charAt(1));
        } else {
            if (sb.charAt(0) == '2') {
                sb.append(3);
            } else {
                sb.append(9);
            }
        }
        sb.append(time.charAt(2));
        if (time.charAt(3) != '?') {
            sb.append(time.charAt(3));
        } else {
            sb.append(5);
        }
        if (time.charAt(4) != '?') {
            sb.append(time.charAt(4));
        } else {
            sb.append(9);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("23:50 ?= " + maximumTime("2?:?0"));
        System.out.println("09:39 ?= " + maximumTime("0?:3?"));
        System.out.println("19:22 ?= " + maximumTime("1?:22"));
        System.out.println("14:03 ?= " + maximumTime("?4:03"));
        System.out.println("23:39 ?= " + maximumTime("??:3?"));
    }
}
