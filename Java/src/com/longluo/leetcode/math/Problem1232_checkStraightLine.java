package com.longluo.leetcode.math;

/**
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
 * 其中 coordinates[i] = [x, y]表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 * 示例 1：
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * <p>
 * 提示：
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 */
public class Problem1232_checkStraightLine {

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return false;
        }

        if (coordinates.length == 2) {
            return true;
        }

        if (coordinates[0][0] == coordinates[1][0]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            }

            return true;
        }

        if (coordinates[0][1] == coordinates[1][1]) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != coordinates[0][1]) {
                    return false;
                }
            }

            return true;
        }

        int deltaY = coordinates[1][1] - coordinates[0][1];
        int deltaX = coordinates[1][0] - coordinates[0][0];

        float k = (float) deltaY / deltaX;
        float m = coordinates[0][1] - k * coordinates[0][0];

        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][0] * k + m) != coordinates[i][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkStraightLine(new int[][]{{2, 1}, {4, 2}, {6, 3}}));
        System.out.println("true ?= " + checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}}));
    }
}
