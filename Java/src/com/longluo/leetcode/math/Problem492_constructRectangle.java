package com.longluo.leetcode.math;

/**
 * 492. 构造矩形
 * <p>
 * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，
 * 你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 * <p>
 * 1. 你设计的矩形页面必须等于给定的目标面积。
 * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 * <p>
 * 示例：
 * 输入: 4
 * 输出: [2, 2]
 * 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
 * 但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
 * <p>
 * 说明:
 * 给定的面积不大于 10,000,000 且为正整数。
 * 你设计的页面的长度和宽度必须都是正整数。
 * <p>
 * https://leetcode-cn.com/problems/construct-the-rectangle/
 */
public class Problem492_constructRectangle {

    public static int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        for (int i = sqrt; i >= 1; i--) {
            if (i * i == area) {
                return new int[]{i, i};
            } else if (area % i != 0) {
                continue;
            } else if (area % i == 0) {
                if (i >= area / i) {
                    return new int[]{i, area / i};
                } else {
                    return new int[]{area / i, i};
                }
            }
        }

        return new int[]{1, 1};
    }

    public static void main(String[] args) {
        System.out.println("[2, 2] ?= " + constructRectangle(4));
        System.out.println("[3, 1] ?= " + constructRectangle(3));
        System.out.println("[37, 1] ?= " + constructRectangle(37));
    }
}
