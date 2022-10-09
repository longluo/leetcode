package com.longluo.contest.weekly_contest_310;

import java.util.Arrays;
import java.util.Comparator;

public class Problem3 {

    public int minGroups(int[][] intervals) {
        int len = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });


        int ans = len;
        return ans;
    }

    public static void main(String[] args) {

    }
}
