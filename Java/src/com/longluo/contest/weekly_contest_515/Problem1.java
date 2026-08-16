package com.longluo.contest.weekly_contest_515;

/**
 * 4024. 最近的可用无人机
 * <p>
 * https://leetcode.cn/problems/nearest-available-drone/description/
 */
public class Problem1 {

    public static int nearestDrone(int[][] drones, int[] target) {
        int minDistance = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < drones.length; i++) {
            int[] curDrone = drones[i];
            int distance = Math.abs(curDrone[0] - target[0]) + Math.abs(curDrone[1] - target[1]);
            if (distance > curDrone[2]) {
                continue;
            }

            if (distance < minDistance) {
                minDistance = distance;
                ans = i;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + nearestDrone(new int[][]{{0, 0, 8}, {2, 2, 9}}, new int[]{3, 4}));
    }
}
