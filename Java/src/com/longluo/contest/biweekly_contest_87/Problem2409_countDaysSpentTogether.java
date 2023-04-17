package com.longluo.contest.biweekly_contest_87;

/**
 * https://leetcode.cn/contest/biweekly-contest-87/
 */

/**
 * 2409. 统计共同度过的日子数
 * <p>
 * Alice 和 Bob 计划分别去罗马开会。
 * <p>
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。
 * Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），
 * 而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。
 * 每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 * <p>
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * <p>
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。
 * 每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
 * <p>
 * 示例 1：
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 16、17 和 18 号。所以答案为 3 。
 * <p>
 * 示例 2：
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
 * <p>
 * 提示：
 * 所有日期的格式均为 "MM-DD" 。
 * Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
 * 题目测试用例所给出的日期均为 非闰年 的有效日期。
 * <p>
 * https://leetcode.cn/problems/count-days-spent-together/
 */
public class Problem2409_countDaysSpentTogether {

    // Simulate time: O(1) space: O(1)
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceArriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int aliceArriveDay = Integer.parseInt(arriveAlice.substring(3, 5));

        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        int aliceLeaveDay = Integer.parseInt(leaveAlice.substring(3, 5));

        int bobArriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int bobArriveDay = Integer.parseInt(arriveBob.substring(3, 5));

        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
        int bobLeaveDay = Integer.parseInt(leaveBob.substring(3, 5));

        int aliceArriveDate = 0;
        int aliceLeaveDate = 0;

        int bobArriveDate = 0;
        int bobLeaveDate = 0;

        for (int i = 1; i < aliceArriveMonth; i++) {
            aliceArriveDate += days[i - 1];
        }

        aliceArriveDate += aliceArriveDay;

        for (int i = 1; i < aliceLeaveMonth; i++) {
            aliceLeaveDate += days[i - 1];
        }

        aliceLeaveDate += aliceLeaveDay;

        for (int i = 1; i < bobArriveMonth; i++) {
            bobArriveDate += days[i - 1];
        }

        bobArriveDate += bobArriveDay;

        for (int i = 1; i < bobLeaveMonth; i++) {
            bobLeaveDate += days[i - 1];
        }
        bobLeaveDate += bobLeaveDay;

        if (aliceLeaveDate < bobArriveDate || bobLeaveDate < aliceArriveDate) {
            return 0;
        }

        if (aliceArriveDate <= bobArriveDate && aliceLeaveDate >= bobLeaveDate) {
            return bobLeaveDate - bobArriveDate + 1;
        }

        if (bobArriveDate <= aliceArriveDate && bobLeaveDate >= aliceLeaveDate) {
            return aliceLeaveDate - aliceArriveDate + 1;
        }

        if (aliceArriveDate < bobArriveDate) {
            return Math.min(aliceLeaveDate, bobLeaveDate) - bobArriveDate + 1;
        } else {
            return Math.min(bobLeaveDate, aliceLeaveDate) - aliceArriveDate + 1;
        }
    }

    // Simulate Better time: O(n) space: O(C)
    public static int countDaysTogether_opt(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        if (arriveAlice.compareTo(arriveBob) > 0) {
            return countDaysTogether_opt(arriveBob, leaveBob, arriveAlice, leaveAlice);
        }

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] aliceArriveDate = {Integer.parseInt(arriveAlice.substring(0, 2)), Integer.parseInt(arriveAlice.substring(3, 5))};
        int[] aliceLeaveDate = {Integer.parseInt(leaveAlice.substring(0, 2)), Integer.parseInt(leaveAlice.substring(3, 5))};

        int[] bobArriveDate = {Integer.parseInt(arriveBob.substring(0, 2)), Integer.parseInt(arriveBob.substring(3, 5))};
        int[] bobLeaveDate = {Integer.parseInt(leaveBob.substring(0, 2)), Integer.parseInt(leaveBob.substring(3, 5))};

        int aliceArriveIdx = 0;
        for (int i = 0; i < aliceArriveDate[0] - 1; i++) {
            aliceArriveIdx += days[i];
        }
        aliceArriveIdx += aliceArriveDate[1];

        int aliceLeaveIdx = 0;
        for (int i = 0; i < aliceLeaveDate[0] - 1; i++) {
            aliceLeaveIdx += days[i];
        }
        aliceLeaveIdx += aliceLeaveDate[1];

        int bobArriveIdx = 0;
        for (int i = 0; i < bobArriveDate[0] - 1; i++) {
            bobArriveIdx += days[i];
        }
        bobArriveIdx += bobArriveDate[1];

        int bobLeaveIdx = 0;
        for (int i = 0; i < bobLeaveDate[0] - 1; i++) {
            bobLeaveIdx += days[i];
        }
        bobLeaveIdx += bobLeaveDate[1];

        int ans = 0;

        if (aliceLeaveIdx >= bobArriveIdx) {
            ans = Math.min(aliceLeaveIdx, bobLeaveIdx) - Math.max(aliceArriveIdx, bobArriveIdx) + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println("49 ?= " + countDaysTogether("09-01", "10-19", "06-19", "10-20"));

        System.out.println("3 ?= " + countDaysTogether_opt("08-15", "08-18", "08-16", "08-19"));
        System.out.println("0 ?= " + countDaysTogether_opt("10-01", "10-31", "11-01", "12-31"));
        System.out.println("49 ?= " + countDaysTogether_opt("09-01", "10-19", "06-19", "10-20"));
        System.out.println("1 ?= " + countDaysTogether_opt("08-02", "08-02", "08-02", "08-02"));
    }
}
