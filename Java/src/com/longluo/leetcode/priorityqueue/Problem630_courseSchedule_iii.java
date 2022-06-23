package com.longluo.leetcode.priorityqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 630. 课程表 III
 * <p>
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，
 * 其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
 * <p>
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * 返回你最多可以修读的课程数目。
 * <p>
 * 示例 1：
 * 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * 输出：3
 * 解释：
 * 这里一共有 4 门课程，但是你最多可以修 3 门：
 * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
 * <p>
 * 示例 2：
 * 输入：courses = [[1,2]]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：courses = [[3,2},{4,3]]
 * 输出：0
 * <p>
 * 提示:
 * 1 <= courses.length <= 10^4
 * 1 <= durationi, lastDayi <= 10^4
 * <p>
 * https://leetcode.cn/problems/course-schedule-iii/
 */
public class Problem630_courseSchedule_iii {

    // BF time: O((n+1)!) space: O(n)
    // TLE
    public static int scheduleCourse_bf(int[][] courses) {
        int len = courses.length;
        if (len <= 1) {
            return len;
        }

        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            indexList.add(i + 1);
        }

        List<List<Integer>> permuteList = new ArrayList<>();
        backtrack(permuteList, indexList, new ArrayList<>(), new boolean[len], 0);

        int max = 0;
        for (int i = 0; i < permuteList.size(); i++) {
            List<Integer> path = permuteList.get(i);
            int cnt = 0;
            int time = 0;
            for (int j = 0; j < len; j++) {
                int[] course = courses[path.get(j) - 1];
                if (time + course[0] > course[1] || course[1] <= course[0]) {
                    continue;
                }

                time += course[0];
                cnt++;
            }

            max = Math.max(max, cnt);
        }

        return max;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> numList, List<Integer> path, boolean[] marked, int start) {
        if (start == numList.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < numList.size(); i++) {
            if (marked[i]) {
                continue;
            }

            marked[i] = true;
            path.add(numList.get(i));
            backtrack(res, numList, path, marked, start + 1);
            path.remove(path.size() - 1);
            marked[i] = false;
        }
    }


    public static void main(String[] args) {
        System.out.println("2 ?= " + scheduleCourse_bf(new int[][]{{1, 2}, {2, 3}}));
        System.out.println("3 ?= " + scheduleCourse_bf(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println("4 ?= " + scheduleCourse_bf(new int[][]{{7, 16}, {2, 3}, {3, 12}, {3, 14}, {10, 19}, {10, 16}, {6, 8}, {6, 11}, {3, 13}, {6, 16}}));
    }
}
