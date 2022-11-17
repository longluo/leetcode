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
 * https://leetcode.cn/problems/rectangle-area/
 */
public class Problem223_computeArea {

    // Simulate time: O(1) space: O(1)
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax1 > bx1) {
            return computeArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        }

        int wA = Math.abs(ax2 - ax1);
        int hA = Math.abs(ay2 - ay1);

        int wB = Math.abs(bx2 - bx1);
        int hB = Math.abs(by2 - by1);

        int areaA = wA * hA;
        int areaB = wB * hB;

        // No Overlap
        // 3 Conditions
        if (ay2 <= by1 || ax2 <= bx1 || ay1 >= by2) {
            return areaA + areaB;
        } else {
            int overlapW = Math.min(ax2, bx2) - bx1;
            int overlapH = Math.min(ay2, by2) - Math.max(ay1, by1);
            return areaA + areaB - overlapW * overlapH;
        }
    }

    // Geometry time: O(1) space: O(1)
    public static int computeArea_math(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);

        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);

        return areaA + areaB - overlapArea;
    }


    public static void main(String[] args) {
        System.out.println("45 ?= " + computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println("16 ?= " + computeArea(-2, -2, 2, 2, -2, -2, 2, 2));

        System.out.println("45 ?= " + computeArea_math(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println("16 ?= " + computeArea_math(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println("24 ?= " + computeArea_math(-2, -2, 2, 2, -2, 2, 2, 4));
        System.out.println("19 ?= " + computeArea_math(-2, -2, 2, 2, 1, 1, 3, 3));
        System.out.println("19 ?= " + computeArea_math(-2, -2, 2, 2, -3, 1, -1, 3));
        System.out.println("24 ?= " + computeArea_math(-2, -2, 2, 2, -3, -3, 3, -1));
        System.out.println("24 ?= " + computeArea_math(-2, -2, 2, 2, 1, -3, 3, 3));
        System.out.println("24 ?= " + computeArea_math(-3, -3, 3, -1, -2, -2, 2, 2));
        System.out.println("45 ?= " + computeArea_math(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
