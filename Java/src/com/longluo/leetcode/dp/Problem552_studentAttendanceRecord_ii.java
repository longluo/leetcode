package com.longluo.leetcode.dp;

/**
 * 552. 学生出勤记录 II
 * <p>
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况数量。
 * 答案可能很大，所以返回对 10^9 + 7 取余 的结果。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：n = 10101
 * 输出：183236316
 * <p>
 * 提示：
 * 1 <= n <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class Problem552_studentAttendanceRecord_ii {

    private static int MOD = 1000000007;
    private static int count = 0;

    public static int checkRecord(int n) {
        count = 0;
        gen("", n);
        return count;
    }

    private static void gen(String str, int num) {
        if (num == 0 && check(str)) {
            count = (count + 1) % MOD;
            return;
        }

        if (num >= 1) {
            gen(str + "A", num - 1);
            gen(str + "P", num - 1);
            gen(str + "L", num - 1);
        }
    }

    private static boolean check(String str) {
        int absentCnt = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'A') {
                absentCnt++;
            }
        }

        return n > 0 && absentCnt < 2 && str.indexOf("LLL") < 0;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + checkRecord(1));
        System.out.println("8 ?= " + checkRecord(2));
        System.out.println("183236316 ?= " + checkRecord(10101));
    }
}
