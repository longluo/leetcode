package com.longluo.top_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 * <p>
 * 中等
 * <p>
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 * 并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * <p>
 * 如果两个区间 至少 共享一个点，则认为它们是重叠的。
 * <p>
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 返回插入之后的 intervals。
 * <p>
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 提示：
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^5
 * intervals 根据 starti 按 升序 排列
 * newInterval.length == 2
 * 0 <= start <= end <= 10^5
 * <p>
 * https://leetcode.cn/problems/insert-interval/
 */
public class Problem57_insertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        int len = intervals.length;
        List<int[]> resIntervals = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            resIntervals.add(intervals[i]);
        }

        int left = newInterval[0];
        int right = newInterval[1];

        for (int i = 0; i < len; ) {
            int start = intervals[i][0];
            int end = intervals[i][1];


        }

        int[][] result = new int[resIntervals.size()][2];


        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = {{1, 3}, {6, 9}};

        insert(test1, new int[]{2, 5});

    }
}
