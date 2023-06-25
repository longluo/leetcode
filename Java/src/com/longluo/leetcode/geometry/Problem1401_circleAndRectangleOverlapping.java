package com.longluo.leetcode.geometry;

/**
 * 1401. 圆和矩形是否有重叠
 * <p>
 * 给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，
 * 其中 (x1, y1) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。
 * <p>
 * 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。
 * <p>
 * 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
 * <p>
 * 示例 1 ：
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * 输出：true
 * 解释：圆和矩形存在公共点 (1,0) 。
 * <p>
 * 示例 2 ：
 * 输入：radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * 输出：false
 * <p>
 * 示例 3 ：
 * 输入：radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * 输出：true
 * <p>
 * 提示：
 * 1 <= radius <= 2000
 * -10^4 <= xCenter, yCenter <= 10^4
 * -10^4 <= x1 < x2 <= 10^4
 * -10^4 <= y1 < y2 <= 10^4
 * <p>
 * https://leetcode.cn/problems/circle-and-rectangle-overlapping/
 */
public class Problem1401_circleAndRectangleOverlapping {

    // Simulate time: O(n) space: O(1)
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if (x1 <= xCenter && x2 >= xCenter && y1 <= yCenter && y2 >= yCenter) {
            return true;
        }

        int dist1 = (x1 - xCenter) * (x1 - xCenter) + (y1 - yCenter) * (y1 - yCenter);
        int dist2 = (x1 - xCenter) * (x1 - xCenter) + (y2 - yCenter) * (y2 - yCenter);
        int dist3 = (x2 - xCenter) * (x2 - xCenter) + (y2 - yCenter) * (y2 - yCenter);
        int dist4 = (x2 - xCenter) * (x2 - xCenter) + (y1 - yCenter) * (y1 - yCenter);

        if (dist1 <= radius * radius || dist2 <= radius * radius || dist3 <= radius * radius
                || dist4 <= radius * radius) {
            return true;
        }

        if ((Math.abs(x1 - xCenter) <= radius && yCenter >= y1 && yCenter <= y2)
                || (Math.abs(x2 - xCenter) <= radius && yCenter >= y1 && yCenter <= y2)
                || (Math.abs(y1 - yCenter) <= radius && xCenter >= x1 && xCenter <= x2)
                || (Math.abs(y2 - yCenter) <= radius && xCenter >= x1 && xCenter <= x2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println("false ?= " + checkOverlap(1, 1, 1, 1, -3, 2, -1));
        System.out.println("true ?= " + checkOverlap(1, 1, 1, -3, -3, 3, 3));
    }
}
