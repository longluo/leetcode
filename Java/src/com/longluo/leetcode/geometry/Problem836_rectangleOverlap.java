package com.longluo.leetcode.geometry;

/**
 * 836. 矩形重叠
 * <p>
 * https://leetcode.cn/problems/rectangle-overlap/description/
 */
public class Problem836_rectangleOverlap {

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec2[0] >= rec1[2] || rec2[3] <= rec1[1]
                || rec2[1] >= rec1[3] || rec2[2] <= rec1[0]) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println("false ?= " + isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
    }
}
