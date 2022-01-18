package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 539. 最小时间差
 * <p>
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * <p>
 * 提示：
 * 2 <= timePoints <= 2 * 10^4
 * timePoints[i] 格式为 "HH:MM"
 * <p>
 * https://leetcode-cn.com/problems/minimum-time-difference/
 */
public class Problem539_minimumTimeDifference {

    public static int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int ans = 12 * 60;
        for (int i = 0; i < len; i++) {
            String time1 = timePoints.get(i);
            for (int j = i + 1; j < len; j++) {
                String time2 = timePoints.get(j);
                int hour1 = Integer.parseInt(time1.substring(0, 2));
                int hour2 = Integer.parseInt(time2.substring(0, 2));
                int min1 = Integer.parseInt(time1.substring(3, 5));
                int min2 = Integer.parseInt(time1.substring(3, 5));

                int diff = Math.abs(hour1 - hour2);
                if (diff > 12) {

                }
            }
        }

        return ans;
    }

    public static int findMinDifference_sort(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String time1, String time2) {
                int hour1 = Integer.parseInt(time1.substring(0, 2));
                int hour2 = Integer.parseInt(time2.substring(0, 2));
                int min1 = Integer.parseInt(time1.substring(3, 5));
                int min2 = Integer.parseInt(time1.substring(3, 5));
                if (hour1 == hour2) {
                    return min1 - min2;
                }
                return hour1 - hour2;
            }
        });

        int ans = 12 * 60;


        return ans;
    }

    public static void main(String[] args) {
        List<String> tst1 = new ArrayList<>();
        tst1.add("23:59");
        tst1.add("00:00");
        System.out.println("1 ?= " + findMinDifference(tst1));

        List<String> tst2 = new ArrayList<>();
        tst2.add("00:00");
        tst2.add("23:59");
        tst2.add("00:00");
        System.out.println("0 ?= " + findMinDifference(tst2));
    }
}
