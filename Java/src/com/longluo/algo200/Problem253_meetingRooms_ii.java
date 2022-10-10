package com.longluo.algo200;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 * <p>
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 返回 所需会议室的最小数量 。
 * <p>
 * 示例 1：
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= intervals.length <= 10^4
 * 0 <= starti < endi <= 10^6
 * <p>
 * https://leetcode.cn/problems/meeting-rooms-ii/
 */
public class Problem253_meetingRooms_ii {

    // Sorting + PQ time: O(nlogn) space: O(n)
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals.length;
        }

        int len = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
            }
        });

        int min = 1;

        pq.offer(intervals[0]);

        for (int i = 1; i < len; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!pq.isEmpty() && start < pq.peek()[1]) {
                pq.offer(intervals[i]);
                min = Math.max(min, pq.size());
            } else {
                pq.poll();
                pq.offer(intervals[i]);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println("1 ?= " + minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }
}
