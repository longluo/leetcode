package com.longluo.contest.biweekly_contest_79;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    public static long maximumImportance(int n, int[][] roads) {
        int[][] cityOrders = new int[n][2];

        for (int i = 0; i < n; i++) {
            cityOrders[i][0] = i;
        }

        for (int[] road : roads) {
            cityOrders[road[0]][1]++;
            cityOrders[road[1]][1]++;
        }

        Arrays.sort(cityOrders, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });


        Map<Integer, Integer> cityMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cityMap.put(cityOrders[i][0], n - i);
        }

        long max = 0;
        for (int[] road : roads) {
            max += (cityMap.get(road[0]) + cityMap.get(road[1]));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("43 ?= " + maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
    }
}
