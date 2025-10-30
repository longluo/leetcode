package com.longluo.contest.weekly_contest_343;

/**
 * https://leetcode.cn/contest/weekly-contest-343
 */
public class Problem3 {

    public static int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int ans = Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1]);

        int[][] spCost = new int[specialRoads.length][];

        for (int i = 0; i < specialRoads.length; i++) {
            int[] road = specialRoads[i];
            spCost[i][0] = Math.abs(road[2] - road[0]) + Math.abs(road[3] - road[1]);
            spCost[i][1] = road[4];
        }




        return ans;
    }

    public static void main(String[] args) {

    }
}