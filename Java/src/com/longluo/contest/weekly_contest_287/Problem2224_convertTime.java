package com.longluo.contest.weekly_contest_287;

/**
 * 2224. 转化时间需要的最少操作数
 * <p>
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * <p>
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * <p>
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * <p>
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 * <p>
 * 示例 1：
 * 输入：current = "02:30", correct = "04:35"
 * 输出：3
 * 解释：
 * 可以按下述 3 步操作将 current 转换为 correct ：
 * - 为 current 加 60 分钟，current 变为 "03:30" 。
 * - 为 current 加 60 分钟，current 变为 "04:30" 。
 * - 为 current 加 5 分钟，current 变为 "04:35" 。
 * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
 * <p>
 * 示例 2：
 * 输入：current = "11:00", correct = "11:01"
 * 输出：1
 * 解释：只需要为 current 加一分钟，所以最小操作数是 1 。
 * <p>
 * 提示：
 * current 和 correct 都符合 "HH:MM" 格式
 * current <= correct
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-operations-to-convert-time/
 */
public class Problem2224_convertTime {

    // TODO: 2022/6/2  
    public static int convertTime(String current, String correct) {
        if (current.equals(correct)) {
            return 0;
        }

        String[] curStrs = current.split(":");
        String[] crtStrs = correct.split(":");
        int curHour = Integer.parseInt(curStrs[0]);
        int curMin = Integer.parseInt(curStrs[1]);
        int crtHour = Integer.parseInt(crtStrs[0]);
        int crtMin = Integer.parseInt(crtStrs[1]);
        int ans = 0;

        if (crtHour >= curHour) {
            ans += crtHour - curHour;
        } else {
            ans += 24 - curHour + crtHour;
        }

        int mins = 0;
        if (crtMin >= curMin) {
            mins += crtMin - curMin;
        } else {
            mins += 60 - curMin + crtMin;
            ans--;
        }

        ans += mins / 15;
        mins = mins - 15 * (mins / 15);

        ans += mins / 5;
        mins = mins - 5 * (mins / 5);

        ans += mins;

        return ans;
    }

    public static void main(String[] args) {
        convertTime("02:30", "04:35");
        convertTime("00:00", "23:59");
        convertTime("09:41", "10:34");
    }
}
