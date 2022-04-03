package com.longluo.contest.weekly_contest_287;

public class Problem1 {

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
