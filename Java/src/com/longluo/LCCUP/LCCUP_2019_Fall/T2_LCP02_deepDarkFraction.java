package com.longluo.LCCUP.LCCUP_2019_Fall;

import java.util.Arrays;

/**
 * LCP 02. 分式化简
 * <p>
 * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 * <p>
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 * <p>
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，
 * 使得连分数的值等于n / m，且n, m最大公约数为1。
 * <p>
 * 示例 1：
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * <p>
 * 示例 2：
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * <p>
 * 限制：
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 * <p>
 * https://leetcode.cn/problems/deep-dark-fraction/
 */
public class T2_LCP02_deepDarkFraction {

    // Simulate time: O(n) space: O(1)
    public static int[] fraction(int[] cont) {
        int n = cont.length;

        int numerator = 1;
        int denominator = cont[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int part = cont[i];

            numerator = denominator * part + numerator;

            int temp = numerator;
            numerator = denominator;
            denominator = temp;
        }

        return new int[]{denominator, numerator};
    }

    public static void main(String[] args) {
        System.out.println("[13, 4] ?= " + Arrays.toString(fraction(new int[]{3, 2, 0, 2})));
        System.out.println("[3, 1] ?= " + Arrays.toString(fraction(new int[]{0, 0, 3})));
    }
}
