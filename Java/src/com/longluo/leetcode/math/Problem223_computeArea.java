package com.longluo.leetcode.math;

/**
 * 223. 矩形面积
 * <p>
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 * <p>
 * 示例 1：
 * Rectangle Area
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * <p>
 * 示例 2：
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 * <p>
 * 提示：
 * -10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/rectangle-area/
 */
public class Problem223_computeArea {

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
        return area1 + area2 - overlapArea;
    }

    public static int computeArea_1(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int wA = Math.abs(ax2 - ax1);
        int hA = Math.abs(ay2 - ay1);

        int wB = Math.abs(bx2 - bx1);
        int hB = Math.abs(by2 - by1);

        int ans = 0;
        int areaA = wA * hA;
        int areaB = wB * hB;
        if (isAContainB(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)) {
            return areaA;
        } else if (isBContainA(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)) {
            return areaB;
        } else if (isASeparateB(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)) {
            return areaA + areaB;
        } else {
            int crossW = 0;
            int crossH = 0;
            if (bx1 >= ax1 && bx1 <= ax2 && bx2 > ax2 && by2 >= ay1 && by2 <= ay2) {
                crossW = ax2 - bx1;
                crossH = ay2 - by1;
            } else if (bx1 >= ax1 && bx1 <= ax2 && bx2 > ax2 && by1 >= ay1 && by1 <= ay2) {
                crossW = ax2 - bx1;
                crossH = ay2 - by1;
            } else if (bx2 >= ax1 && bx2 <= ax2 && bx1 < ax1 && by2 >= ay1 && by2 <= ay2) {
                crossW = bx2 - ax1;
                crossH = by2 - ay1;
            } else if (bx2 >= ax1 && bx2 <= ax2 && bx1 < ax1 && by1 >= ay1 && by1 <= ay2) {
                crossW = bx2 - ax1;
                crossH = ay2 - by1;
            } else if (bx1 <= ax1 && bx2 >= ax2 && by2 >= ay1 && by2 <= ay2) {
                crossW = ax2 - ax1;
                crossH = by2 - ay1;
            } else if (bx1 <= ax1 && bx2 >= ax2 && by1 >= ay1 && by1 <= ay2) {
                crossW = ax2 - ax1;
                crossH = ay2 - by1;
            } else if (bx1 >= ax1 && bx2 <= ax2 && by2 >= ay1 && by2 <= ay2) {
                crossW = bx2 - bx1;
                crossH = by2 - ay1;
            } else if (bx1 >= ax1 && bx2 <= ax2 && by1 >= ay1 && by1 <= ay2) {
                crossW = bx2 - bx1;
                crossH = ay2 - by1;
            } else if (by1 <= ay1 && by2 >= ay2 && bx1 >= ax1 && bx1 <= ax2) {
                crossW = ax2 - bx1;
                crossH = ay2 - ay1;
            } else if (by1 >= ay1 && by2 <= ay2 && bx1 >= ax1 && bx1 <= ax2) {
                crossW = ax2 - bx1;
                crossH = by2 - by1;
            } else if (by1 <= ay1 && by2 >= ay2 && bx2 >= ax1 && bx2 <= ax2) {
                crossW = bx2 - ax1;
                crossH = ay2 - ay1;
            } else if (by1 >= ay1 && by2 <= ay2 && bx2 >= ax1 && bx2 <= ax2) {
                crossW = ax2 - bx1;
                crossH = by2 - by1;
            }

            return areaA + areaB - crossW * crossH;
        }
    }

    public static boolean isAContainB(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax1 <= bx1 && ay1 <= by1 && ax2 >= bx2 && ay2 >= by2) {
            return true;
        }

        return false;
    }

    public static boolean isBContainA(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax1 >= bx1 && ay1 >= by1 && ax2 <= bx2 && ay2 <= by2) {
            return true;
        }

        return false;
    }

    public static boolean isASeparateB(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (bx1 >= ax2 || ax1 >= bx2 || by1 >= ay2 || ay1 >= by2) {
            return true;
        }

        return false;
    }

    public static boolean isAcrossBRight(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (bx1 >= ax1 && bx1 <= ax2 && by2 >= ay1 && by2 <= ay2) {
            return true;
        }

        return false;
    }

    public static boolean isAcrossBLeft(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (bx2 >= ax1 && bx2 <= ax2 && by1 >= ay1 && by2 <= ay2) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("45 ?= " + computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println("16 ?= " + computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println("24 ?= " + computeArea(-2, -2, 2, 2, -2, 2, 2, 4));
        System.out.println("19 ?= " + computeArea(-2, -2, 2, 2, 1, 1, 3, 3));
        System.out.println("19 ?= " + computeArea(-2, -2, 2, 2, -3, 1, -1, 3));
        System.out.println("24 ?= " + computeArea(-2, -2, 2, 2, -3, -3, 3, -1));
        System.out.println("24 ?= " + computeArea(-2, -2, 2, 2, 1, -3, 3, 3));
        System.out.println("24 ?= " + computeArea(-3, -3, 3, -1, -2, -2, 2, 2));
        System.out.println("45 ?= " + computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
