package com.longluo.LCCUP.LCCUP_2020_Fall_Personal;

/**
 * LCP 17. 速算机器人
 * <p>
 * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 * <p>
 * "A" 运算：使 x = 2 * x + y；
 * "B" 运算：使 y = 2 * y + x。
 * <p>
 * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，
 * 字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 * <p>
 * 示例 1：
 * 输入：s = "AB"
 * 输出：4
 * 解释：
 * 经过一次 A 运算后，x = 2, y = 0。
 * 再经过一次 B 运算，x = 2, y = 2。
 * 最终 x 与 y 之和为 4。
 * <p>
 * 提示：
 * 0 <= s.length <= 10
 * s 由 'A' 和 'B' 组成
 * <p>
 * https://leetcode.cn/problems/nGK0Fy/
 */
public class T1_LCP17_calculate {

    // Simulate time: O(n) space: O(1)
    public static int calculate(String s) {
        int x = 1;
        int y = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }

        return x + y;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + calculate("AB"));
    }
}