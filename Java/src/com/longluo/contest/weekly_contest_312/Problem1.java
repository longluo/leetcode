package com.longluo.contest.weekly_contest_312;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1 {

    // Sort time: O(nlogn) space: O(n)
    public static String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        String[][] sorted = new String[len][2];

        for (int i = 0; i < len; i++) {
            sorted[i][0] = names[i];
            sorted[i][1] = String.valueOf(heights[i]);
        }

        Arrays.sort(sorted, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int h1 = Integer.parseInt(o1[1]);
                int h2 = Integer.parseInt(o2[1]);
                return h2 - h1;
            }
        });

        for (int i = 0; i < len; i++) {
            names[i] = sorted[i][0];
        }

        return names;
    }

    public static void main(String[] args) {
        System.out.println("[Mary, Emma, John] ?= " + Arrays.toString(sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }
}
