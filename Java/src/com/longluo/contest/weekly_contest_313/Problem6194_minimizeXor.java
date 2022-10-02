package com.longluo.contest.weekly_contest_313;

/**
 * 6194. 最小 XOR
 *
 * 给你两个正整数 num1 和 num2 ，找出满足下述条件的整数 x ：
 * x 的置位数和 num2 相同，且
 * x XOR num1 的值 最小
 * 注意 XOR 是按位异或运算。
 *
 * 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
 * 整数的 置位数 是其二进制表示中 1 的数目。
 *
 * 示例 1：
 * 输入：num1 = 3, num2 = 5
 * 输出：3
 * 解释：
 * num1 和 num2 的二进制表示分别是 0011 和 0101 。
 * 整数 3 的置位数与 num2 相同，且 3 XOR 3 = 0 是最小的。
 *
 * 示例 2：
 * 输入：num1 = 1, num2 = 12
 * 输出：3
 * 解释：
 * num1 和 num2 的二进制表示分别是 0001 和 1100 。
 * 整数 3 的置位数与 num2 相同，且 3 XOR 1 = 2 是最小的。
 *
 * 提示：
 * 1 <= num1, num2 <= 10^9
 *
 * https://leetcode.cn/problems/minimize-xor/
 */
public class Problem6194_minimizeXor {

    // Greedy time: O(log(num1) + log(num2)) space: O(1)
    public static int minimizeXor(int num1, int num2) {
        int cnt1 = 0;
        int cnt2 = 0;

        int p1 = num1;
        int p2 = num2;

        for (int i = 0; i < 32 && p1 != 0; i++) {
            cnt1 += (p1 & 0x01) == 1 ? 1 : 0;
            p1 = p1 >> 1;
        }

        for (int i = 0; i < 32 && p2 != 0; i++) {
            cnt2 += (p2 & 0x01) == 1 ? 1 : 0;
            p2 = p2 >> 1;
        }

        int ans = num1;
        int diff = Math.abs(cnt1 - cnt2);
        int base = 1;

        if (cnt1 == cnt2) {
            return num1;
        } else if (cnt1 > cnt2) {
            while (diff > 0) {
                if ((num1 & 0x01) == 1) {
                    diff--;
                    ans -= base;
                }

                base *= 2;
                num1 = num1 >> 1;
            }
        } else {
            while (diff > 0) {
                if ((num1 & 0x01) == 0) {
                    diff--;
                    ans += base;
                }

                base *= 2;
                num1 = num1 >> 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minimizeXor(3, 5));
        System.out.println("3 ?= " + minimizeXor(1, 12));
    }
}
