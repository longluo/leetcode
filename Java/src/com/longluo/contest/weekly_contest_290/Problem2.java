package com.longluo.contest.weekly_contest_290;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {

    public static int countLatticePoints(int[][] circles) {
        Set<String> points = new HashSet<>();

        for (int[] circle : circles) {
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];

            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    int dist = (i - x) * (i - x) + (j - y) * (j - y);
                    if (dist <= r * r) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i).append(",").append(j);
                        points.add(sb.toString());
                    }
                }
            }
        }

        return points.size();
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + countLatticePoints(new int[][]{{2, 2, 1}}));
        System.out.println("16 ?= " + countLatticePoints(new int[][]{{2, 2, 2}, {3, 4, 1}}));
    }
}
