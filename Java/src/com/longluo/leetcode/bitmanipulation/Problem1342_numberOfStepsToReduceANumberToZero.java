package com.longluo.leetcode.bitmanipulation;

/**
 * 1342. 将数字变成 0 的操作次数
 * <p>
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * <p>
 * 示例 1：
 * 输入：num = 14
 * 输出：6
 * 解释：
 * 步骤 1) 14 是偶数，除以 2 得到 7 。
 * 步骤 2） 7 是奇数，减 1 得到 6 。
 * 步骤 3） 6 是偶数，除以 2 得到 3 。
 * 步骤 4） 3 是奇数，减 1 得到 2 。
 * 步骤 5） 2 是偶数，除以 2 得到 1 。
 * 步骤 6） 1 是奇数，减 1 得到 0 。
 * <p>
 * 示例 2：
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0 。
 * <p>
 * 示例 3：
 * 输入：num = 123
 * 输出：12
 * <p>
 * 提示：
 * 0 <= num <= 10^6
 * <p>
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class Problem1342_numberOfStepsToReduceANumberToZero {

    // BF time: O(logn) space: O(1)
    public static int numberOfSteps(int num) {
        int ans = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ans++;
        }

        return ans;
    }

    // Bit
    public static int numberOfSteps_bit(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num > 1 ? 1 : 0 + num & 0x01;
            num = num >> 1;
        }

        return ans;
    }

    // TODO: 2022/5/28  Math
    // https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/solution/jiang-shu-zi-bian-cheng-0-de-cao-zuo-ci-ucaa4/

    public static void main(String[] args) {
        System.out.println("1 ?= " + numberOfSteps(1));
        System.out.println("2 ?= " + numberOfSteps(2));
        System.out.println("3 ?= " + numberOfSteps(3));
        System.out.println("3 ?= " + numberOfSteps(4));

        System.out.println("1 ?= " + numberOfSteps_bit(1));
        System.out.println("2 ?= " + numberOfSteps_bit(2));
        System.out.println("3 ?= " + numberOfSteps_bit(4));

        System.out.println("12 ?= " + numberOfSteps(123));
    }
}
