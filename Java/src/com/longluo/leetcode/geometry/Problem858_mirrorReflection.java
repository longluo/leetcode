package com.longluo.leetcode.geometry;

/**
 * 858. 镜面反射
 * <p>
 * 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
 * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 * <p>
 * 示例：
 * 输入： p = 2, q = 1
 * 输出： 2
 * 解释： 这条光线在第一次被反射回左边的墙时就遇到了接收器 2 。
 * <p>
 * 提示：
 * 1 <= p <= 1000
 * 0 <= q <= p
 * <p>
 * https://leetcode.cn/problems/mirror-reflection/
 */
public class Problem858_mirrorReflection {

    // Math time: O(1) space: O(1)
    public static int mirrorReflection(int p, int q) {
        if (p == q) {
            return 1;
        }

        if (q == 0) {
            return 0;
        }

        int lcm = p * q / gcd(p, q);
        int x = lcm / p;
        int y = lcm / q;

        if (x % 2 == 1 && y % 2 == 1) {
            return 1;
        } else if (x % 2 == 0 && y % 2 == 1) {
            return 0;
        } else {
            return 2;
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + mirrorReflection(2, 1));
    }
}
