package com.longluo.contest.weekly_contest_316;

/**
 * 6214. 判断两个事件是否存在冲突
 * <p>
 * 给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
 * <p>
 * event1 = [startTime1, endTime1] 且
 * event2 = [startTime2, endTime2]
 * 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
 * <p>
 * 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
 * <p>
 * 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出：true
 * 解释：两个事件在 2:00 出现交集。
 * <p>
 * 示例 2：
 * 输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出：true
 * 解释：两个事件的交集从 01:20 开始，到 02:00 结束。
 * <p>
 * 示例 3：
 * 输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * 输出：false
 * 解释：两个事件不存在交集。
 * <p>
 * 提示：
 * evnet1.length == event2.length == 2.
 * event1[i].length == event2[i].length == 5
 * startTime1 <= endTime1
 * startTime2 <= endTime2
 * 所有事件的时间都按照 HH:MM 格式给出
 * <p>
 * https://leetcode.cn/problems/determine-if-two-events-have-conflict/
 */
public class Problem6214_determineIfTwoEventsHaveConflict {

    // Simulate time: O(1) space: O(1)
    public static boolean haveConflict(String[] event1, String[] event2) {
        String evt1StartTime = event1[0];
        String evt1EndTime = event1[1];

        String evt2StartTime = event2[0];
        String evt2EndTime = event2[1];

        int evt1Start = Integer.parseInt(evt1StartTime.substring(0, 2)) * 60 + Integer.parseInt(evt1StartTime.substring(3));
        int evt1End = Integer.parseInt(evt1EndTime.substring(0, 2)) * 60 + Integer.parseInt(evt1EndTime.substring(3));

        int evt2Start = Integer.parseInt(evt2StartTime.substring(0, 2)) * 60 + Integer.parseInt(evt2StartTime.substring(3));
        int evt2End = Integer.parseInt(evt2EndTime.substring(0, 2)) * 60 + Integer.parseInt(evt2EndTime.substring(3));

        if (evt1Start > evt2End || evt2Start > evt1End) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
    }
}
