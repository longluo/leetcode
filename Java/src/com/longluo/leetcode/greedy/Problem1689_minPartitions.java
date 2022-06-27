package com.longluo.leetcode.greedy;

/**
 * 1689. 十-二进制数的最少数目
 * <p>
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。
 * 例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 * <p>
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 * <p>
 * 示例 1：
 * 输入：n = "32"
 * 输出：3
 * 解释：10 + 11 + 11 = 32
 * <p>
 * 示例 2：
 * 输入：n = "82734"
 * 输出：8
 * <p>
 * 示例 3：
 * 输入：n = "27346209830709182346"
 * 输出：9
 * <p>
 * 提示：
 * 1 <= n.length <= 10^5
 * n 仅由数字组成
 * n 不含任何前导零并总是表示正整数
 * <p>
 * https://leetcode.cn/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */
public class Problem1689_minPartitions {

    // Greedy time: O(nlogn) space: O(n)
    public static int minPartitions_simulate(String n) {
        int min = 0;
        while (!check(n)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n.length(); i++) {
                char ch = n.charAt(i);
                if (i == 0 && ch == '1') {
                    continue;
                } else if (ch >= '1') {
                    sb.append((char) (ch - 1));
                } else if (ch == '0') {
                    sb.append('0');
                }
            }

            min++;
            n = sb.toString();
        }

        return min + 1;
    }

    public static boolean check(String n) {
        for (char ch : n.toCharArray()) {
            if (!(ch == '0' || ch == '1')) {
                return false;
            }
        }

        return true;
    }

    // Greedy time: O(n) space: O(1)
    public static int minPartitions(String n) {
        int ans = 0;
        for (char ch : n.toCharArray()) {
            ans = Math.max(ans, ch - '0');
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minPartitions_simulate("32"));
        System.out.println("8 ?= " + minPartitions_simulate("82734"));
        System.out.println("9 ?= " + minPartitions_simulate("27346209830709182346"));

        System.out.println("8 ?= " + minPartitions("82734"));
        System.out.println("9 ?= " + minPartitions("27346209830709182346"));
    }
}
