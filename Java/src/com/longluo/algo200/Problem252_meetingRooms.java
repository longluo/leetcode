package com.longluo.algo200;

import java.util.Arrays;

/**
 * 252. 会议室
 * <p>
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 请你判断一个人是否能够参加这里面的全部会议。
 * <p>
 * 示例 1：
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 * <p>
 * 提示：
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti < endi <= 10^6
 * <p>
 * https://leetcode.cn/problems/meeting-rooms/
 */
public class Problem252_meetingRooms {

    // BF time: O(n^2) space: O(1)
    public static boolean canAttendMeetings_bf(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) {
            return true;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int[] m1 = intervals[i];
                int[] m2 = intervals[j];

                if (!(m1[1] <= m2[0] || m1[0] >= m2[1])) {
                    return false;
                }
            }
        }

        return true;
    }

    // Sorting time: O(nlogn) space: O(logn)
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + canAttendMeetings_bf(new int[][]{{0, 30}, {5, 10}, {15, 20}}));

        System.out.println("false ?= " + canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println("true ?= " + canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));
    }
}
